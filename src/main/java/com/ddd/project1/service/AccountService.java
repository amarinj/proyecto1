package com.ddd.project1.service;

import com.ddd.project1.dto.AccountDto;
//import com.ddd.project1.entity.Account;
import com.ddd.project1.dto.DocumentTypeDto;
import com.ddd.project1.entity.Account;
import com.ddd.project1.mapper.AccountMapper;
import com.ddd.project1.mapper.DocumentTypeMapper;
import com.ddd.project1.repository.AccountRepository;
//import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Flux<AccountDto> getAll(){
        return repository.findAll().map(AccountMapper::entityToDto);
    }

    public Mono<AccountDto> getAccount(String id){
        return repository.findById(id).map(AccountMapper::entityToDto);
    }

     public Mono<AccountDto> getAccountNumber(String accountNumber){
        return  repository.findByAccountNumber(accountNumber).map(AccountMapper::entityToDto);
    }

    //public Mono<Integer> getAccountBalance(String cardNumber){

       // Mono<AccountDto> accountDtoMono =repository.findByCardNumber(cardNumber).map(AccountMapper::entityToDto);

       // Mono<Integer> valorRetorno= accountDtoMono.map(p->p.getBalanceAvailable()) ;

        //Mono<Integer>valorComparar = Mono.just(10001);

        //Mono<Integer> var1 = valorRetorno.zipWith(valorComparar).map(p-> {
            //if(p.getT1()< p.getT2()){
                //return Mono.just(p);
            //}
        //}).subscribe();



     //   return  valorRetorno;
    //}

    public Mono<AccountDto> saveAccount(Mono<AccountDto> accountDtoMono){
        return accountDtoMono.map(AccountMapper::dtoToEntity)
                .flatMap(repository::insert)
                .map(AccountMapper::entityToDto);
    }

/*
    public Mono<AccountDto> updateAccount(Mono<AccountDto> accountDtoMono, String id){
        return repository.findById(id)
                .flatMap(p-> accountDtoMono
                        .map(AccountMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(repository::save)
                        .map(AccountMapper::entityToDto));
    }
*/
    public Mono<AccountDto> updateAccount(Mono<AccountDto> accountDtoMono, String id){
        return repository.findById(id)
                .flatMap(p-> accountDtoMono.map(AccountMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(repository::save)
                        .map(AccountMapper::entityToDto));
    }
    public Mono<Void> deleteAccount(String id){
        return repository.deleteById(id);
    }

}
