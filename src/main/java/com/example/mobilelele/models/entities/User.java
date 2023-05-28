package com.example.mobilelele.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Length(min = 2, message = "Username is too short")
    @NotNull
    @Column(unique = true)
    String username;
    @Length(min = 2, message = "Password is too short")
    @NotNull
    private String password;
    @Column(name = "first_name")
    @NotNull
    private String firstName;
    @Column(name = "last_name")
    @NotNull
    private String lastName;
    private boolean isActive;
    @ManyToOne
    private UserRole role;
    private String imageUrl;
    private LocalDateTime created;
    private LocalDateTime modified;
}
