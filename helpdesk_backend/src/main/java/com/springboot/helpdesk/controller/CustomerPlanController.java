package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.Request.CustomerPlanDto;
import com.springboot.helpdesk.service.CustomerPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerPlanController {
    private final CustomerPlanService customerPlanService;
    /*
    API to add customer buys plan record in customer_plan table with all relevant fields
    * */


    @PostMapping("/api/customerPlan/add/{customerId}/{planId}")
    public void addCustomerPlan(@PathVariable Long customerId,
                                @PathVariable Long planId,
                                @Valid @RequestBody CustomerPlanDto customerPlanDto){
        customerPlanService.addCustomerPlan(customerId,planId,customerPlanDto);
    }

    /*
     * GET API : to fetch all plans based on customer username.
     * */

}
