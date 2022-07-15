package com.ddd.project1.service;

import com.ddd.project1.dto.AccountTypeDto;
import com.ddd.project1.mapper.AccountTypeMapper;
import com.ddd.project1.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountTypeService {

    @Autowired
    AccountTypeRepository repository;

    public Flux<AccountTypeDto> getAll(){
        return repository.findAll().map(AccountTypeMapper::entityToDto);
    }

    public Mono<AccountTypeDto> getAccountType(String id){
        return repository.findById(id).map(AccountTypeMapper::entityToDto);
    }

    public Mono<AccountTypeDto> saveAccountType(Mono<AccountTypeDto> accountTypeDtoMono){
        return accountTypeDtoMono.map(AccountTypeMapper::dtoToEntity)
                .flatMap(repository::insert)
                .map(AccountTypeMapper::entityToDto);
    }

    public Mono<AccountTypeDto> updateAccountType(Mono<AccountTypeDto> accountTypeDtoMono, String id){
        return repository.findById(id)
                .flatMap(p-> accountTypeDtoMono.map(AccountTypeMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(repository::save)
                        .map(AccountTypeMapper::entityToDto));
    }

    public Mono<Void> deleteAccountType(String id){
        return repository.deleteById(id);
    }

}
