package com.thecookiezen.airomem.bussiness.control;

import com.thecookiezen.airomem.bussiness.entity.Book;
import com.thecookiezen.airomem.bussiness.entity.Library;
import pl.setblack.airomem.core.PersistenceController;
import pl.setblack.airomem.core.builders.PersistenceFactory;
import pl.setblack.airomem.data.DataRoot;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Collection;

@Singleton
@Startup
public class BookRepository {

    private PersistenceController<DataRoot<LibraryView, Library>, LibraryView> controller;

    @PostConstruct
    public void init() {
        final PersistenceFactory factory = new PersistenceFactory();
        controller = factory.initOptional("library", () -> new DataRoot<>(new Library()));
    }

    public Collection<Book> getAll() {
        return controller.query(LibraryView::getAll);
    }

    public Collection<Book> getByAuthor(String author) {
        return controller.query(view -> view.getByAuthor(author));
    }
}
