package com.libraryApi.library.controller;


import com.libraryApi.library.models.BookDTO;
import com.libraryApi.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBookList(){
        return new ResponseEntity<>(bookService.getBookList(), HttpStatus.OK);
    }

    @GetMapping("/{bookName}/name")
    public ResponseEntity<BookDTO> getBookByName(@PathVariable String bookName){
        return new ResponseEntity<>(bookService.getBookByName(bookName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> saveNewBook(@RequestBody BookDTO bookDTO){
        return new ResponseEntity<>(bookService.saveNewBook(bookDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookName}/name")
    public ResponseEntity<BookDTO> deleteBookByName(@PathVariable String bookName){
        bookService.deleteByName(bookName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
