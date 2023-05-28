package com.example.mobilelele.services;

import com.example.mobilelele.models.entities.Offer;
import com.example.mobilelele.web.dtos.OfferAddDto;

import java.util.List;

public interface OfferService {
    boolean addOffer(OfferAddDto offerAddDto);

    List<Offer> getAllAOffers();
}
