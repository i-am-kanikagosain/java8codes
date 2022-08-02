package com.example.dao;

import java.util.List;

import com.example.model.Person;

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
