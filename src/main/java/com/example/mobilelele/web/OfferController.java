package com.example.mobilelele.web;

import com.example.mobilelele.models.entities.Engine;
import com.example.mobilelele.models.entities.Transmission;
import com.example.mobilelele.services.BrandService;
import com.example.mobilelele.services.OfferService;
import com.example.mobilelele.services.UserService;
import com.example.mobilelele.web.dtos.OfferAddDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
@Slf4j
public class OfferController {
    private final OfferService offerService;
    private final UserService userService;
    private final BrandService brandService;

    @Autowired
    public OfferController(OfferService offerService, UserService userService, BrandService brandService) {
        this.offerService = offerService;
        this.userService = userService;
        this.brandService = brandService;
    }

    @GetMapping("/add")
    public String addOffer(HttpSession httpSession, Model offer) {
        offer.addAttribute("transmissions", Transmission.values());
        offer.addAttribute("engines", Engine.values());
        offer.addAttribute("brands", this.brandService.getAllBrandsAndModels());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(HttpSession httpSession, @Valid @ModelAttribute("offerAddDto")  OfferAddDto offerAddDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/offers/add";
        }
        String userId = httpSession.getAttribute("userId").toString();
        if (userId.isEmpty()) {
            log.error("Missing user ID");
            return "redirect:/offers/add";
        }
        offerAddDto.setSeller(this.userService.getUserId(userId));
        if (this.offerService.addOffer(offerAddDto)) {
            return "redirect:/";
        } else {
            return "redirect:/offers/add";
        }
    }
}
