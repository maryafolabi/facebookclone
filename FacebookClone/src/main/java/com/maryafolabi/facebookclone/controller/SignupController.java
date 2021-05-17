package com.maryafolabi.facebookclone.controller;

import com.maryafolabi.facebookclone.model.User;
import com.maryafolabi.facebookclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SignupController {

    @Autowired
    UserService userService;

    @GetMapping ("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/saveUser")
    public String saveUser(Model model, @ModelAttribute("user") User user) {
       String message = userService.saveUser(user);
        if (message == null) {
            return "redirect:/index";
        }
        model.addAttribute("error", message);
        return "signup";
    }
}
