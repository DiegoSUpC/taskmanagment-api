package com.org.mapper;

import com.org.dto.Request.TaskRequest;
import com.org.dto.Response.TaskResponse;
import com.org.model.Task;
import com.org.model.Developer;
import com.org.model.enums.TaskStatus;
import com.org.repository.TaskRepository;
import org.springframework.stereotype.Component;

@Component

public class TaskMapper {
    public Task Toentity(TaskRequest taskRequest, Developer developer) {
        return Task.builder().title(taskRequest.title()).
                description(taskRequest.Description()).
                developer(developer).
                status(TaskStatus.PENDING).
                StartDate(taskRequest.StartDate()).
                EndDate((taskRequest.endDate())).build();
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name(),
                task.getDeveloper().getName(),
                task.getStartDate(),
                task.getEndDate()
        );
    }


}
