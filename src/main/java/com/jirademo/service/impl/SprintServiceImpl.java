package com.jirademo.service.impl;

import com.jirademo.dto.AddingTaskToSprintDto;
import com.jirademo.dto.SprintDto;
import com.jirademo.dto.TaskDto;
import com.jirademo.entities.Sprint;
import com.jirademo.entities.Task;
import com.jirademo.repositories.SprintRepository;
import com.jirademo.repositories.TaskRepository;
import com.jirademo.service.SprintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SprintDto createSprint(SprintDto sprintDto){
        Sprint sprint = dtoToEntity(sprintDto);
        Sprint save = sprintRepository.save(sprint);
        return entityToDto(save);
    }

    @Override
    public SprintDto getSprintById(long id){
        Sprint sprint = sprintRepository.findById(id).get();
        return entityToDto(sprint);
    }

    @Override
    public List<SprintDto> getSprint(){
        List<Sprint> all = sprintRepository.findAll();
        List<SprintDto> collect = all.stream().map(s -> entityToDto(s)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public SprintDto addTaskToSprint(long sprintId, AddingTaskToSprintDto addingTaskToSprintDto){
//        Sprint sprint1 = getSprintById(sprintId);
//        long tasks = addingTaskToSprintDto.getTasks();
//        Task taskById = taskService.getTaskById(tasks);
//        if(sprint1.getTasks()==null){
//            sprint1.setTasks(List.of(taskById));
//        }else {
//            sprint1.getTasks().add(taskById);
//        }
//        return sprintRepository.save(sprint1);

        Sprint sprint = sprintRepository.findById(sprintId).get();
        long tasks = addingTaskToSprintDto.getTasks();
        Task task = taskRepository.findById(tasks).get();
        if(sprint.getTasks()==null){
            sprint.setTasks(List.of(task));
        }else {
            sprint.getTasks().add(task);
        }
        sprintRepository.save(sprint);
        return entityToDto(sprint);
    }

    @Override
    public SprintDto removeTaskFromSprint(long sprintId, AddingTaskToSprintDto addingTaskToSprintDto){
//        Sprint sprint = getSprintById(sprintId);
//        long tasks = addingTaskToSprintDto.getTasks();
//        Task task = taskService.getTaskById(tasks);
//        sprint.getTasks().remove(task);
//        return sprint;

        Sprint sprint = sprintRepository.findById(sprintId).get();
        long tasks = addingTaskToSprintDto.getTasks();
        Task task = taskRepository.findById(tasks).get();
        sprint.getTasks().remove(task);

        return entityToDto(sprint);
    }

    public Sprint dtoToEntity(SprintDto sprintDto){
        return modelMapper.map(sprintDto, Sprint.class);
    }

    public SprintDto entityToDto(Sprint sprint) {
        return modelMapper.map(sprint, SprintDto.class);
    }

}
