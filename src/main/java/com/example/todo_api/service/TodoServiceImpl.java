package com.example.todo_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo_api.model.TodoModel;
import com.example.todo_api.repo.TodoRepository;

@Service 
public class TodoServiceImpl implements TodoService{
    
    private TodoRepository todoRepo;

    public TodoServiceImpl(TodoRepository todoRepo){
        this.todoRepo = todoRepo;
    }

    @Override 
    public TodoModel createTodo(TodoModel task){
        return todoRepo.save(task); 
    }

    public List<TodoModel> getAllTodo(){
        return todoRepo.findAll();
    }

    @Override
    public TodoModel updateTodo(Long id,TodoModel task){
        TodoModel exTodo = todoRepo.findById(id).orElse(null);

        if(exTodo==null)
             return null;

        exTodo.setTask(task.getTask());
        return todoRepo.save(exTodo);
    }
  
    @Override
    public void deleteTodo(Long id){
        todoRepo.deleteById(id);
    }
}
