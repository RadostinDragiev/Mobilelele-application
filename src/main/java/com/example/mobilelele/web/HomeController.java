package com.example.mobilelele.web;

import com.example.mobilelele.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final OfferService offerService;

    @Autowired
    public HomeController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("")
    public String getIndex(HttpSession httpSession, Model model) {
        model.addAttribute("models", this.offerService.getAllAOffers());
        return "offers";
    }
}

