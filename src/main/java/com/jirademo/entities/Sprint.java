package com.jirademo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Sprint {

    @Id
    private long sprintId;
    private String sprintName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Task> tasks;
}
