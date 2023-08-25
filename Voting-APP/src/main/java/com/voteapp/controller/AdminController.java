package com.voteapp.controller;

import com.voteapp.entity.Admin;
import com.voteapp.entity.User;
import com.voteapp.entity.request.AdminRequest;
import com.voteapp.entity.request.VotePartyRequest;
import com.voteapp.iservice.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/admin/")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    @PostMapping("/saveAdmin")
    public Object saveAmin(@RequestBody AdminRequest request){
        return iAdminService.saveAdmin(request);
    }

    @GetMapping("/adminLogin")
    public String adminLogin() {
        return "adminlogin";
    }

   @PostMapping("/adminLogin")
    public String adminLogin(@RequestParam String username, @RequestParam String password, Model model) {
        System.out.println("Username : "+username+ "  pass : "+password);
        Admin admin = iAdminService.adminLogin(username, password);
        if (admin != null && admin.getPassword().equals(password)) {
            System.out.println("hjbdh");
            return "redirect:/api/v1/voteParty/vote";
        } else {
            System.out.println("hb");
            model.addAttribute("error", "Invalid username or password");
            return "adminlogin";
        }
    }



}

