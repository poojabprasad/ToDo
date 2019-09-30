package com.example.demo.controller;

import com.example.demo.exception.ToDoException;
import com.example.demo.model.ToDo;
import com.example.demo.service.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/todo")
public class ToDoController {
    private static Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @Autowired
    ToDoService toDoService;

    @GetMapping(value = "/")
    public ResponseEntity<List<ToDo>> getAllToDo() {
        logger.info("Returning all todo's");
        return new ResponseEntity<List<ToDo>>(toDoService.getAllToDo(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDo> getToDo(@PathVariable("id") Long id) throws ToDoException {
        logger.info("Searching the todo by id {}", id);
        Optional<ToDo> toDo = toDoService.getToDoById(id);
        if (!toDo.isPresent())
            throw new ToDoException("ToDo not found");

        return new ResponseEntity<>(toDo.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ToDo> deleteToDoById(@PathVariable("id") long id) throws ToDoException {
        logger.info("Deleting the todo with id {}", id);
        Optional<ToDo> toDo = toDoService.getToDoById(id);
        if (!toDo.isPresent())
            throw new ToDoException("Todo not found");

        toDoService.removeToDo(toDo.get());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<ToDo> saveToDo(@RequestBody ToDo toDo) {
        logger.info("Creating a new todo {}", toDo);
        return new ResponseEntity<ToDo>(toDoService.saveToDo(toDo), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/")
    public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo toDo) throws ToDoException {
        logger.info("Updating the todo : {}", toDo);
        Optional<ToDo> toDo1 = toDoService.getToDoById(toDo.getId());

        if (!toDo1.isPresent())
            throw new ToDoException("Unable to find the todo");

        return new ResponseEntity<>(toDoService.saveToDo(toDo), HttpStatus.OK);
    }

    @GetMapping(value = "/completed")
    public ResponseEntity<List<ToDo>> getCompletedTodo() {
        logger.info("Getting the list of completed todos");
        return new ResponseEntity<>(toDoService.getCompletedToDo(true), HttpStatus.OK);
    }

    @GetMapping(value = "/not-completed")
    public ResponseEntity<List<ToDo>> getNotCompletedTodo() {
        logger.info("Getting the list of completed todos");
        return new ResponseEntity<>(toDoService.getCompletedToDo(false), HttpStatus.OK);
    }
}
