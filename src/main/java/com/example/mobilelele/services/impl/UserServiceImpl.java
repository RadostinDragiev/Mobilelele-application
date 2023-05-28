package com.example.mobilelele.services.impl;

import com.example.mobilelele.models.entities.Role;
import com.example.mobilelele.models.entities.User;
import com.example.mobilelele.repositories.UserRepository;
import com.example.mobilelele.services.UserRoleService;
import com.example.mobilelele.services.UserService;
import com.example.mobilelele.util.ValidationUtil;
import com.example.mobilelele.web.dtos.AuthUserDto;
import com.example.mobilelele.web.dtos.RegisterUserDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserRoleService userRoleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userRoleService = userRoleService;
    }

    @Override
    public User login(AuthUserDto authUserDto) {
        return this.userRepository.findUserByUsernameAndPassword(authUserDto.getUsername(), authUserDto.getPassword());
    }

    @Override
    public boolean register(RegisterUserDto registerUserDto) {
        User user = this.modelMapper.map(registerUserDto, User.class);
        user.setActive(true);
        LocalDateTime now = LocalDateTime.now();
        user.setCreated(now);
        user.setModified(now);
        user.setRole(this.userRoleService.getUserRoleByRole(Role.valueOf(registerUserDto.getRoles())));

        if (this.validationUtil.isValid(user)) {
            try {
                this.userRepository.saveAndFlush(user);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            return true;
        } else {
            this.validationUtil.getViolations(user).forEach(v -> log.error(v.getMessage()));
            return false;
        }
    }
}
