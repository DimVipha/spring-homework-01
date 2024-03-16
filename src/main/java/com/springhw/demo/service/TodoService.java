package com.springhw.demo.service;

import com.springhw.demo.model.Todo;

import java.util.List;

public interface TodoService {
     List<Todo> display();
     Todo findById(Integer id);
     void create(Todo todo);
     void edit(Integer id,Todo todo);
     void deleteTodoById(Integer id);
     List<Todo> searchTodo(String task, Boolean isDone);

}
