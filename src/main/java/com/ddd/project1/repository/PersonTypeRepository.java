package com.ddd.project1.repository;

import com.ddd.project1.entity.PersonType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonTypeRepository extends ReactiveMongoRepository<PersonType,String> {
}
