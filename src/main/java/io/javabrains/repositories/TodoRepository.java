package io.javabrains.repositories;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long>{

}
