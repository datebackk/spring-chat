package api.controller;


import api.dto.JwtAuthenticationResponse;
import api.dto.LoginUserDTO;
import io.swagger.annotations.ApiParam;
import model.model.Role;
import model.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import api.dto.UserDataDTO;
import api.dto.UserResponseDTO;
import security.service.AuthService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/signin")
    public String login(//
                        @RequestParam String email, //
                        @RequestParam String password) {
        return authService.signin(email, password);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> login(@ApiParam("Signin User") @RequestBody LoginUserDTO user) {
        String token = authService.signin(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }


    @DeleteMapping(value = "/{email}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@PathVariable String email) {
        authService.delete(email);
        return email;
    }

    @GetMapping(value = "/{email}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDTO search(@PathVariable String email) {
        return modelMapper.map(authService.search(email), UserResponseDTO.class);
    }


    @GetMapping(value = "/me")
    public ResponseEntity<?> whoami(HttpServletRequest req) {
        return ResponseEntity.ok(modelMapper.map(authService.whoami(req), UserResponseDTO.class));
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req) {
        return authService.refresh(req.getRemoteUser());
    }

}

