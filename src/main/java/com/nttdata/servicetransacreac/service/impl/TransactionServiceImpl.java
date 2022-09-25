package com.nttdata.servicetransacreac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.servicetransacreac.dao.TransactionRepository;
import com.nttdata.servicetransacreac.model.Transaction;
import com.nttdata.servicetransacreac.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Mono<Transaction> save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Mono<Transaction> update(Transaction transaction) {
		 return transactionRepository.findById(transaction.getId())
	                .switchIfEmpty(Mono.error(RuntimeException::new))
	                .flatMap(v -> transactionRepository.save(transaction));
	}

	@Override
	public Flux<Transaction> findAll() {
	
		return transactionRepository.findAll()
		        .filter(x  ->  x.getStatus() == 1);
	}

	@Override
	public Mono<Transaction> getId(String id) {
		
		return transactionRepository.findById(id)
				.switchIfEmpty(Mono.error(RuntimeException::new));
	}

	@Override
	public Mono<Void> delete(String id) {
		 return transactionRepository.findById(id)
	                .switchIfEmpty(Mono.error(RuntimeException::new))
	                .flatMap(x -> transactionRepository.deleteById(id));
	}

}
