package com.ddd.project1.service;

import com.ddd.project1.dto.DocumentTypeDto;
import com.ddd.project1.mapper.DocumentTypeMapper;
import org.springframework.http.MediaType;
import com.ddd.project1.dto.MovementDto;
import com.ddd.project1.dto.OperationTypeDto;
import com.ddd.project1.entity.Movement;
import com.ddd.project1.entity.OperationType;
import com.ddd.project1.mapper.MovementMapper;
import com.ddd.project1.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.UserTransactionAdapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Service
public class MovementService {

    @Autowired
    private MovementRepository repository;

    public Flux<MovementDto> getAll(){
        return repository.findAll().map(MovementMapper::entityToDto);
    }



    public Mono<MovementDto> getMovement(String id){
        return repository.findById(id).map(MovementMapper::entityToDto);
    }

    public Mono<MovementDto> saveMovement(Mono<MovementDto> movementDtoMono){
        return movementDtoMono.map(MovementMapper::dtoToEntity)
                .flatMap(repository::insert)
                .map(MovementMapper::entityToDto);
    }

/*
    public Mono<ServerResponse> addMovement(String id, Integer amount, String description, String accountNumber, String documentNumber) {
        //Mono<MovementDto> movementDto = new Mono[MovementDto]; // = movementDtoMono.bodyToMono(MovementDto.class);
        ///Mono<MovementDto> movementDto = movementDtoMono.bodyToMono(MovementDto.class);
                //Mono<MovementDto> movementDto = new Movement(id, amount, new OperationType(null ,description), accountNumber, documentNumber, 1);


        Mono<Movement> movement = movementDto.map(f -> new Movement(id, amount, new OperationType(null ,description), accountNumber, documentNumber, 1))
                .flatMap(repository::save);

        movementDto = Mono.from(movement.map(f -> {
            return new MovementDto(f.getId(), f.getAmount(), f.getOperationType(), f.getAccountNumber(), f.getDocumentNumber(), f.getState());
        }));

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(movementDto, MovementDto.class);
    }
*/

    public Mono<MovementDto> updateMovement(Mono<MovementDto> movementDtoMono, String id){
        return repository.findById(id)
                .flatMap(p-> movementDtoMono.map(MovementMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(repository::save)
                        .map(MovementMapper::entityToDto));
    }

    public Mono<Void> deleteMovement(String id){
        return repository.deleteById(id);
    }

}
