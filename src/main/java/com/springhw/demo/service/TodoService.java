package com.springhw.demo.service;

import com.springhw.demo.model.Todo;

import java.util.List;

public interface TodoService {
     List<Todo> display();
     Todo findById(Integer id);
     void create(Todo todo);
     void edit(Integer id,Todo todo);
     List<Todo> searchTodo(String task, Boolean isDone);
//     void findID(Integer id);
//     void addnew();
//     void deleteById(Integer id);



/*   String getAllTodos(Model model);
    String getTodoById(Integer id, Model model);
    String showAddTodoForm();
    String addTodo(Todo todo);
    String showEditTodoForm(Integer id, Model model);
    String editTodo(Integer id, Todo todo);
    String deleteTodo(Integer id);
    String searchTodos( String task,Boolean isDone,Model model);*/
}
