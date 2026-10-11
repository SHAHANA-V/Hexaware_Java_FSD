package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.dto.Response.ExecutiveRespDto;
import com.springboot.helpdesk.model.Executive;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExecutiveRepository extends JpaRepository<Executive,Long> {

    @Query("""
            select new com.springboot.helpdesk.dto.Response.ExecutiveRespDto(t.id,e.id,e.name,t.subject,
            t.priority,t.status,t.createdAt,c.id,c.name)
            from Ticket t
            join t.executive e
            join t.customer c
            join e.user u
            where u.username = ?1
            """)
    List<ExecutiveRespDto> getTicketsByExecutiveName(String executiveName, Pageable pageable);
}
