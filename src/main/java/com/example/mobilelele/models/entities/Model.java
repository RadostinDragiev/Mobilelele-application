package com.example.mobilelele.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "models")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Model extends BaseEntity {
    private String name;
    private String imageUrl;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "end_year")
    private int endYear;
    private LocalDateTime created;
    private LocalDateTime modified;
    @ManyToOne(targetEntity = Brand.class)
    private Brand brand;
}
