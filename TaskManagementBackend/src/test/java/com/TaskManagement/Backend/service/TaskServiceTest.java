package com.TaskManagement.Backend.service;


import com.TaskManagement.Backend.dto.Request.TaskDto;
import com.TaskManagement.Backend.dto.Request.TaskUpdateDto;
import com.TaskManagement.Backend.dto.Response.TaskRespDto;
import com.TaskManagement.Backend.enums.Priority;
import com.TaskManagement.Backend.enums.Status;
import com.TaskManagement.Backend.exception.OwnerShipException;
import com.TaskManagement.Backend.exception.ResourceNotFoundException;
import com.TaskManagement.Backend.model.Customer;
import com.TaskManagement.Backend.model.Task;
import com.TaskManagement.Backend.model.User;
import com.TaskManagement.Backend.repository.CustomerRepository;
import com.TaskManagement.Backend.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private CustomerRepository customerRepository;
    @Test
    public void addTaskTest() {

        //input values
        String name = "john";
        TaskDto taskDto = new TaskDto(
                "test task",
                "test description",
                LocalDate.now(),
                Priority.HIGH,
                Status.PENDING
        );

        //mock the customer repository
        Customer customer = new Customer();
        when(customerRepository.getByUsername(name)).thenReturn(customer);

        //Actual call
        taskService.addTask(name, taskDto);

        //Verify repository calls
        verify(customerRepository, times(1)).getByUsername(name);
        verify(taskRepository, times(1)).save(any(Task.class));

        verifyNoMoreInteractions(customerRepository);
        verifyNoMoreInteractions(taskRepository);
    }
    @Test
    public void getTaskByIdTest() {

        User user = new User();
        user.setUsername("john");

        Customer customer = new Customer();
        customer.setName("John");
        customer.setUser(user);

        // Create a task
        Task task = new Task();
        task.setId(1L);
        task.setTitle("test task");
        task.setDescription("test description");
        task.setDueDate(LocalDate.now());
        task.setPriority(Priority.HIGH);
        task.setStatus(Status.PENDING);
        task.setCustomer(customer);

        //mock repository
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        //call
        TaskRespDto dto = taskService.getTaskById(1L);

        // verify result
        assertNotNull(dto);

        // Step 5: Verify repository calls
        verify(taskRepository, times(1)).findById(1L);
        verifyNoMoreInteractions(taskRepository);
    }
    @Test
    public void getTaskByIdTest_Invalid() {
        // Mock an invalid task ID
        when(taskRepository.findById(5L)).thenReturn(Optional.empty());

        //Check whether the exception is thrown
        assertThrows(
                ResourceNotFoundException.class,
                () -> taskService.getTaskById(5L)
        );
        //verify repository calls
        verify(taskRepository, times(1)).findById(5L);
        verifyNoMoreInteractions(taskRepository);
    }
    @Test
    public void getAllTaskTest() {

        User user = new User();
        user.setUsername("john");

        Customer customer = new Customer();
        customer.setName("John");
        customer.setUser(user);
        // Step 1: Create tasks
        Task task1 = new Task();
        task1.setId(1L);
        task1.setTitle("test1");
        task1.setCustomer(customer);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setTitle("test2");
        task2.setCustomer(customer);

        Task task3 = new Task();
        task3.setId(3L);
        task3.setTitle("test3");
        task3.setCustomer(customer);

        //mock
        when(taskRepository.findAll(PageRequest.of(0, 5)))
                .thenReturn(new PageImpl<>(List.of(task1, task2)));

        when(taskRepository.findAll(PageRequest.of(1, 5)))
                .thenReturn(new PageImpl<>(List.of(task3)));

        //call
        assertEquals(2, taskService.getAllTask(0, 5).size());
        assertEquals(1, taskService.getAllTask(1, 5).size());

        // verify repository calls
        verify(taskRepository, times(1)).findAll(PageRequest.of(0, 5));
        verify(taskRepository, times(1)).findAll(PageRequest.of(1, 5));

        verifyNoMoreInteractions(taskRepository);
    }

    @Test
    public void updateTaskTest_InvalidId() {

        //mock an invalid task ID
        when(taskRepository.findById(5L)).thenReturn(Optional.empty());

        TaskUpdateDto taskUpdateDto = new TaskUpdateDto(
                "new title", null, null, null, null
        );

        //check whether the exception is thrown
        assertThrows(ResourceNotFoundException.class,
                () -> taskService.updateTask("john", 5L, taskUpdateDto));

        //verify repository calls
        verify(taskRepository, times(1)).findById(5L);
        verifyNoMoreInteractions(taskRepository);
    }

    @Test
    public void updateTaskTest_InvalidOwner() {

        User user = new User();
        user.setUsername("alex");

        Customer customer = new Customer();
        customer.setName("Alex");
        customer.setUser(user);

        Task task = new Task();
        task.setId(1L);
        task.setCustomer(customer);

        //mock the repo
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        TaskUpdateDto taskUpdateDto = new TaskUpdateDto(
                "new title", null, null, null, null
        );

        //check whether the exception is thrown
        assertThrows(OwnerShipException.class,
                () -> taskService.updateTask("john", 1L, taskUpdateDto));

        //verify repository calls
        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(0)).save(any(Task.class));

        verifyNoMoreInteractions(taskRepository);
    }
    @Test
    public void deleteTaskTest() {

        User user = new User();
        user.setUsername("john");

        Customer customer = new Customer();
        customer.setName("John");
        customer.setUser(user);

        Task task = new Task();
        task.setId(1L);
        task.setCustomer(customer);

        //mock
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        //call
        taskService.deleteTask("john", 1L);

        //verify
        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).delete(task);

        verifyNoMoreInteractions(taskRepository);
    }
}

