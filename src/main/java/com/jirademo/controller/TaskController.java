package com.jirademo.controller;

import com.jirademo.dto.AddingUserToTaskDto;
import com.jirademo.dto.TaskDto;
import com.jirademo.dto.UpdateStatusDto;
import com.jirademo.entities.Task;
import com.jirademo.enums.TaskStatus;
import com.jirademo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/")
    public TaskDto createTask(@RequestBody TaskDto taskDto){
        return taskService.createTask(taskDto);
    }

    @PutMapping("/{id}")
    public TaskDto updateStatus(@PathVariable long id, @RequestBody UpdateStatusDto updateStatusDto){
        return taskService.updateStatus(id,updateStatusDto);
    }

    @GetMapping("/taskStatus/{taskStatus}")
    public List<TaskDto> getTaskByStatus(@PathVariable TaskStatus taskStatus){
        return taskService.getTaskByStatus(taskStatus);
    }

    @GetMapping("/delayed")
    public List<TaskDto> getDelayedTask(){
        return taskService.getDelayedTask();
    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable long id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/add/{taskId}")
    public TaskDto addUserToTask(@PathVariable long taskId, @RequestBody AddingUserToTaskDto addingUserToTaskDto){
        return taskService.addUserToTask(taskId,addingUserToTaskDto);
    }

    @GetMapping("/")
    public List<TaskDto> getTask(){
        return taskService.getTask();
    }

}
