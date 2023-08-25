package com.voteapp.iservice.service;

import com.voteapp.entity.Admin;
import com.voteapp.entity.User;
import com.voteapp.entity.VoteParty;
import com.voteapp.entity.request.AdminRequest;
import com.voteapp.iservice.IAdminService;
import com.voteapp.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Object saveAdmin(AdminRequest request) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(request, admin);
        adminRepository.save(admin);
        return "Save";
    }

    @Override
    public Admin adminLogin(String username, String password) {
        if (adminRepository.existsByAdminName(username)){
            Admin admin = adminRepository.findByAdminName(username);
            return admin;
        } else {
            return null;
        }
    }
}
