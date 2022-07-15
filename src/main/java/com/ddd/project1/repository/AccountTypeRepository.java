package com.ddd.project1.repository;

import com.ddd.project1.entity.AccountType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends ReactiveMongoRepository<AccountType, String>{
}
