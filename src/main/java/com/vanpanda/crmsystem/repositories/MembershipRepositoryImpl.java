package com.vanpanda.crmsystem.repositories;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.vanpanda.crmsystem.entities.Membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@Qualifier("MembershipRepositoryImpl")
public class MembershipRepositoryImpl implements MembershipRepository {

    @Autowired
    private EntityManager entityManager;

    public void addMembership(Membership membership) {
        entityManager.persist(membership);
        entityManager.flush();
    }

    public Membership getMembershipById(Long id) {
        return entityManager.find(Membership.class, id);
    }
}
