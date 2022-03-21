package com.libraryApi.library.service;

import com.libraryApi.library.models.Book;
import com.libraryApi.library.models.BookDTO;
import com.libraryApi.library.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BookDTO> getBookList(){

        List<Book> bookList = bookRepository.findAll();

        List<BookDTO> bookDTOList = new ArrayList<>();
        bookList.forEach(book -> {
            BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
            bookDTOList.add(bookDTO);
        });

        return bookDTOList;
    }

    public BookDTO getBookByName(String bookName){

        return modelMapper.map(bookRepository.findByName(bookName), BookDTO.class);
    }

    public BookDTO saveNewBook(BookDTO bookDTO) {

        Book book = modelMapper.map(bookDTO, Book.class);
        return modelMapper.map(bookRepository.save(book), BookDTO.class);
    }

    public void deleteByName(String bookName) {
        bookRepository.deleteByName(bookName);
    }
}
