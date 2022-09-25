package com.nttdata.servicetransacreac.service;


import com.nttdata.servicetransacreac.model.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
	 Mono<Transaction> save(Transaction transaction);

	    Mono<Transaction> update(Transaction transaction);

	    Flux<Transaction> findAll();

	    Mono<Transaction> getId(String id);

	    Mono<Void> delete(String id);
}
