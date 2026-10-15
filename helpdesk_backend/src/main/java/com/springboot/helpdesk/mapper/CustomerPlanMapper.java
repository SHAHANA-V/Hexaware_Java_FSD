package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.Request.CustomerPlanDto;
import com.springboot.helpdesk.model.CustomerPlan;
import org.springframework.stereotype.Component;

@Component
public class CustomerPlanMapper {
    public static CustomerPlan convertDtoToEntity(CustomerPlanDto customerPlanDto){
        CustomerPlan customerPlan = new CustomerPlan();
        customerPlan.setActivationDate(customerPlanDto.activationDate());
        customerPlan.setEndDate(customerPlanDto.endDate());
        customerPlan.setCoupon(customerPlanDto.coupon());
        customerPlan.setAmountPaid(customerPlanDto.amountPaid());
        return customerPlan;
    }
}
