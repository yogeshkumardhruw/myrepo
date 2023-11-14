package com.jirademo.controller;

import com.jirademo.dto.AddingTaskToSprintDto;
import com.jirademo.dto.SprintDto;
import com.jirademo.entities.Sprint;
import com.jirademo.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @PostMapping("/")
    public SprintDto createSprint(@RequestBody SprintDto sprintDto){
        return sprintService.createSprint(sprintDto);
    }

    @GetMapping("/{id}")
    public SprintDto getSprintById(@PathVariable long id){
        return sprintService.getSprintById(id);
    }

    @GetMapping("/")
    public List<SprintDto> getSprint(){
        return sprintService.getSprint();
    }

    @PutMapping("/add/{sprintId}")
    public SprintDto addTaskToSprint(@PathVariable long sprintId, @RequestBody AddingTaskToSprintDto addingTaskToSprintDto){
        return sprintService.addTaskToSprint(sprintId, addingTaskToSprintDto);
    }

    @PutMapping("/remove/{sprintId}")
    public SprintDto removeTaskFromSprint(@PathVariable long sprintId, @RequestBody AddingTaskToSprintDto addingTaskToSprintDto){
        return sprintService.removeTaskFromSprint(sprintId,addingTaskToSprintDto);
    }

}
