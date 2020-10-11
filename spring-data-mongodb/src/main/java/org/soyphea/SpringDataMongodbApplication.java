package org.soyphea;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.soyphea.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataMongodbApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringDataMongodbApplication.class, args);
  }

  @Autowired
  private TodoRepository todoRepository;
  List<Todo> todos = Arrays
      .asList(new Todo("Read Book Building MicroService", "To explore more on microservice",
              LocalDate.of(2020, 10, 15)),
          new Todo("Learning more on Spring Cloud Gateway",
              "The framework for building API Gateway for microservice",
              LocalDate.of(2020, 10, 30)));

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
      todoRepository.deleteAll();
      todoRepository.saveAll(todos);
      todoRepository.findAll().forEach(System.out::println);
    };
  }

}
