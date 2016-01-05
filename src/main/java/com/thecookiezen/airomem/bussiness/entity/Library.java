package com.thecookiezen.airomem.bussiness.entity;

import com.thecookiezen.airomem.bussiness.control.LibraryView;
import pl.setblack.airomem.core.WriteChecker;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library implements LibraryView, Serializable {

    private static final long serialVersionUID = 1L;

    private CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();

    @Override
    public void addNewBook(String title, String author) {
        assert WriteChecker.hasPrevalanceContext();
        final Book book = new Book(UUID.randomUUID().toString(), author, title);
        this.books.add(book);
    }

    @Override
    public Collection<Book> getAll() {
        return this.books;
    }

    @Override
    public Book getByISBN(String ISBN) {
        final Predicate<Book> bookPredicate = b -> b.getISBN().equals(ISBN);
        return this.books.stream().filter(bookPredicate).findAny().get();
    }

    @Override
    public Collection<Book> getByAuthor(String author) {
        final Predicate<Book> bookPredicate = b -> b.getAuthor().equals(author);
        return findByPredicate(bookPredicate);
    }

    @Override
    public Collection<Book> getByTitle(String title) {
        final Predicate<Book> bookPredicate = b -> b.getTitle().equals(title);
        return findByPredicate(bookPredicate);
    }

    private Collection<Book> findByPredicate(Predicate<Book> bookPredicate) {
        return this.books.stream().filter(bookPredicate).collect(Collectors.toList());
    }
}
