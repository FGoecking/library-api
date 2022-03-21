package com.libraryApi.library.repository;

import com.libraryApi.library.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();
    Book findByName(String bookName);
    void deleteByName(String bookName);
}
