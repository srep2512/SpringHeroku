package io.javabrains.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	
	
	@RequestMapping("/")
	public String hello() {
		return "Hi Mates i've changed with Travis CIhs";
	}

}
