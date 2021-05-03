package api.controller;

import api.dto.JwtAuthenticationResponse;
import api.dto.LoginUserDTO;
import api.dto.UserDTO;
import api.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.service.AuthService;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserMapper userMapper;


    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO user) {
        String token = authService.signin(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(new JwtAuthenticationResponse(token), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDTO user) {
        String token = authService.signup(userMapper.toEntity(user));
        return new ResponseEntity<>(new JwtAuthenticationResponse(token), HttpStatus.CREATED);
    }

    @GetMapping(value = "/me")
//    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> whoami(HttpServletRequest req) {
        return new ResponseEntity<>(userMapper.toDTO(authService.whoami(req)), HttpStatus.OK);
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest req) {
        return authService.refresh(req.getRemoteUser());
    }

}