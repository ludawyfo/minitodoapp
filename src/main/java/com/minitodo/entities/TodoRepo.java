package com.minitodo.entities;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<Todo, String> {

	Optional<Todo> findByTitel(String titel);

}
