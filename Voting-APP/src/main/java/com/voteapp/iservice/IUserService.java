package com.voteapp.iservice;

import com.voteapp.entity.User;
import com.voteapp.entity.request.UserRequest;

public interface IUserService {
    User registerUser(UserRequest user);

    User login(String username, String password);

    User findByUserName(String username);
}
