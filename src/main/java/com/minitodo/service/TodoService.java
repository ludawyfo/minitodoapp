package com.minitodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minitodo.entities.Status;
import com.minitodo.entities.Todo;
import com.minitodo.entities.TodoRepo;

@Service
public class TodoService implements ITodoService {

	@Autowired
	private TodoRepo repository;

	public TodoService() {
		// Do nothing for now
	}

	public TodoRepo getRepository() {
		return repository;
	}

	public void setRepository(TodoRepo repository) {
		this.repository = repository;
	}

	@Override
	public Todo createTodo(String titel, Status status) {
		return new Todo(titel, status);
	}

	@Override
	public Todo saveOrUpdateTodo(Todo todo) {
		return repository.save(todo);
	}

	@Override
	public List<Todo> findAllTodos() {
		return repository.findAll();
	}

	public Todo findTodoById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Todo findTodoByTitel(String titel) {
		return repository.findByTitel(titel);
	}

	// Extras
	public void deleteTodo(Todo todo) {
		repository.delete(todo);
	}

	public long count() {
		return repository.count();
	}

	public List<Todo> findTodoByStatus(Status status) {
		return repository.findByStatus(status);
	}


}
