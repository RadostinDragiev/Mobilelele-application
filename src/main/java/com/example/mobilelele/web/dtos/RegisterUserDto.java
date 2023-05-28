package com.example.mobilelele.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String roles;
}
