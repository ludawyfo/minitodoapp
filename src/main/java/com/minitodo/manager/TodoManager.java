package com.minitodo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.minitodo.entities.Status;
import com.minitodo.entities.Todo;
import com.minitodo.service.TodoService;

@Component
public class TodoManager {

	@Autowired
	private TodoService service;

	public TodoManager() {
		// Do nothing for now
	}

	public Todo createTodo(String titel, Status status) {
		return service.createTodo(titel, status);
	}

	public Todo save(Todo todo) {
		return service.saveOrUpdateTodo(todo);
	}

	public List<Todo> getAllTodos() {
		return service.findAllTodos();
	}

	public Todo getTodoById(int id) {
		return service.findTodoById(id);
	}

	public Todo getTodoByTitel(String titel) {
		return service.findTodoByTitel(titel);
	}

	public List<Todo> getTodoByStatus(Status status) {
		return service.findTodoByStatus(status);
	}
}
