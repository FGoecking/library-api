package com.libraryApi.library.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class LiteraryGenre {

    @Id
    @SequenceGenerator(name = "genre_sequece", sequenceName = "genre_sequece", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String genre;
}
