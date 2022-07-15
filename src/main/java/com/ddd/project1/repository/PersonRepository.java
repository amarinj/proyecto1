package com.ddd.project1.repository;

import com.ddd.project1.dto.PersonDto;
import com.ddd.project1.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person,String> {

    Mono<Person> findByDocumentNumber(String documentNumber);
}
