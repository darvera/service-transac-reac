package com.nttdata.servicetransacreac.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.nttdata.servicetransacreac.model.Transaction;


public interface TransactionRepository extends  ReactiveCrudRepository <Transaction, String>{

}
