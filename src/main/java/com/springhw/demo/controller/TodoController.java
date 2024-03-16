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

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
//    @GetMapping
//    public String getAllTodos(Model model) {
//        List<Todo> todoList = todoService.display();
//        model.addAttribute("todos", todoList);
//        return "redirect:/todo";
//    }

/*    @GetMapping("/todo/{id}")
    public String detailPage(@PathVariable int id, Model model){
        Todo todoList = todoService.findById(id);
        model.addAttribute("todos",todoList);
        return "index";
    }*/

    @GetMapping("/todo/{id}")
    public String getTodoById(@PathVariable Integer id, Model model) {
        // Implement retrieving a todo by id
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

/*    @GetMapping("/todo/edit")
    public String showEditTodoForm(@ModelAttribute Integer id, Model model) {
        Todo findTask = todoService.findById(id);
        model.addAttribute("todo",findTask);
        return "edit";
    }

    @PostMapping("/todo/edit/{id}")
    public String editTodo(@PathVariable Integer id, @ModelAttribute Todo todo){
        todoService.edit(todo.getId(), todo);
        return "redirect:/todo";
    }*/

    @GetMapping("/todo/edit/{id}")
    public String showEditTodoForm(@PathVariable Integer id, Model model) {
        // Implement displaying edit form for a todo
        Todo todo = todoService.findById(id);
        model.addAttribute("todos", todo); // Change "todos" to "todo"
        return "edit";
    }

    @PostMapping("/todo/edit/{id}")
    public String editTodo(@PathVariable Integer id, @ModelAttribute Todo todo) {
        // Implement updating a todo
        todoService.edit(id, todo); // Pass the ID as a separate parameter
        return "redirect:/todo";
    }


/*    @GetMapping("/todo/edit")
    public String showEditTodoForm(@ModelAttribute Integer id, Model model) {
        // Implement displaying edit form for a todo
        Todo todo = todoService.findById(id);
        model.addAttribute("todos", todo);
        return "edit";
    }

    @PostMapping("/todo/edit/{id}")
    public String editTodo(@PathVariable Integer id, @ModelAttribute Todo todo) {
        // Implement updating a todo
        todoService.edit(todo.getId(), todo);
        return "redirect:/todo";
    }*/

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        // Implement deleting a todo
        return "redirect:/todo";
    }

/*    @GetMapping("/todo/search")
    public String searchTodos(@RequestParam(required = false) String task,
                              @RequestParam(required = false) Boolean isDone,
                              Model model) {
        // Implement searching todos by task and isDone status
        List<Todo> searchResults = todoService.searchTodo(task, isDone);
        model.addAttribute("todos", searchResults);
        return "search"; // Return the name of the HTML template
    }*/
/*
    @GetMapping("/todo/search")
    public String searchTodos(@RequestParam(required = false) String task,@ModelAttribute Model model) {
        List<Todo> searchResults = todoService.searchTodo(task, null); // Pass null for isDone
        model.addAttribute("todos", searchResults);
        return "search";
    }*/

  /*  @GetMapping("/todo/search")
    public String searchTodos(@RequestParam(required = false) String task,
                              @RequestParam(required = false) Boolean isDone,
                              Model model) {
        // Implement searching todos by task and isDone status
        List<Todo> searchResults = todoService.searchTodo(task, isDone);
        model.addAttribute("todos", searchResults);
        return "redirect:/todo";
    }
*/

    @GetMapping("/todo/search")
    public String searchTodos(@RequestParam(required = false) String task,
                              @RequestParam(required = false) Boolean isDone,
                              Model model) {
        List<Todo> searchResults = todoService.searchTodo(task, isDone);
        model.addAttribute("todos", searchResults);
        return "search"; // Assuming your view is named "todo-list.html"
    }

}
