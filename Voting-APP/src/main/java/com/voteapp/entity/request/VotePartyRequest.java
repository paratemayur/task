package com.voteapp.entity.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class VotePartyRequest {

    private Long votePartyId;
    private String partyName;
}
