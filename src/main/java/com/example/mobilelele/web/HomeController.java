package com.example.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Controller
    public class Home {
        @GetMapping("")
        public String getIndex(HttpSession httpSession) {
            return "offers";
        }
    }
}
