package com.erik.update_delete.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erik.update_delete.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search); //see Spring Data JPA docs
	Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    void deleteById(Long id);
    //Book updateBook(Long id, String title, String desc, String lang, Integer numPages);
}
