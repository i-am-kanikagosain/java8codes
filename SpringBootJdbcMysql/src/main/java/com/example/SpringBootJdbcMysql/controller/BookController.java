package com.example.SpringBootJdbcMysql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootJdbcMysql.model.Book;
import com.example.SpringBootJdbcMysql.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/book")
	  public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String book_name) {
	    try {
	      List<Book> books = new ArrayList<Book>();
	      if (book_name == null)
	    	  bookRepository.findAll().forEach(books::add);
	      else
	    	  bookRepository.findByNameBookName(book_name).forEach(books::add);
	      if (books.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(books, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/books/{id}")
	  public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Book book = bookRepository.findById(id);
	    if (book != null) {
	      return new ResponseEntity<>(book, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@PostMapping("/books")
	  public ResponseEntity<String> addNewBook(@RequestBody Book book) {
	    try {
	    	bookRepository.save(new Book(book.getBook_id(), book.getBook_name(), book.getAuthor_name(), book.getBook_type(), book.getTotal_pages(), book.getQuantity()));
	      return new ResponseEntity<>("Book is added successfully.", HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PutMapping("/books/{id}")
	  public ResponseEntity<String> updateBook(@PathVariable("id") int id, @RequestBody Book _book) {
	    Book book = bookRepository.findById(id);
	    if (book != null) {
	    	book.setBook_id(id);
	    	book.setBook_name(_book.getBook_name());
	    	book.setAuthor_name(_book.getAuthor_name());
	    	book.setBook_type(_book.getBook_type());
	    	book.setTotal_pages(_book.getTotal_pages());
	    	book.setQuantity(_book.getQuantity());
	    	bookRepository.update(book);
	      return new ResponseEntity<>("Book is updated successfully.", HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>("Cannot find Book with id=" + id, HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/books/{id}")
	  public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
	    try {
	      int result = bookRepository.deleteById(id);
	      if (result == 0) {
	        return new ResponseEntity<>("Cannot find Book with id=" + id, HttpStatus.OK);
	      }
	      return new ResponseEntity<>("Book was deleted successfully.", HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>("Cannot delete book.", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@DeleteMapping("/books")
	  public ResponseEntity<String> deleteAllBooks() {
	    try {
	      int numRows = bookRepository.deleteAll();
	      return new ResponseEntity<>("Deleted " + numRows + " Book(s) successfully.", HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>("Cannot delete books.", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	

}
