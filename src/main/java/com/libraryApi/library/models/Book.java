package com.libraryApi.library.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequece", sequenceName = "book_sequece", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

//    @Column
//    @ManyToOne
//    private List<LiteraryGenre> genres;
}
