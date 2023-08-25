package com.voteapp.iservice.service;

import com.voteapp.entity.User;
import com.voteapp.entity.request.UserRequest;
import com.voteapp.iservice.IUserService;
import com.voteapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserRequest request){
        User user = new User();
        BeanUtils.copyProperties(request, user);
        System.out.println("Save");
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (userRepository.existsByUserName(username)){
            User user = userRepository.findByUserName(username);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User findByUserName(String username) {
        User user = userRepository.findByUserName(username);
        return user;
    }
}
