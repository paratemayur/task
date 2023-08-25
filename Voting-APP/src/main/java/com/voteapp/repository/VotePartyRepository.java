package com.voteapp.repository;

import com.voteapp.entity.VoteParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotePartyRepository extends JpaRepository<VoteParty, Long> {

}
