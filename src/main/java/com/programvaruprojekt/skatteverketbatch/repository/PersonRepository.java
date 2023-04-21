package com.programvaruprojekt.skatteverketbatch.repository;

import com.programvaruprojekt.skatteverketbatch.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);

    Person findById(long id);
}
