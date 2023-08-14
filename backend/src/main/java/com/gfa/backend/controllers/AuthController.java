package com.gfa.backend.controllers;

import com.gfa.backend.dtos.ErrorResponseDto;
import com.gfa.backend.dtos.LoginRequestDto;
import com.gfa.backend.dtos.RegisterRequestDto;
import com.gfa.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.status(200).body(userService.login(dto));
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegisterRequestDto dto) throws AuthenticationException {
        return ResponseEntity.status(200).body(userService.register(dto));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> illegalArgumentExceptionHandler(Exception e){
        return ResponseEntity.status(400).body(new ErrorResponseDto(e.getMessage()));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponseDto> authenticationExceptionHandler(Exception e){
        return ResponseEntity.status(409).body(new ErrorResponseDto(e.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDto> noSuchElementExceptionExceptionHandler(Exception e){
        return ResponseEntity.status(404).body(new ErrorResponseDto(e.getMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    private ResponseEntity<ErrorResponseDto> badCredentialExceptionHandler(Exception e) {
        return ResponseEntity.status(401).body(new ErrorResponseDto(e.getMessage()));
    }
}
