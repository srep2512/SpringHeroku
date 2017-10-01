package io.javabrains.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.entity.Todo;
import io.javabrains.repositories.TodoRepository;

@Service
public class Initializer {

	@Autowired
	TodoRepository todos;
	
	public void initialize() {
		todos.save(new Todo(1,"Essen"));
		todos.save(new Todo(2,"Sport"));
		todos.save(new Todo(3,"Lernen"));
		todos.save(new Todo(4,"Schlafen"));
		
	}
}
