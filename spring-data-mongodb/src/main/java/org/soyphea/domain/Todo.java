package org.soyphea.domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document("todos")
@Getter
public class Todo {

  @Id
  private String id;
  private String name;
  private String description;
  private LocalDate dueDate;

  public Todo(String name, String description, LocalDate dueDate) {
    this.name = name;
    this.description = description;
    this.dueDate = dueDate;
  }
}
