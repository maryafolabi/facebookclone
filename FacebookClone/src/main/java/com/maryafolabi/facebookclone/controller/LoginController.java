package com.maryafolabi.facebookclone.controller;


import com.maryafolabi.facebookclone.dto.ResponseDTO;
import com.maryafolabi.facebookclone.model.User;
import com.maryafolabi.facebookclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/login")
    public String loginUser(Model model, @ModelAttribute("user") User user, HttpServletRequest request) {

        //Validation

        ResponseDTO responseDTO = userService.login(user.getEmail(), user.getPassword());
        User loggedInUser = responseDTO.getUser();

        if (loggedInUser == null) {
            model.addAttribute("error", responseDTO.getMessage());
            return "index";
        } else {
            request.getSession().invalidate();
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(1000);
            session.setAttribute("userSession", loggedInUser);

            return "redirect:/";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
