package com.voteapp.iservice.service;

import com.voteapp.entity.User;
import com.voteapp.entity.VoteParty;
import com.voteapp.entity.request.VotePartyRequest;
import com.voteapp.iservice.IVotePartyService;
import com.voteapp.repository.VotePartyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotePartyService implements IVotePartyService {


    @Autowired
    private VotePartyRepository votePartyRepository;
    @Override
    public Object saveVote(VotePartyRequest request) {
        VoteParty vote = new VoteParty();
        BeanUtils.copyProperties(request, vote);
        votePartyRepository.save(vote);
        return "Save";
    }

    @Override
    public List<VoteParty> getPartyList() {
        List<VoteParty> votePartyList = votePartyRepository.findAll();
        return votePartyList;
    }
}
