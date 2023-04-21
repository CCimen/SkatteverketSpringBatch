package com.programvaruprojekt.skatteverketbatch;

import com.programvaruprojekt.skatteverketbatch.model.Person;
import com.programvaruprojekt.skatteverketbatch.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class SkatteverketTransactionsApplication {

    private static final Logger log = LoggerFactory.getLogger(SkatteverketTransactionsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SkatteverketTransactionsApplication.class);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository repository) {
        return (args) -> {
            repository.save(new Person("Jack", "Bauer", LocalDate.of(1980, 1, 1)));
            repository.save(new Person("Chloe", "O'Brian", LocalDate.of(1980, 1, 1)));
            repository.save(new Person("Kim", "Bauer", LocalDate.of(1980, 1, 1)));
            repository.save(new Person("David", "Palmer", LocalDate.of(1980, 1, 1)));
            repository.save(new Person("Michelle", "Dessler", LocalDate.of(1980, 1, 1)));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Person person : repository.findAll()) {
                log.info(person.toString());
            }

            // fetch an individual customer by ID
            Person person = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(person.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }

}
