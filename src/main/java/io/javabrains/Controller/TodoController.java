package io.javabrains.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.repositories.TodoRepository;

@RestController
public class TodoController {
	
	
	@Autowired
	TodoRepository todos;
	
	@RequestMapping("/todos")
	
	public Iterable hello() {		
		return todos.findAll();
	}

}
