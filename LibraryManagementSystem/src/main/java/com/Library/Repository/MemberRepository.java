package com.Library.Repository;

import com.Library.model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager entityManager;


    public Optional<Member> getMemberById(long borrowedBy) {
        return Optional.ofNullable(entityManager.find(Member.class,borrowedBy));
    }
}
