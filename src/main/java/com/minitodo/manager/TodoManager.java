package com.minitodo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.minitodo.entities.Todo;
import com.minitodo.service.TodoService;

@Component
public class TodoManager {

	private TodoService service;

	@Autowired
	public TodoManager(TodoService service) {
		this.service = service;
	}

	public Todo createTodo(String titel, String status) {
		return service.createTodo(titel, status);
	}
	
	public Todo createTodo(Todo todo) {
		return service.saveOrUpdateTodo(todo);
	}

	public Todo updateTodo(Todo todo) {
		return service.saveOrUpdateTodo(todo);
		
	}
	
	public Todo updateTodo(String titel, String status) {
		Todo todo = service.findTodoByTitel(titel).orElseThrow(() -> new RuntimeException("Todo doesn't exist."));

		todo.setStatus(status);
		return service.saveOrUpdateTodo(todo);

	}

	public Iterable<Todo> getAllTodos() {
		return service.findAllTodos();
	}

	public Todo getTodoByTitel(String titel) {
		return service.findTodoByTitel(titel).orElseThrow(() -> new RuntimeException("Todo not found."));
	}
	
	public Todo getTodoById(String id) {
		return service.findTodoById(id).orElseThrow(() -> new RuntimeException("Todo not found."));
	}

	public long totalCount() {
		return service.count();
	}

}
