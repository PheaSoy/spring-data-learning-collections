package org.soyphea.controller;

import java.util.List;
import org.soyphea.TodoRepository;
import org.soyphea.domain.Todo;
import org.soyphea.exception.TodoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

  @Autowired
  private TodoRepository todoRepository;

  @PostMapping
  public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
    return ResponseEntity.ok(todoRepository.save(todo));
  }

  @GetMapping
  public List<Todo> getTodoList() {
    List<Todo> todos = todoRepository.findAll();
    return todos;
  }

  @GetMapping("/{name}")
  public ResponseEntity<Todo> findTodoName(@PathVariable("name") String name) {
    Todo todo = todoRepository.findByName(name).orElseThrow(
        () -> new TodoNotFoundException(String.format("Todo with name %s is not found", name)));
    return ResponseEntity.ok(todo);
  }

  @DeleteMapping("/{name}")
  public ResponseEntity<Void> deleteTodoByName(@PathVariable("name") String name) {
    Todo todo = todoRepository.findByName(name).orElseThrow(
        () -> new TodoNotFoundException(String.format("Todo with name %s is not found", name)));
    todoRepository.deleteById(todo.getId());
    return ResponseEntity.ok().build();
  }


}
