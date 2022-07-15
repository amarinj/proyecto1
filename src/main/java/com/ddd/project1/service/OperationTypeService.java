package com.ddd.project1.service;

import com.ddd.project1.dto.OperationTypeDto;
import com.ddd.project1.entity.OperationType;
import com.ddd.project1.mapper.OperationTypeMapper;
import com.ddd.project1.repository.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OperationTypeService {

    @Autowired
    private OperationTypeRepository repository;

    public Flux<OperationTypeDto> getAll(){
        return repository.findAll().map(OperationTypeMapper::entityToDto);
    }

    public Mono<OperationTypeDto> getOperationType(String id){
        return repository.findById(id).map(OperationTypeMapper::entityToDto);
    }

    public Mono<OperationTypeDto> saveOperationType(Mono<OperationTypeDto> operationTypeDtoMono){
        return operationTypeDtoMono.map(OperationTypeMapper::dtoToEntity)
                .flatMap(repository::insert)
                .map(OperationTypeMapper::entityToDto);
    }

    public Mono<OperationTypeDto> updateOperationType(Mono<OperationTypeDto> operationTypeDtoMono, String id){
        return repository.findById(id)
                .flatMap(p-> operationTypeDtoMono.map(OperationTypeMapper::dtoToEntity)
                .doOnNext(e->e.setId(id))
                .flatMap(repository::save)
                .map(OperationTypeMapper::entityToDto));
    }

    public Mono<Void> deleteOperationType(String id){
        return repository.deleteById(id);
    }

}
