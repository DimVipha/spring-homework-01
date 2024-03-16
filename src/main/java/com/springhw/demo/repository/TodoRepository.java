package com.springhw.demo.repository;

import com.springhw.demo.model.Todo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter

public class TodoRepository {
    List<Todo> todoList = new ArrayList<>();
    public TodoRepository(){
        todoList.add(new Todo(1,"projects","1 april",false, LocalDate.now()));
        todoList.add(new Todo(2,"spring homework","deadline today",true, LocalDate.now()));
        todoList.add(new Todo(3,"react homework","deadlined",true, LocalDate.now()));
        todoList.add(new Todo(4,"next homework","due to 17 march",false, LocalDate.now()));
        todoList.add(new Todo(5,"quiz","Monday",false, LocalDate.now()));


    }

}
