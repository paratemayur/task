package com.voteapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vote_party")
@Getter
@Setter
public class VoteParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_party_id")
    private Long votePartyId;

    @Column(name = "partyName")
    private String partyName;


}
