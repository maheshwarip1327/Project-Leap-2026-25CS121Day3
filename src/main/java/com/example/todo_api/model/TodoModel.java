package com.example.todo_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity 
@Table(name = "todos")
public class TodoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String task;
   public Long getId() {
    return id;
   }
   public void setId(Long id) {
    this.id = id;
   }
   public String getTask() {
    return task;
   }
   public void setTask(String task) {
    this.task = task;
   }
}
