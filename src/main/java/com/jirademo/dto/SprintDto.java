package com.jirademo.dto;

import com.jirademo.entities.Task;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SprintDto {

    private long sprintId;
    private String sprintName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Task> tasks;
}
