package com.org.mapper;

import com.org.dto.Request.DeveloperRequest;
import com.org.dto.Response.DeveloperResponse;
import com.org.model.Developer;
import org.springframework.stereotype.Component;

@Component
public class DeveloperMapper {

    public Developer toEntity(DeveloperRequest request) {
        Developer developer = new Developer();
        developer.setName(request.name());
        return developer;
    }

    public DeveloperResponse toResponse(Developer developer) {
        return new DeveloperResponse(developer.getId(), developer.getName());
    }
}
