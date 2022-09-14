package com.minitodo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.minitodo.entities.Status;
import com.minitodo.entities.Todo;
import com.minitodo.manager.TodoManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiniTodoApplicationTests {
	
	private static final Logger log = LoggerFactory.getLogger(MiniTodoApplicationTests.class);

	@Autowired
	private TodoManager manager;
	
	
	@Before
	public void setUp() {
		// add logic here
	}
	
	@After
	public void tearDown() {
		// add logic here
	}
	
	@Test
	public void testCreateNewTodo() {
		executeSomeChecks(manager.createTodo("First Lesson", Status.OPEN));
		
		log.info("New Todo item successfully created.");
	}

	@Test
	public void testCreateAndSaveTodo() {
		executeSomeChecks(manager.createTodo("First Lesson", Status.OPEN));
		
		log.info("New Todo item successfully created and saved.");
	}
	
	@Test
	public void testCreateAndSaveTodos() {
		// First attempt
		executeSomeChecks(manager.createTodo("First Lesson", Status.OPEN));

		// Second attempt
		executeSomeChecks(manager.createTodo("Second Lesson", Status.OPEN));
		
		log.info("Some New Todo items successfully created and saved.");
	}
	
	@Test
	public void testCreateSaveEditTodos() {
		// First attempt
		executeSomeChecks(manager.createTodo("First Lesson", Status.OPEN));

		// Second attempt
		executeSomeChecks(manager.createTodo("Second Lesson", Status.OPEN));
		
		log.info("Some New Todo items successfully created and saved.");
		
		// Edit first Todo
		Todo first = manager.getTodoById(0);
		assertNull(first);
		log.info("No todo with id '0' found.");
		
		first = manager.getTodoById(1);
		assertNotNull(first);
		log.info("Todo with '1' {} found.", first);
		
		first.setStatus(Status.INPROCESS);
		manager.save(first);
		log.info("Todo status successfully changed from 'OPEN' to 'INPROCESS' {}", first);
		
	}
	
	private void executeSomeChecks(Todo todo) {
		assertNotNull(todo);
		log.info("not null {}", todo);
		
		log.info("saved {}", manager.save(todo));
		
		assertNotEquals(0, todo.getId());
		log.info("Id check successfull {}", todo);
	}


}
