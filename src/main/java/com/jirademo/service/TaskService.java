package com.jirademo.service;

import com.jirademo.dto.AddingUserToTaskDto;
import com.jirademo.dto.TaskDto;
import com.jirademo.dto.UpdateStatusDto;
import com.jirademo.entities.Task;
import com.jirademo.enums.TaskStatus;

import java.util.List;

public interface TaskService {

     TaskDto createTask(TaskDto taskDto);

     TaskDto updateStatus(long id, UpdateStatusDto updateStatusDto);
     List<TaskDto> getTaskByStatus(TaskStatus taskStatus);

     List<TaskDto> getDelayedTask();

     TaskDto getTaskById(long id);

     TaskDto addUserToTask(long taskId, AddingUserToTaskDto addingUserToTaskDto);

     List<TaskDto> getTask();
}
