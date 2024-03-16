package com.springhw.demo.service;

import com.springhw.demo.model.Todo;
import com.springhw.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TodoServiceImp implements TodoService {
    private  final  TodoRepository todoRepository;

    @Override
    public List<Todo> display() {
        return todoRepository.getTodoList();
    }

    @Override
    public Todo findById(Integer id) {
        return todoRepository.getTodoList().stream().filter(todo -> todo.getId()==id).findFirst().orElse(null);
    }


    @Override
    public void create(Todo todo) {
        List<Todo> todoList = todoRepository.getTodoList();
        Todo lastTodo = null;
        if (!todoList.isEmpty()) {
            lastTodo = todoList.get(todoList.size() - 1);
        }
        int nextId = 1; // Default ID if no tasks exist
        if (lastTodo != null) {
            Integer lastId = lastTodo.getId();
            if (lastId != null) {
                nextId = lastId + 1;
            }
        }
        todo.setId(nextId);
        todoList.add(todo);
    }

  /*  @Override
    public void edit(Integer id, Todo todo) {
        List<Todo> todoList = todoRepository.getTodoList();

        // Find the Todo with the matching ID using Java 8 Streams
        todoList.stream()
                .filter(existingTodo -> existingTodo.getId().equals(id))
                .findFirst()
                .ifPresent(existingTodo -> {
                    // Update the fields of the existing Todo with the new values
                    existingTodo.setTask(todo.getTask());
                    existingTodo.setDescription(todo.getDescription());
                    existingTodo.setIsDone(todo.getIsDone());
                    // Optionally, update other fields if needed
                    // Save the updated Todo back to the list or database
                    todoRepository.getTodoList();
                });
    }*/



    @Override
    public void edit(Integer id, Todo todo) {
        List<Todo> todoList = todoRepository.getTodoList();

        for (Todo existingTodo : todoList) {
            if (existingTodo.getId().equals(id)) {
                // Update the existing todo with the new values
                existingTodo.setTask(todo.getTask());
                existingTodo.setDescription(todo.getDescription());
                existingTodo.setIsDone(todo.getIsDone());
                // You can update other fields if needed
                break; // Exit the loop once the todo is found and updated
            }
        }
    }

    @Override
    public List<Todo> searchTodo(String task, Boolean isDone) {
        List<Todo> searchResults = new ArrayList<>();
        String searchQuery = task.toLowerCase(); // Convert search query to lowercase for case-insensitive comparison
        for (Todo todo : todoRepository.getTodoList()) {
            if (todo.getTask().toLowerCase().contains(searchQuery)) {
                searchResults.add(todo);
            }
        }
        return searchResults;
    }














/*
    TodoRepository todoRepository;
    @Override
    public String getAllTodos(Model model) {
//        List<Todo> todos = todoRepository.findAll(); // Assuming you have a TodoRepository injected
//        model.addAttribute("todos", todos);
        return "todos";
    }

    @Override
    public String getTodoById(Integer id, Model model) {
        return null;
    }

    @Override
    public String showAddTodoForm() {
        return null;
    }

    @Override
    public String addTodo(Todo todo) {

        return null;
    }

    @Override
    public String showEditTodoForm(Integer id, Model model) {
        return null;
    }

    @Override
    public String editTodo(Integer id, Todo todo) {
        return null;
    }

    @Override
    public String deleteTodo(Integer id) {
        todoRepository.deleteById(id); // Assuming you have a TodoRepository injected
        return "redirect:/todos";
//        return null;
    }

    @Override
    public String searchTodos(String task, Boolean isDone, Model model) {
        return null;
    }*/
}
