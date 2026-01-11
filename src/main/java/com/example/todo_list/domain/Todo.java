package com.example.todo_list.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private boolean done;
}