package com.helpdesk.Repository;

import com.helpdesk.model.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Ticket ticket) {
        entityManager.persist(ticket);
    }

    public List<Ticket> fetchAllTickets() {
        String jpql="select t from Ticket t";
        return entityManager.createQuery(jpql, Ticket.class).getResultList();
    }
}
