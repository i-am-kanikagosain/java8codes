package com.example.SpringBootJdbcMysql.repository;

import java.util.List;

import com.example.SpringBootJdbcMysql.model.Book;

public interface BookRepository {

	int save(Book book);
	int update(Book book);
	Book findById(int id);
	int deleteById(int id);
	List<Book> findAll();
	List<Book> findByNameBookName(String name);
	int deleteAll();
	
}
