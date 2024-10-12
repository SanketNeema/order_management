package com.sanket.order_management.dto.user;

import lombok.Data;

@Data
public class UserRequestDTO {
	private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
}
