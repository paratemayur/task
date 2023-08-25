package com.voteapp.entity.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class UserRequest {

    private Long userId;

    private String userName;

    private String password;

    private String emailId;

    private String phoneNo;

}
