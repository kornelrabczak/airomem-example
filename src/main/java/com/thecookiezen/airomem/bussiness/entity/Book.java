package com.thecookiezen.airomem.bussiness.entity;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String ISBN;
    private final String author;
    private final String title;

    public Book(String isbn, String author, String title) {
        this.ISBN = isbn;
        this.author = author;
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
