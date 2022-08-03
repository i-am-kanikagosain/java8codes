package com.example.SpringBootJdbcMysql.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringBootJdbcMysql.model.Book;

@Repository
public class JdbcBookRepository implements BookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Book book) {
		return jdbcTemplate.update("INSERT INTO book_info (book_id, book_name, author_name, book_type, total_pages, quantity) VALUES(?,?,?,?,?,?)",
		        new Object[] { book.getBook_id(), book.getBook_name(), book.getAuthor_name(), book.getBook_type(), book.getTotal_pages(), book.getQuantity() });
	}

	@Override
	public int update(Book book) {
		return jdbcTemplate.update("UPDATE book_info SET book_name=?, author_name=?, book_type=?, total_pages=?, quantity=? WHERE book_id=?",
		        new Object[] { book.getBook_name(), book.getAuthor_name(), book.getBook_type(), book.getTotal_pages(), book.getQuantity(), book.getBook_id() });
	}

	@Override
	public Book findById(int id) {
		try {
			Book book = (Book) jdbcTemplate.queryForObject("SELECT * FROM book_info WHERE book_id=?",
			          BeanPropertyRowMapper.newInstance(Book.class), id);
			      return book;
		}
		catch (IncorrectResultSizeDataAccessException e) {
		      return null;
		}
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM book_info WHERE book_id=?", id);
	}

	@Override
	public List<Book> findAll() {
		return (List<Book>) jdbcTemplate.query("SELECT * from book_info", BeanPropertyRowMapper.newInstance(Book.class));
	}

	@Override
	public List<Book> findByNameBookName(String name) {
		String q = "SELECT * from book_info WHERE book_name LIKE '%" + name + "%'";
	    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Book.class));
	}

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("DELETE from book_info");
	}

}
