package com.jirademo.entities;

import com.jirademo.enums.TaskStatus;
import com.jirademo.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Task {

    @Id
    private long taskId;
    private String taskName;
    private TaskType taskType;
    private TaskStatus taskStatus;
    private User user;
}
