package com.thecookiezen.airomem.bussiness.control;

import com.thecookiezen.airomem.bussiness.entity.Book;

import java.util.Collection;

public interface LibraryView {
    void addNewBook(String title, String author);

    Collection<Book> getAll();

    Book getByISBN(String ISBN);

    Collection<Book> getByAuthor(String author);

    Collection<Book> getByTitle(String title);
}
