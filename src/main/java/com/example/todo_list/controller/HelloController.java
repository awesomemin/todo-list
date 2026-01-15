package com.example.todo_list.controller;

import com.example.todo_list.domain.Todo;
import com.example.todo_list.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    public final TodoService todoService;

    public HelloController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return todoService.getHello();
    }

    @GetMapping("/add")
    public String addTodo(@RequestParam("title") String title) {
        return todoService.addTodo(title);
    }

    @GetMapping("/list")
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }

    @GetMapping("/done/{id}")
    public boolean checkDone(@PathVariable Long id) {
        return todoService.checkDone(id);
    }
}