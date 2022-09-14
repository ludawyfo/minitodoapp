package com.minitodo.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Integer> {

	List<Todo> findByStatus(Status status);
	Todo findByTitel(String titel);

}
