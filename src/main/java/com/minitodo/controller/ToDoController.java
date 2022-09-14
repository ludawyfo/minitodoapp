package com.minitodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Todo> showTodos(){
		return manager.getAllTodos();
	}
	
	@GetMapping("/todo/{id}")
	public Todo showTodoById(@PathVariable int id){
		return manager.getTodoById(id);
	}
	
	@GetMapping("/todo/{titel}")
	public Todo showTodoByTitel(@PathVariable String titel){
		return manager.getTodoByTitel(titel);
	}

}
