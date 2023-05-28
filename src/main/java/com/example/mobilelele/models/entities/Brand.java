package com.example.mobilelele.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "brands")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Brand extends BaseEntity {
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;
    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private List<Model> models;
}
