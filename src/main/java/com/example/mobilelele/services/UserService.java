package com.example.mobilelele.services;

import com.example.mobilelele.models.entities.User;
import com.example.mobilelele.web.dtos.AuthUserDto;
import com.example.mobilelele.web.dtos.RegisterUserDto;

public interface UserService {
    User login(AuthUserDto authUserDto);

    boolean register(RegisterUserDto registerUserDto);
}
