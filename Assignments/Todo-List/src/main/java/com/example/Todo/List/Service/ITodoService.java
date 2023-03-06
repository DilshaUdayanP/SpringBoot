package com.example.Todo.List.Service;


import com.example.Todo.List.Todo;

import java.util.List;

public interface ITodoService {

	public List<Todo> findAll();// Business Logic

	public Todo findById(int id);

	public void addTodo(Todo todo);

	public void deleteById(int id);

	public void updateById(int id, Todo newTodo);

}
