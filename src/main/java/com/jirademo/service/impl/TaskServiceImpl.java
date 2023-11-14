package com.jirademo.service.impl;

import com.jirademo.dto.AddingUserToTaskDto;
import com.jirademo.dto.TaskDto;
import com.jirademo.dto.UpdateStatusDto;
import com.jirademo.dto.UserDto;
import com.jirademo.entities.Task;
import com.jirademo.entities.User;
import com.jirademo.enums.TaskStatus;
import com.jirademo.repositories.TaskRepository;
import com.jirademo.repositories.UserRepository;
import com.jirademo.service.TaskService;
import com.jirademo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskDto createTask(TaskDto task){
        Task task1 = dtoToEntity(task);
        Task save = taskRepository.save(task1);
        return entityToDto(save);
    }

    @Override
    public TaskDto updateStatus(long id, UpdateStatusDto updateStatusDto){
        Task task = taskRepository.findById(id).get();
        TaskStatus taskStatus = updateStatusDto.getTaskStatus();
        task.setTaskStatus(taskStatus);
        taskRepository.save(task);
        return entityToDto(task);
    }

    @Override
    public List<TaskDto> getTaskByStatus(TaskStatus taskStatus){
        List<Task> byTaskStatus = taskRepository.findByTaskStatus(taskStatus);
        List<TaskDto> collect = byTaskStatus.stream().map(t -> entityToDto(t)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<TaskDto> getDelayedTask(){
//        List<TaskDto> taskByStatus = getTaskByStatus(TaskStatus.TO_DO);
//        taskByStatus.addAll(getTaskByStatus(TaskStatus.DEV_IN_PROGRESS));

        List<Task> byTaskStatus1 = taskRepository.findByTaskStatus(TaskStatus.TO_DO);
        byTaskStatus1.addAll(taskRepository.findByTaskStatus(TaskStatus.DEV_IN_PROGRESS));
        List<TaskDto> collect = byTaskStatus1.stream().map(t -> entityToDto(t)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public TaskDto getTaskById(long id){
        Task task = taskRepository.findById(id).get();
        return entityToDto(task);
    }

    @Override
    public TaskDto addUserToTask(long taskId, AddingUserToTaskDto addingUserToTaskDto){
//        TaskDto taskDto = getTaskById(taskId);
////        User user = userService.getUserById(userId);
////        task.setUser(user);
//        Task task = dtoToEntity(taskDto);
//        long user = addingUserToTaskDto.getUser();
//        UserDto userById = userService.getUserById(user);
//        task.setUser(userById);
//        return taskRepository.save(task);
//        return null;

        Task task = taskRepository.findById(taskId).get();
        long user = addingUserToTaskDto.getUser();
        User user1 = userRepository.findById(user).get();
        task.setUser(user1);

        return entityToDto(task);

    }

    @Override
    public List<TaskDto> getTask(){
//        List<Task> all = taskRepository.findAll();
//        List<TaskDto> collect = all.stream().map(t -> entityToDto(t)).collect(Collectors.toList());
//        return collect;

        return taskRepository.findAll().stream().map(t->entityToDto(t)).collect(Collectors.toList());

    }

    public Task dtoToEntity(TaskDto taskDto){
        return modelMapper.map(taskDto, Task.class);
    }

    public TaskDto entityToDto(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }

}
