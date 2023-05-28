package com.example.mobilelele.web.dtos;

import com.example.mobilelele.models.entities.Engine;
import com.example.mobilelele.models.entities.Model;
import com.example.mobilelele.models.entities.Transmission;
import com.example.mobilelele.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfferAddDto {
    private String category;
    private Model model;
    private Engine engine;
    private Transmission transmission;
    private String imageUrl;
    private int year;
    private int mileage;
    private BigDecimal price;
    private String description;
    private User seller;
}
