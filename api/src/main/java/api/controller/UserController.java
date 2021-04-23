package api.controller;

import api.dto.UserDTO;
import api.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/user/{nickname}")
    public ResponseEntity<?> getUserByNickname(@PathVariable String nickname) {
        List<UserDTO> userDTOS = userMapper.listToDTO(userService.findByNicknameContains(nickname));
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }
}
