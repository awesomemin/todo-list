package com.example.todo_list.controller;

import com.example.todo_list.domain.Todo;
import com.example.todo_list.repository.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    public final TodoRepository todoRepository;

    public HelloController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/add")
    public String addTodo(@RequestParam("title") String title) {
        todoRepository.save(title);
        return "저장 성공! 내용: " + title;
    }

    @GetMapping("/list")
    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }
}