package com.example.demo.service;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("toDoService")
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    @Override
    public Optional<ToDo> getToDoById(Long id) {
        return toDoRepository.findById(id);
    }

    @Override
    public ToDo saveToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public void removeToDo(ToDo toDo) {
        toDoRepository.delete(toDo);
    }

    @Override
    public List<ToDo> getCompletedToDo(boolean completed) {
        return toDoRepository.findByCompleted(completed);
    }
}
