package com.example.mobilelele.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDto {
    @Length(min = 2, message = "Username is too short")
    private String username;
    @Length(min = 2, message = "Password is too short")
    private String password;
}
