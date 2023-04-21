package com.programvaruprojekt.skatteverketbatch.repository;

import com.programvaruprojekt.skatteverketbatch.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    // Find by sender
    Iterable<Transaction> findBySender(Integer sender);

    //find by receiver
    Iterable<Transaction> findByReceiver(Integer receiver);

    //find by date
    Iterable<Transaction> findByDate(LocalDate date);
}
