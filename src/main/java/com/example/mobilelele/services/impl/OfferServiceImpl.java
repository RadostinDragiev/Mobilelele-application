package com.example.mobilelele.services.impl;

import com.example.mobilelele.models.entities.Offer;
import com.example.mobilelele.repositories.OfferRepository;
import com.example.mobilelele.services.OfferService;
import com.example.mobilelele.util.ValidationUtil;
import com.example.mobilelele.web.dtos.OfferAddDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean addOffer(OfferAddDto offerAddDto) {
        Offer offer = this.modelMapper.map(offerAddDto, Offer.class);
        LocalDateTime now = LocalDateTime.now();
        offer.setCreated(now);
        offer.setModified(now);
        if (this.validationUtil.isValid(offer)) {
            this.offerRepository.saveAndFlush(offer);
            return true;
        } else {
            this.validationUtil.getViolations(offer).forEach(v -> log.error(v.getMessage()));
             return false;
        }
    }

    @Override
    public List<Offer> getAllAOffers() {
        return this.offerRepository.findAll();
    }
}
