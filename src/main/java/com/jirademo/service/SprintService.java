package com.jirademo.service;

import com.jirademo.dto.AddingTaskToSprintDto;
import com.jirademo.dto.SprintDto;
import com.jirademo.entities.Sprint;

import java.util.List;

public interface SprintService {

    SprintDto createSprint(SprintDto sprintDto);

     SprintDto getSprintById(long id);

     List<SprintDto> getSprint();

     SprintDto addTaskToSprint(long sprintId, AddingTaskToSprintDto addingTaskToSprintDto);

     SprintDto removeTaskFromSprint(long sprintId, AddingTaskToSprintDto addingTaskToSprintDto);



}
