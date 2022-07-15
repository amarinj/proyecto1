package com.ddd.project1.repository;

import com.ddd.project1.entity.DocumentType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository  extends ReactiveMongoRepository<DocumentType,String> {
}
