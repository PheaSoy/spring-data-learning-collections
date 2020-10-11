package org.soyphea;

import java.util.Optional;
import org.soyphea.domain.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {

  Optional<Todo> findByName(String s);
}
