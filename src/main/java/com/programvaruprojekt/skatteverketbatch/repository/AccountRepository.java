package com.programvaruprojekt.skatteverketbatch.repository;

import com.programvaruprojekt.skatteverketbatch.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findAccountById(int id);
    
    //find by owner
    Iterable<Account> findByOwner(Integer owner);
}
