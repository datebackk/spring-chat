package api.controller;

import api.dto.UserDTO;
import api.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import model.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import security.service.AuthService;
import service.exception.StorageException;
import service.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthService authService;

    @Value("${storage.location}")
    private String storageLocation;

    private Path rootLocation;


    @GetMapping("/user/{nickname}")
    public ResponseEntity<?> getUserByNickname(@PathVariable String nickname) {
        List<UserDTO> userDTOS = userMapper.listToDTO(userService.findByNicknameIgnoreCaseContains(nickname));
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @PostMapping("/user/avatar")
    public ResponseEntity<?> uploadUserAvatar(@RequestParam("file") MultipartFile file, HttpServletRequest req) {

        this.rootLocation = Paths.get(storageLocation);
        User user = authService.whoami(req);
        String filename = user.getId().toString() + ".png";


        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }

            if (!Files.exists(this.rootLocation)) {
                Files.createDirectories(this.rootLocation);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }

        user.setUserImg(filename);
        userService.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
