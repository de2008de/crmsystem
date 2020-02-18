package com.vanpanda.crmsystem.services;

import com.vanpanda.crmsystem.entities.Membership;
import com.vanpanda.crmsystem.repositories.MembershipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("MembershipServiceImpl")
public class MembershipServiceImpl implements MembershipService{

    @Autowired
    @Qualifier("MembershipRepositoryImpl")
    private MembershipRepository membershipRepository;

    public void addMembership(Membership membership) {
        membershipRepository.addMembership(membership);
    }

    public Membership getMembershipById(Long id) {
        return membershipRepository.getMembershipById(id);
    }
}
