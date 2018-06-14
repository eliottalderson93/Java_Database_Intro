package com.erik.update_delete.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erik.update_delete.models.Book;
import com.erik.update_delete.repo.BookRepo;

@Service
public class BookService {
	private final BookRepo bookRepo;
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}
	public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book updateBook(Long id, String title, String desc, String lang, Integer numPages) {
    	Book existingBook = this.findBook(id);
    	if (existingBook == null) {
    		Book update = new Book(title, desc, lang, numPages);
    		this.createBook(update);
    		return update;
    	}
    	else {
    		existingBook.setTitle(title);
    		existingBook.setDescription(desc);
    		existingBook.setLanguage(lang);
    		existingBook.setNumberOfPages((int)numPages);
    		bookRepo.save(existingBook);
    		return existingBook;
    	}
    }
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    }
}
