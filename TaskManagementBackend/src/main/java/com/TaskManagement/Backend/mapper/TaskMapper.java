package com.TaskManagement.Backend.mapper;

import com.TaskManagement.Backend.dto.Request.TaskDto;
import com.TaskManagement.Backend.dto.Response.TaskRespDto;
import com.TaskManagement.Backend.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public static Task convertDtoToModel(TaskDto taskDto){
        Task task = new Task();
        task.setTitle(taskDto.title());
        task.setDescription(taskDto.description());
        task.setDueDate(taskDto.dueDate());
        task.setPriority(taskDto.priority());
        task.setStatus(taskDto.status());
        return task;
    }
    public static TaskRespDto convertModelToDto(Task task){
        return new TaskRespDto(
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus(),
                task.getCustomer().getName()
        );
    }
}
