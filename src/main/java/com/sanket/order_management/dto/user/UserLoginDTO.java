package com.sanket.order_management.dto.user;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String email;
    private String password;
}