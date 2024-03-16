package com.springhw.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private  Integer id;
    private  String task;
    private String description;
    private  Boolean isDone;
    private LocalDate createAt;
}
