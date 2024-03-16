package com.springhw.demo.controller;

import com.springhw.demo.model.Todo;
import com.springhw.demo.repository.TodoRepository;
import com.springhw.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Server;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    @GetMapping("/todo")
    public String index(Model model){
        List<Todo> todoList = todoService.display();
        model.addAttribute("todos",todoList);
        return "index";
    }

    @GetMapping("/todo/{id}")
    public String getTodoById(@PathVariable Integer id, Model model) {
        Todo todoList = todoService.findById(id);
        model.addAttribute("todos",todoList);
        return "index";
    }

    @GetMapping("/todo/new")
    public String showAddTodoForm(Model model) {
       Todo todo = new Todo();
       model.addAttribute("todos",todo);
        return "create";
    }

    @PostMapping("todo/new")
    public String addTodo(@ModelAttribute("todos") Todo todo) {
        todoService.create(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/edit/{id}")
    public String showEditTodoForm(@PathVariable Integer id, Model model) {
        // Implement displaying edit form for a todo
        Todo todo = todoService.findById(id);
        model.addAttribute("todos", todo); // Change "todos" to "todo"
        return "edit";
    }
    @PostMapping("/todo/edit/{id}")
    public String editTodo(@PathVariable Integer id, @ModelAttribute Todo todo) {
        todoService.edit(id, todo);
        return "redirect:/todo";
    }
    @PostMapping("/todo/delete/{id}")
    public String deleteTodoById(@PathVariable Integer id) {
        todoService.deleteTodoById(id);
        return "redirect:/todo";
    }
    @GetMapping("/todo/search")
    public String searchTodos(@RequestParam(required = false) String task,
                              @RequestParam(required = false) Boolean isDone,
                              Model model) {
        List<Todo> searchResults = todoService.searchTodo(task, isDone);
        model.addAttribute("todos", searchResults);
        return "search";
    }


}
