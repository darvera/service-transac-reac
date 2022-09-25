package com.nttdata.servicetransacreac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.servicetransacreac.model.Transaction;
import com.nttdata.servicetransacreac.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping()
    public Flux<Transaction> findAll(){
        return transactionService.findAll();
    }

    @PostMapping()
    public Mono<Transaction> save(@RequestBody Transaction t){
        return transactionService.save(t);
    }

    @PutMapping()
    public Mono<Transaction> update(@RequestBody Transaction p){
        return transactionService.update(p);
    }

    @GetMapping(value = "/{id}")
    public Mono<Transaction> findById(@PathVariable("id") String id){
        return transactionService.getId(id);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return transactionService.delete(id);
    }
}
