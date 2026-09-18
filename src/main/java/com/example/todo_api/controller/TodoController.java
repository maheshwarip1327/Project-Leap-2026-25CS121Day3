package com.example.todo_api.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.model.TodoModel;
import com.example.todo_api.service.TodoService;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController 
//http://localhost:8080/todos
@RequestMapping("/todos")
public class TodoController {
     
    private TodoService todoSer;

    public TodoController(TodoService todoSer){
        this.todoSer = todoSer;
    }

    //http://localhost:8080/todos/createTodo
    @PostMapping("/createTodo")
    public TodoModel createTodo(@RequestBody TodoModel task){
        return todoSer.createTodo(task);
    }

    //http://localhost:8080/todos/getTodo
    @GetMapping("/getTodo")
    public List<TodoModel> getAllTodo(){
        return todoSer.getAllTodo();
    }

    //http://localhost:8080/todos/updateTodo/1
    @PutMapping("/updateTodo/{id}")
    public TodoModel updateTodo(@PathVariable Long id, @RequestBody TodoModel task){
        return todoSer.updateTodo(id, task);
    }

    //http://localhost:8080/todos/deleteTodo/1
    @DeleteMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable Long id){
         todoSer.deleteTodo(id);
         return "ur task has been deleted";
    }
    
}
