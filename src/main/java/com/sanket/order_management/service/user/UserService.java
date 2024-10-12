package com.sanket.order_management.service.user;

import com.sanket.order_management.dto.user.UserLoginDTO;
import com.sanket.order_management.dto.user.UserRequestDTO;
import com.sanket.order_management.dto.user.UserResponseDTO;
import com.sanket.order_management.model.User;
import com.sanket.order_management.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setAddress(userRequestDTO.getAddress());
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword())); // Encrypt password

        User savedUser = userRepository.save(user);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(savedUser.getUserId());
        responseDTO.setUsername(savedUser.getFirstName() + savedUser.getLastName());
        responseDTO.setEmail(savedUser.getEmail());
        return responseDTO;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> userOpt = userRepository.findByEmail(loginDTO.getEmail());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());
        }
        return false;
    }

    public void resetPassword(String email, String newPassword) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }
    }
}
