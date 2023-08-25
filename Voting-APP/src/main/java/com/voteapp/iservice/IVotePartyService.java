package com.voteapp.iservice;

import com.voteapp.entity.VoteParty;
import com.voteapp.entity.request.VotePartyRequest;

import java.util.List;

public interface IVotePartyService {
    Object saveVote(VotePartyRequest request);

    List<VoteParty> getPartyList();
}
