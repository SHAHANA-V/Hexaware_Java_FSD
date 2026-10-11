package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.Request.PlanDto;
import com.springboot.helpdesk.model.Plan;
import org.springframework.stereotype.Component;

@Component
public class PlanMapper {
    public static Plan convertDtoToEntity(PlanDto planDto){
        Plan plan = new Plan();
        plan.setPlanType(planDto.planType());
        plan.setPrice(planDto.price());
        return plan;
    }
}
