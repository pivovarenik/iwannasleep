package com.example.project.services;


import com.example.project.DTO.UserDTO;
import com.example.project.mappers.UserMapper;
import com.example.project.models.User;
import com.example.project.repos.UserRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    public UserService(UserRepo userRepo,PasswordEncoder passwordEncoder,AuthenticationManager authenticationManager, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }


    /* Queries */

    public User verify(User input) {
        Authentication auth =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPasswordHash()));
        if (auth.isAuthenticated()) {
            UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
            String username = userDetails.getUsername();
            Optional<User> userFromDb = userRepo.findByUsername(username);
            User user = userFromDb.orElseThrow(NoSuchElementException::new);
            if (!user.isApproved()) {
                throw new AccessDeniedException("Your account is not approved yet.");
            }
            return userFromDb.get();
        } else {
            throw new NoSuchElementException();
        }
    }
    /* Commands */
    public User registerUser(User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setApproved(!user.getRole().equals("Marketer"));
        return userRepo.save(user);
    }
    public void approveUser(Long id) {
        User user = userRepo.findById(id).orElseThrow();
        user.setApproved(true);
        userRepo.save(user);
    }
    public Page<UserDTO> getPendingUsers(Pageable pageable) {
        Page<User> users = userRepo.findByApprovedFalse(pageable);
        return users.map(userMapper::userToUserDTO);
    }
    public Page<UserDTO> getUsers(Pageable pageable) {
        Page<User> users = userRepo.findAll(pageable);
        return users.map(userMapper::userToUserDTO);
    }
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
