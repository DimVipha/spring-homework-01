package com.springhw.demo.service;

import com.springhw.demo.model.Todo;
import com.springhw.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
        int nextId = 1;
        if (lastTodo != null) {
            Integer lastId = lastTodo.getId();
            if (lastId != null) {
                nextId = lastId + 1;
            }
        }
        todo.setId(nextId);
        todoList.add(todo);
    }

    @Override
    public void edit(Integer id, Todo todo) {
        List<Todo> todoList = todoRepository.getTodoList();

        for (Todo existingTodo : todoList) {
            if (existingTodo.getId().equals(id)) {
                existingTodo.setTask(todo.getTask());
                existingTodo.setDescription(todo.getDescription());
                existingTodo.setIsDone(todo.getIsDone());
                break;
            }
        }
    }
    @Override
    public void deleteTodoById(Integer id) {
        Iterator<Todo> iterator = todoRepository.getTodoList().iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
    @Override
    public List<Todo> searchTodo(String task, Boolean isDone) {
        List<Todo> searchResults = new ArrayList<>();
        String searchQuery = task.toLowerCase(); // Convert search query to lowercase for case-insensitive comparison
        for (Todo todo : todoRepository.getTodoList()) {
            boolean taskMatch = todo.getTask().toLowerCase().contains(searchQuery);
            boolean isDoneMatch = isDone == null || todo.getIsDone() == isDone;
            if (taskMatch && isDoneMatch) {
                searchResults.add(todo);
            }
        }
        return searchResults;
    }



}
