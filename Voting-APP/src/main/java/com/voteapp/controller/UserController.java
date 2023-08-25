package com.voteapp.controller;

import com.voteapp.entity.User;
import com.voteapp.entity.request.UserRequest;
import com.voteapp.entity.response.CustomResponseMessage;
import com.voteapp.entity.response.EntityResponse;
import com.voteapp.iservice.IAdminService;
import com.voteapp.iservice.IUserService;
import com.voteapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api/v1/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserRequest user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("error");
            return "register";
        }
        User user1 = iUserService.registerUser(user);
        System.out.println("save");
        return "redirect:/api/v1/user/login"; // Redirect to login page after successful registration
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        System.out.println("Username : "+username+ "  pass : "+password);
        User user = iUserService.login(username, password);
        if (user != null && user.getPassword().equals(password)) {
            redirectAttributes.addAttribute("username", username);
            redirectAttributes.addFlashAttribute("successMessage", "Login successful!");

            return "redirect:/api/v1/voteParty/vote";
        } else {
            return "login";
        }
    }



}
