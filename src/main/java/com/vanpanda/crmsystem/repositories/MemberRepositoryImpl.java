package com.vanpanda.crmsystem.repositories;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.vanpanda.crmsystem.entities.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@Qualifier(value = "MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository {
    
    @Autowired
    private EntityManager entityManager;

    public void addMember(Member member) {
        entityManager.persist(member);
        entityManager.flush();
    }

    public Member getMemberById(Long id) {
        return entityManager.find(Member.class, id);
    }
}
