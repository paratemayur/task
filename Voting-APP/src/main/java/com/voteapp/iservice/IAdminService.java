package com.voteapp.iservice;

import com.voteapp.entity.Admin;
import com.voteapp.entity.User;
import com.voteapp.entity.request.AdminRequest;

public interface IAdminService {

    Object saveAdmin(AdminRequest request);

    Admin adminLogin(String username, String password);
}
