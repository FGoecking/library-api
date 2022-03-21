package com.libraryApi.library.controllerTest;


import com.libraryApi.library.controller.BookController;
import com.libraryApi.library.models.BookDTO;
import com.libraryApi.library.service.BookService;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private BookController bookController;

    @MockBean
    private BookService bookService;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(this.bookController);
    }

    @Test
    public void shouldReturn200_WhenGetBookList(){

        when(bookService.getBookList())
                .thenReturn(Collections.singletonList(BookDTO.builder().name("name").build()));

        given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .get("/api/v1/book")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldReturn200_WhenGetBookByName(){

        when(bookService.getBookByName(Mockito.anyString()))
                .thenReturn(BookDTO.builder().name("name").build());

        given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .get("/api/v1/book/{bookName}/name", "name")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldReturn200_WhenSaveNewBook(){

        when(bookService.saveNewBook(Mockito.any(BookDTO.class)))
                .thenReturn(BookDTO.builder().name("name").build());

        given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(new BookDTO())
                .when()
                .post("/api/v1/book")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void shouldReturn200_WhenDeleteBook(){

        doNothing().when(bookService).deleteByName(Mockito.anyString());

        given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .delete("/api/v1/book/{bookName}/name", "name")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
