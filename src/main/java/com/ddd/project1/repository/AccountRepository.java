package com.ddd.project1.repository;

//import com.ddd.project1.dto.AccountDto;
import com.ddd.project1.entity.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account,String> {

    Mono<Account> findByAccountNumber(String accountNumber);

    Mono<Account> findByCardNumber(String cardNumber);
}
