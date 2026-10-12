package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.Request.ExecutiveDto;
import com.springboot.helpdesk.model.Executive;
import org.springframework.stereotype.Component;

@Component
public class ExecutiveMapper {

    public static Executive mapDtoToModel(ExecutiveDto executiveDto){
        Executive executive = new Executive();
        executive.setName(executiveDto.name());
        executive.setEmail(executiveDto.email());
        executive.setContact(executiveDto.contact());
        executive.setJobTitle(executiveDto.jobTitle());
        return executive;
    }
}
