package com.helpdesk.Repository;

import com.helpdesk.model.Executive;
import com.helpdesk.model.Manager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ExecutiveRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Manager> getManagerById(int managerId) {
        // if managerId is present, find gives you manager else gives you null
        // here, optional will either have the manager or will be empty if find method gives null

        return Optional.ofNullable(entityManager.find(Manager.class,managerId));
    }

    public void insert(Executive executive) {

        entityManager.persist(executive);
    }
}
