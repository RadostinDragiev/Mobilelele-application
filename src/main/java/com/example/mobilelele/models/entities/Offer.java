package com.example.mobilelele.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Offer extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String description;
    @NotNull
    private Engine engine;
    private String imageUrl;
    @NotNull
    private int mileage;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Transmission transmission;
    @NotNull
    private int year;
    private LocalDateTime created;
    private LocalDateTime modified;
    @ManyToOne
    @NotNull
    private Model model;
    @ManyToOne
    @NotNull
    private User seller;
}
