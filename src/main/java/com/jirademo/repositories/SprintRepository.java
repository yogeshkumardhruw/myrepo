package com.jirademo.repositories;

import com.jirademo.entities.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintRepository extends MongoRepository<Sprint, Long> {
}
