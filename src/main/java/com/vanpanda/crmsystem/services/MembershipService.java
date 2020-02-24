package com.vanpanda.crmsystem.services;

import com.vanpanda.crmsystem.entities.Membership;

import org.springframework.stereotype.Service;

@Service
public interface MembershipService {
    public void addMembership(Membership membership);
    public Membership getMembershipById(Long id);
}
