package com.TaskManagement.Backend.service;

import com.TaskManagement.Backend.dto.Request.TaskDto;
import com.TaskManagement.Backend.dto.Request.TaskUpdateDto;
import com.TaskManagement.Backend.dto.Response.TaskRespDto;
import com.TaskManagement.Backend.exception.OwnerShipException;
import com.TaskManagement.Backend.exception.ResourceNotFoundException;
import com.TaskManagement.Backend.mapper.TaskMapper;
import com.TaskManagement.Backend.model.Customer;
import com.TaskManagement.Backend.model.Task;
import com.TaskManagement.Backend.repository.CustomerRepository;
import com.TaskManagement.Backend.repository.TaskRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final CustomerRepository customerRepository;
    private final TaskRepository taskRepository;

    public void addTask(String name, @Valid TaskDto taskDto) {
        //fetch customer
        Customer customer = customerRepository.getByUsername(name);

        Task task = TaskMapper.convertDtoToModel(taskDto);
        task.setCustomer(customer);

        taskRepository.save(task);
    }

    public TaskRespDto getTaskById(long taskId) {
       Task task = taskRepository.findById(taskId).orElseThrow(()->new ResourceNotFoundException("Task Id is invalid"));
       return TaskMapper.convertModelToDto(task);
    }

    public List<TaskRespDto> getAllTask(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        List<Task> list = taskRepository.findAll(pageable).getContent();
        return list.stream().map(TaskMapper::convertModelToDto).toList();
    }

    public void updateTask(String name, long taskId, TaskUpdateDto taskUpdateDto) {

        //Step 1: Fetch the task using taskId from the db
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task Id is invalid"));

        //Step 2: Check whether the user has access to update the task
        if (!(task.getCustomer().getUser().getUsername().equals(name))) {
            throw new OwnerShipException("Task not found for this user");
        }

        boolean flag = false;

        //update title
        if (taskUpdateDto.title() != null && !taskUpdateDto.title().trim().isEmpty()) {
            task.setTitle(taskUpdateDto.title());
            flag = true;
        }

        //update description
        if (taskUpdateDto.description() != null && !taskUpdateDto.description().trim().isEmpty()) {
            task.setDescription(taskUpdateDto.description());
            flag = true;
        }

        //update due date
        if (taskUpdateDto.dueDate() != null) {
            task.setDueDate(taskUpdateDto.dueDate());
            flag = true;
        }

        //update priority
        if (taskUpdateDto.priority() != null) {
            task.setPriority(taskUpdateDto.priority());
            flag = true;
        }

        //update status
        if (taskUpdateDto.status() != null) {
            task.setStatus(taskUpdateDto.status());
            flag = true;
        }

        if (!flag) {
            throw new RuntimeException("No valid fields provided for update");
        }

        //save the updates
        taskRepository.save(task);
    }

    public void deleteTask(String name, long id) {
        //Fetch the task using id from the db
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task Id is invalid"));

        //Check whether the user has access to delete the task
        if (!(task.getCustomer().getUser().getUsername().equals(name))) {
            throw new OwnerShipException("Task not found for this user");
        }

        //Delete the task
        taskRepository.delete(task);
    }

}
