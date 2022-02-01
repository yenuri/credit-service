package com.bootcamp.credit.business;

import com.bootcamp.credit.model.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditService {
    Mono<Credit> create(Credit credit);

    Mono<Credit> findById(String id);

    Flux<Credit> findAll();

    Mono<Credit> update(Credit credit);

    Mono<Credit> delete(String id);
}
