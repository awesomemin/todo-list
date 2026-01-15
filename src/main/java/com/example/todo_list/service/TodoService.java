package com.example.todo_list.service;

import com.example.todo_list.domain.Todo;
import com.example.todo_list.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public String getHello() {
        return "Hello, Spring Boot!";
    }

    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    public String addTodo(String title) {
        todoRepository.save(title);
        return "저장 성공! " + title;
    }

    public boolean checkDone(Long id) {
        return todoRepository.checkDone(id);
    }
}