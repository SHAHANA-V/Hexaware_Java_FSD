package com.TaskManagement.Backend.controller;

import com.TaskManagement.Backend.dto.Request.TaskDto;
import com.TaskManagement.Backend.dto.Request.TaskUpdateDto;
import com.TaskManagement.Backend.dto.Response.TaskRespDto;
import com.TaskManagement.Backend.model.Task;
import com.TaskManagement.Backend.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/api/add/task")
    public void addTask(Principal principal, @Valid @RequestBody TaskDto taskDto){
        taskService.addTask(principal.getName(),taskDto);
    }

    @GetMapping("/api/get/task/id/{taskId}")
    public TaskRespDto getTaskById(@PathVariable long taskId){
        return taskService.getTaskById(taskId);
    }

    @GetMapping("api/get/all/task")
    public List<TaskRespDto> taskRespDtoList(@RequestParam(name = "page",required = false,defaultValue = "0")int page,
                                             @RequestParam(name = "size",required = false,defaultValue = "10")int size){
        return taskService.getAllTask(page,size);
    }

    @PutMapping("/api/update/task/{taskId}")
    public void updateTask(Principal principal, @PathVariable long taskId, @RequestBody TaskUpdateDto taskUpdateDto){
        taskService.updateTask(principal.getName(),taskId,taskUpdateDto);
    }

    @DeleteMapping("/api/task/delete/{id}")
    public void delete(Principal principal,@PathVariable long id){
        taskService.deleteTask(principal.getName(),id);
    }
}
