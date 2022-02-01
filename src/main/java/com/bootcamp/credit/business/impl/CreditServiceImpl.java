package com.bootcamp.credit.business.impl;

import com.bootcamp.credit.business.ICreditService;
import com.bootcamp.credit.model.Credit;
import com.bootcamp.credit.repository.ICreditRepository;
import com.bootcamp.credit.utils.CreditStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements ICreditService {

    @Autowired
    private ICreditRepository creditRepository;

    @Override
    public Mono<Credit> create(Credit credit) {
        credit.setStatus(CreditStatus.ACTIVE.name());
        return creditRepository.save(credit);
    }

    @Override
    public Mono<Credit> findById(String id) {
        return creditRepository.findById(id);
    }

    @Override
    public Flux<Credit> findAll() {
        return creditRepository.findAll()
                .filter(p -> p.getStatus().equals(CreditStatus.ACTIVE.name()));
    }

    @Override
    public Mono<Credit> update(Credit credit) {
        return creditRepository.findById(credit.getId())
                .filter(p -> p.getStatus().equals(CreditStatus.ACTIVE.name()))
                .switchIfEmpty(Mono.empty())
                .flatMap(creditDB -> creditRepository.save(credit));
    }

    @Override
    public Mono<Credit> delete(String id) {
        return creditRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .doOnNext(p -> p.setStatus(CreditStatus.INACTIVE.name()))
                .flatMap(creditRepository::save);
    }
}
