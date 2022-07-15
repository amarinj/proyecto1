package com.ddd.project1.repository;

import com.ddd.project1.entity.OperationType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTypeRepository extends ReactiveMongoRepository<OperationType, String> {
}
