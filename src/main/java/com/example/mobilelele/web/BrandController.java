package com.example.mobilelele.web;

import com.example.mobilelele.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String getAllBrands(Model model) {
        model.addAttribute("brands", this.brandService.getAllBrandsAndModels());
        return "brands";
    }
}
