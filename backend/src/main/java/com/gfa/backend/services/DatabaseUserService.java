package com.gfa.backend.services;

import com.gfa.backend.dtos.LoginRequestDto;
import com.gfa.backend.dtos.LoginResponseDto;
import com.gfa.backend.dtos.RegisterRequestDto;
import com.gfa.backend.dtos.RegisterResponseDto;
import com.gfa.backend.models.User;
import com.gfa.backend.repositories.UserRepository;
import com.gfa.backend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DatabaseUserService implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        if (dto == null) throw new IllegalArgumentException("Request body is empty");
        if (dto.getUsername() == null || dto.getUsername().isEmpty()) throw new IllegalArgumentException("Username is required");
        if (dto.getUsername().length() < 4) throw new IllegalArgumentException("Invalid username");
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) throw new IllegalArgumentException("Password is required");
        if (dto.getPassword().length() < 8) throw new IllegalArgumentException("Invalid password");
        if (!isUsernameInDatabase(dto.getUsername())) throw new BadCredentialsException("Unregistered user");
        return new LoginResponseDto("ok", generateToken(dto.getUsername(), dto.getPassword()), userRepository.findUserByUsername(dto.getUsername()).get().getDollars());
    }

    @Override
    public RegisterResponseDto register(RegisterRequestDto dto) throws AuthenticationException {
        if (dto == null) throw new IllegalArgumentException("Request body is empty");
        if (dto.getUsername() == null || dto.getUsername().isEmpty()) throw new IllegalArgumentException("Username is required");
        if (dto.getUsername().length() < 4) throw new IllegalArgumentException("Username must be at least 4 characters long");
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) throw new IllegalArgumentException("Password is required");
        if (dto.getPassword().length() < 8) throw new IllegalArgumentException("Password must be at least 8 characters long");
        if (isUsernameInDatabase(dto.getUsername())) throw new AuthenticationException("Username is already taken");
        User user = new User(dto.getUsername(), dto.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new RegisterResponseDto("ok");
    }

    @Override
    public String generateToken(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public boolean isUsernameInDatabase(String username) {
        return userRepository.existsByUsername(username);
    }
}
