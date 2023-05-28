package com.example.mobilelele.repositories;

import com.example.mobilelele.models.entities.Role;
import com.example.mobilelele.models.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    UserRole findUserRoleByRole(Role role);
}
