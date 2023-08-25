package com.voteapp.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequest {

    private Long adminId;

    private String adminName;

    private String password;

    private String emailId;

    private String phoneNo;
}
