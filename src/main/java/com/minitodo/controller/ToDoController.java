package com.minitodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minitodo.entities.Todo;
import com.minitodo.manager.TodoManager;

@RestController
public class ToDoController {

	@Autowired
	private TodoManager manager;

	@GetMapping("/start")
	public String welcome() {
		return "Welcome to the TODO Panel";
	}

	@GetMapping("/todos")
	public ResponseEntity<Iterable<Todo>> showTodos() {
		return new ResponseEntity<>(manager.getAllTodos(), HttpStatus.OK);
	}

	@GetMapping("/todo/{titel}")
	public ResponseEntity<Todo> showTodoByTitel(@PathVariable String titel) {
		return new ResponseEntity<>(manager.getTodoByTitel(titel), HttpStatus.FOUND);
	}

	@PostMapping("/todos")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		return new ResponseEntity<>(manager.createTodo(todo), HttpStatus.CREATED);
	}

	@PutMapping("/todos")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
		return new ResponseEntity<>(manager.updateTodo(todo), HttpStatus.OK);

	}

}
