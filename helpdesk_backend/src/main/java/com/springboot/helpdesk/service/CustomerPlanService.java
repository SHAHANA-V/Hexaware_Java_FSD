package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.Request.CustomerPlanDto;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.CustomerPlanMapper;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.CustomerPlan;
import com.springboot.helpdesk.model.Plan;
import com.springboot.helpdesk.repository.CustomerPlanRepository;
import com.springboot.helpdesk.repository.CustomerRepository;
import com.springboot.helpdesk.repository.PlanRepository;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerPlanService {
    private final CustomerPlanRepository customerPlanRepository;
    private final CustomerRepository customerRepository;
    private final PlanRepository planRepository;

    public void addCustomerPlan(Long customerId, Long planId, @Valid CustomerPlanDto customerPlanDto) {
        //fetch the customer object from db
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer Id Invalid"));

        //fetch the plan object from db
        Plan plan = planRepository.findById(planId)
                .orElseThrow(()->new ResourceNotFoundException("Plan Id is Invalid"));

        //attach mapper to customerplan
        CustomerPlan customerPlan = CustomerPlanMapper.convertDtoToEntity(customerPlanDto);

        //attach the customer and plan to the customerplan
        customerPlan.setCustomer(customer);
        customerPlan.setPlan(plan);

        //save in the db
        customerPlanRepository.save(customerPlan);
    }
}
