package com.renangamero_todolist.todolist.model;

import com.renangamero_todolist.todolist.statusTodo.Status;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime doneDate; // apenas se concluída

    public Todo(Long id, String title, String description, Status status, LocalDateTime createdDate, LocalDateTime doneDate) {
        Id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
        this.doneDate = doneDate;
    }

    public Todo() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(LocalDateTime doneDate) {
        this.doneDate = doneDate;
    }
}
