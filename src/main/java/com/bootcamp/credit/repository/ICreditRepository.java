package com.bootcamp.credit.repository;

import com.bootcamp.credit.model.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICreditRepository extends ReactiveMongoRepository<Credit, String> {
}
