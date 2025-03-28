package com.renangamero_todolist.todolist.controller;

import com.renangamero_todolist.todolist.model.Todo;
import com.renangamero_todolist.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PatchMapping("/{Id}/done")
    public ResponseEntity<Todo> finishTask(@PathVariable("Id") Long Id) {
        todoService.finishTask(Id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{Id}/reopen")
    public ResponseEntity<Todo> reopenTask(@PathVariable("Id") Long Id) {
        todoService.reopenTask(Id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{Id}")
    public Optional<Todo> getTodoForId(@PathVariable("Id") Long Id) {
        return todoService.getTodoForId(Id);
    }

    @GetMapping("/list")
    public List<Todo> listTodo() {
        return todoService.listTodo();
    }

    @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/{Id}")
    public Todo updateTodo(Long Id, @RequestBody Todo todo) {
        return todoService.updateTodo(Id, todo);
    }

    @DeleteMapping("/{Id}")
    public void deleteTodo(@PathVariable("Id") Long Id) {
        todoService.deleteTodo(Id);
    }

}
