package com.bootcamp.credit.expose;

import com.bootcamp.credit.business.ICreditService;
import com.bootcamp.credit.model.Credit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping(value = "/api/credits")
@RestController
public class CreditController {

    @Autowired
    private ICreditService creditService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Credit> create (@RequestBody Credit credit){
        log.info("<<<<< Create Credit >>>>>");
        return creditService.create(credit);
    }

    @GetMapping("/{id}")
    public Mono<Credit> findById(@PathVariable String id){
        log.info("<<<<< Find One Credit >>>>>");
        return creditService.findById(id);
    }

    @GetMapping("")
    public Flux<Credit> findAll(){
        log.info("<<<<< Find All Credits >>>>>");
        return creditService.findAll();
    }

    @PutMapping("")
    public Mono<ResponseEntity<Credit>> update(@RequestBody Credit credit){
            log.info("<<<<< Update Credit >>>>>");
        return creditService.update(credit)
                .flatMap(creditUpdate -> Mono.just(ResponseEntity.ok(creditUpdate)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<Credit> delete(@PathVariable String id){
        log.info("<<<<< Delete Credit >>>>>");
        return creditService.delete(id);
    }

}
