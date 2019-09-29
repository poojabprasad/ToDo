package com.example.demo.service;

import com.example.demo.model.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    public List<ToDo> getAllToDo();
    public Optional<ToDo> getToDoById(Long id);
    public ToDo saveToDo(ToDo toDo);
    public void removeToDo(ToDo toDo);
    public List<ToDo> getCompletedToDo(boolean completed);
}
