package com.example.dao;

import java.util.List;

import com.example.model.Person;

public interface InterfaceDao<T> {
		
	boolean save(T t);          // CREATE 
  	
	T find(Long id);   // READ 
	
	public List<T> findAll();    // READ
	 
	public void update(T t);    // UPDATE
	 
	public boolean delete(T t); // DELETE
	
	public List<Person> find(String atributo, Object value);
	
	
}
