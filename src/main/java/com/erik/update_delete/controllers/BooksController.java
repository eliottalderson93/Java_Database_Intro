package com.erik.update_delete.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erik.update_delete.models.Book;
import com.erik.update_delete.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;
	public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/books";
	}
    
    @GetMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        System.out.print(model);
        return "/books/index.jsp";
    }
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	System.out.println(result);
        if (result.hasErrors()) {
        	System.out.println("post had errors");
        	System.out.println(book.getTitle());
        	System.out.println(book.getDescription());
        	System.out.println(book.getLanguage());
        	System.out.println(book.getNumberOfPages());
            return "redirect:/books/new";
        } 
        else{
        	System.out.println("VALID post");
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    @RequestMapping("/books/show/{book_id}")
    public String show(@PathVariable("book_id") String book_id, Model model) {
    	long bkId = Long.valueOf(book_id);
    	Book showBook = bookService.findBook(bkId);
    	if(showBook == null) {
    		return "redirect:/books/new";
    	}
    	model.addAttribute("ID", showBook.getId());
    	model.addAttribute("title", showBook.getTitle());
    	model.addAttribute("desc", showBook.getDescription());
    	model.addAttribute("lang", showBook.getLanguage());
    	model.addAttribute("numPages", showBook.getNumberOfPages());
    	return "/books/show.jsp";
    }

}
