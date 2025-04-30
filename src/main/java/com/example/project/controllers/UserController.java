package com.example.project.controllers;

import com.example.project.DTO.UserDTO;
import com.example.project.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PutMapping("/pending-users/{id}")
    public ResponseEntity<String> approveUser(@PathVariable Long id) {
        userService.approveUser(id);
        return ResponseEntity.ok("User approved!");
    }
    @GetMapping("/pending-users")
    public ResponseEntity<Page<UserDTO>> getPendingUsers(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Page<UserDTO> pendingUsers = userService.getPendingUsers(PageRequest.of(page, size));
        return ResponseEntity.ok(pendingUsers);
    }
    @GetMapping("/all-users")
    public ResponseEntity<Page<UserDTO>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Page<UserDTO> users = userService.getUsers(PageRequest.of(page, size));
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/all-users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted!");
    }
}
