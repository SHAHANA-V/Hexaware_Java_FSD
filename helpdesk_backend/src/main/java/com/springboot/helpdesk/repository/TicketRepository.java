package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.dto.Request.TicketStatusCustomerCountDto;
import com.springboot.helpdesk.dto.Response.TicketInfoDto;
import com.springboot.helpdesk.dto.Response.TicketRespDto;
import com.springboot.helpdesk.enums.Priority;
import com.springboot.helpdesk.enums.Status;
import com.springboot.helpdesk.model.Ticket;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("""
            select new com.springboot.helpdesk.dto.Response.TicketInfoDto(t.id,t.subject,
            t.createdAt,t.priority,t.status,c.name,e.name,e.email)
            from Ticket t
            JOIN t.customer c
            JOIN t.executive e
            where c.id = ?1
            """)
    List<TicketInfoDto> getTicketsByCustomerId(Long customerId, Pageable pageable);

    @Query(""" 
            select new com.springboot.helpdesk.dto.Response.TicketInfoDto(t.id,t.subject,
            t.createdAt,t.priority,t.status,c.name,e.name,e.email)
            from Ticket t
            JOIN t.customer c
            join t.executive e
            join c.user u
            where u.username = ?1
            """)
    List<TicketInfoDto> getTicketsByCustomerUsername(String customerUsername, Pageable pageable);

    @Query("""

            select t.status as ticketStatus,count(c.id) as numberOfCustomer
            from Ticket t
            join t.customer c
            where t.status is not null
            group by t.status
""")
    List<TicketStatusCustomerCountDto> getTicketStatusCustomerCount();

    List<Ticket> findByPriority(Priority priority);// select t from Ticket t where t.priority=?1

    List<Ticket> findByStatus(Status status); // select t from Ticket t where t.status=?1

    List<Ticket> findByPriorityAndStatus(Priority priority, Status status);// select t from Ticket t where t.priority=?1 and t.status=?2


    @Query("""
            select t.id as ticketId, t.subject as subject, t.createdAt as createdAt, t.priority as priority, t.status as status
            from Ticket t
            where (?1 IS NULL OR t.priority = ?1)
            AND  (?2 IS NULL OR t.status = ?2)
            AND (?3 IS NULL OR t.createdAt >= ?3)
            AND (?4 IS NULL OR t.createdAt <= ?4)
            """)
    List<TicketRespDto> dynamicFilterTicket(Priority priority, Status status, Instant instant, Instant instant1);
}
