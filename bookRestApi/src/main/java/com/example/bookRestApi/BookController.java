package com.example.bookRestApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BookController {
	private final BookRepository repository;
	
	BookController(BookRepository repository){
		this.repository = repository;
	};
	
	// get all books in database
	@GetMapping("/books")
	List<Book> all(){
		return this.repository.findAll();
	};
	
	// add a new book to the database
	@PostMapping("/books")
	Book newBook(@RequestBody Book newBook) {
		return this.repository.save(newBook);
	};
	
	// get single book by id in database
	@GetMapping("/books/{id}")
	Book one(@PathVariable Long id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new BookNotFoundException(id));
	};
	
	// update single book by id in database
	@PutMapping("/books/{id}")
	Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
		return this.repository.findById(id)
				.map(book -> {
					book.setIsbn(newBook.getIsbn());
					book.setTitle(newBook.getTitle());
					book.setNumPages(newBook.getNumPages());
					book.setAuthor(newBook.getAuthor());
					book.setImgUrl(newBook.getImgUrl());
					book.setBorrowed(newBook.getBorrowed());
					return this.repository.save(book);
				})
				.orElseGet(() -> {
					return this.repository.save(newBook);
				});
	};
	
	// deleting by book id in database
	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Long id) {
		this.repository.deleteById(id);
	};
}
