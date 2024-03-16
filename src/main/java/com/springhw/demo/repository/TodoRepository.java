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
        todoList.add(new Todo(1,"homework","deadline",false, LocalDate.now()));
        todoList.add(new Todo(2,"spring homework","misunderstand",true, LocalDate.now()));
        todoList.add(new Todo(3,"react homework","deadline",true, LocalDate.now()));
        todoList.add(new Todo(4,"next homework","due to 17 march",false, LocalDate.now()));
        todoList.add(new Todo(1,"quiz","deadline",false, LocalDate.now()));


    }

}
