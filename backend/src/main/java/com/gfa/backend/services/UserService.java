package com.gfa.backend.services;

import com.gfa.backend.dtos.LoginRequestDto;
import com.gfa.backend.dtos.LoginResponseDto;
import com.gfa.backend.dtos.RegisterRequestDto;
import com.gfa.backend.dtos.RegisterResponseDto;
import com.gfa.backend.models.User;

import javax.naming.AuthenticationException;
import java.util.Optional;

public interface UserService {
    LoginResponseDto login(LoginRequestDto dto);
    RegisterResponseDto register(RegisterRequestDto dto) throws AuthenticationException;
    String generateToken(String email, String password);
    boolean isUsernameInDatabase(String username);
}
