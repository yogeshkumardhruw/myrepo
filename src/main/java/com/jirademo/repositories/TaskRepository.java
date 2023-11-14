package com.jirademo.repositories;

import com.jirademo.entities.Task;
import com.jirademo.enums.TaskStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, Long> {
    List<Task> findByTaskStatus(TaskStatus taskStatus);
}
