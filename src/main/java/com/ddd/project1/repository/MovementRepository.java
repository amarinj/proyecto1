package com.ddd.project1.repository;

//import com.ddd.project1.dto.MovementDto;
import com.ddd.project1.entity.Movement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
//import reactor.core.publisher.Mono;

@Repository
public interface MovementRepository extends ReactiveMongoRepository<Movement,String> {

    //Mono<MovementDto> findByDocumentNumber(String documentNumber);
}
