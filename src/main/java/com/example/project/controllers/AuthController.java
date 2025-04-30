package com.example.project.controllers;

import com.example.project.DTO.UserDTO;
import com.example.project.mappers.UserMapper;
import com.example.project.models.User;
import com.example.project.services.JwtCore;
import com.example.project.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtCore jwtCore;
    public AuthController(UserService userService, UserMapper userMapper,JwtCore jwtCore) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.jwtCore = jwtCore;
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signup(@RequestBody User input) {
        User user = userService.registerUser(input);
        return new ResponseEntity<>(userMapper.userToUserDTO(user), HttpStatus.CREATED);
    }
    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody User input) {
        User user = userService.verify(input);
        return new ResponseEntity<>(jwtCore.generateToken(user), HttpStatus.OK);
    }
}
