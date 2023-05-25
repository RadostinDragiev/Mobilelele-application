package com.example.mobilelele.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends BaseEntity{
    @Enumerated
    private Role role;
}
