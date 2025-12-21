package com.canaristar.backend.repository;

import com.canaristar.backend.entity.LogDay;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<LogDay, String> {
}
