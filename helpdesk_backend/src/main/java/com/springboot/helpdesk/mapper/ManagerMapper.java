package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.Request.ManagerDto;
import com.springboot.helpdesk.model.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {
    public static Manager covertDtoToModel(ManagerDto managerDto){
        Manager manager = new Manager();
        manager.setName(managerDto.name());
        return manager;
    }
}
