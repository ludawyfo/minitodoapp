package com.minitodo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minitodo.entities.Todo;
import com.minitodo.entities.TodoRepo;

@Service
public class TodoService {

	private TodoRepo repository;
	
	@Autowired
	public TodoService(TodoRepo repository) {
		this.repository = repository;
	}

	public TodoRepo getRepository() {
		return repository;
	}

	public void setRepository(TodoRepo repository) {
		this.repository = repository;
	}

	public Todo createTodo(String titel, String status) {
		return saveOrUpdateTodo(repository.findByTitel(titel).orElse(new Todo(titel, status)));
	}

	public Todo saveOrUpdateTodo(Todo todo) {
		return repository.save(todo);
	}

	public Iterable<Todo> findAllTodos() {
		return repository.findAll();
	}

	public Optional<Todo> findTodoByTitel(String titel) {
		return repository.findByTitel(titel);
	}
	
	public Optional<Todo> findTodoById(int id) {
		return repository.findById(id);
	}
	
	public long count() {
		return repository.count();
	}


}
