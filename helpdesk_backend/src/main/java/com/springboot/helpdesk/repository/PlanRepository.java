package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Long> {
}
