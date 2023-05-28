package com.example.mobilelele.web;

import com.example.mobilelele.models.entities.User;
import com.example.mobilelele.services.UserService;
import com.example.mobilelele.web.dtos.AuthUserDto;
import com.example.mobilelele.web.dtos.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin(HttpSession httpSession) {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(AuthUserDto authUserDto, HttpSession httpSession) {
        User user = this.userService.login(authUserDto);
        if (user != null) {
            httpSession.setAttribute("userId", user.getUuid());
            httpSession.setAttribute("username", user.getFirstName());
            return "redirect:/";
        } else {
            httpSession.setAttribute("errMsg", "Invalid username or password.");
            return "redirect:/users/login";
        }
    }

    @GetMapping("/register")
    public String getRegister(HttpSession httpSession, @ModelAttribute("userDto") RegisterUserDto registerUserDto) {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDto") RegisterUserDto registerUserDto, RedirectAttributes redirectAttributes) {
        boolean isRegisteredSuccessfully = this.userService.register(registerUserDto);
        if (isRegisteredSuccessfully) {
            return "redirect:/users/login";
        }
        redirectAttributes.addFlashAttribute("firstName", registerUserDto.getFirstName());
        return "redirect:/users/register";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
