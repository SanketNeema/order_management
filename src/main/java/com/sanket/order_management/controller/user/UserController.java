package com.sanket.order_management.controller.user;

import com.sanket.order_management.dto.user.UserLoginDTO;
import com.sanket.order_management.dto.user.UserRequestDTO;
import com.sanket.order_management.dto.user.UserResponseDTO;
import com.sanket.order_management.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
    	
    	//TODO: add validations
        UserResponseDTO userResponseDTO = userService.addUser(userRequestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
    	
    	//TODO: add validations
        boolean isLoginSuccessful = userService.login(userLoginDTO);
        if (isLoginSuccessful) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PutMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email, @RequestParam String newPassword) {
        userService.resetPassword(email, newPassword);
        return ResponseEntity.ok("Password reset successful");
    }
}
