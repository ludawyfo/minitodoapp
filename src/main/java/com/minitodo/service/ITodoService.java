package com.minitodo.service;

import java.util.List;

import com.minitodo.entities.Status;
import com.minitodo.entities.Todo;

public interface ITodoService {
	
	public Todo createTodo(String titel, Status status);
	public Todo saveOrUpdateTodo(Todo todo);
	public List<Todo> findAllTodos();

}
