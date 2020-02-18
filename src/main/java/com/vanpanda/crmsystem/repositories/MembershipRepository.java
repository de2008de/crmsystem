package com.vanpanda.crmsystem.repositories;

import com.vanpanda.crmsystem.entities.Membership;

import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository {
    public void addMembership(Membership membership);
    public Membership getMembershipById(Long id);
}
