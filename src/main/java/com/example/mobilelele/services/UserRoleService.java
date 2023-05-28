package com.example.mobilelele.services;

import com.example.mobilelele.models.entities.Role;
import com.example.mobilelele.models.entities.UserRole;

public interface UserRoleService {
    UserRole getUserRoleByRole(Role role);
}
