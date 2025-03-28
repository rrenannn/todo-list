package com.renangamero_todolist.todolist.service;

import com.renangamero_todolist.todolist.model.Todo;
import com.renangamero_todolist.todolist.repository.TodoRepository;
import com.renangamero_todolist.todolist.statusTodo.Status;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    public void finishTask(Long Id) {
        Todo todo = todoRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setStatus(Status.DONE);
        todo.setDoneDate(LocalDateTime.now());
        todoRepository.save(todo);
    }

    public void reopenTask(Long Id) {
        Todo todo = todoRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        todo.setStatus(Status.PENDING);
        todo.setDoneDate(null);

        todoRepository.save(todo);
    }

    public List<Todo> listTodo() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoForId(Long Id) {
        return todoRepository.findById(Id);
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long Id, Todo todo) {
        todo.setId(Id);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long Id) {
        todoRepository.deleteById(Id);
    }

}
