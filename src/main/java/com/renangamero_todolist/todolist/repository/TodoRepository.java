package com.renangamero_todolist.todolist.repository;

import com.renangamero_todolist.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
