package com.jirademo.repositories;

import com.jirademo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
