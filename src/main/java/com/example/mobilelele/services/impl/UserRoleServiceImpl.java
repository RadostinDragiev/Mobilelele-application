package com.example.mobilelele.services.impl;

import com.example.mobilelele.models.entities.Role;
import com.example.mobilelele.models.entities.UserRole;
import com.example.mobilelele.repositories.UserRoleRepository;
import com.example.mobilelele.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole getUserRoleByRole(Role role) {
        UserRole userRole = this.userRoleRepository.findUserRoleByRole(role);
        if (userRole == null) {
            return this.userRoleRepository.saveAndFlush(new UserRole(role));
        }
        return userRole;
    }
}
