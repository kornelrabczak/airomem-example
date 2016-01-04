package com.thecookiezen.airomem.bussiness.boundary;

import com.thecookiezen.airomem.bussiness.control.BookRepository;
import com.thecookiezen.airomem.bussiness.entity.Book;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collection;

@Path("books")
public class BookResource {

    @Inject
    BookRepository bookStorage;

    @GET
    @Path("/")
    public Collection<Book> getAll() {
        return bookStorage.getAll();
    }

    @GET
    @Path("/{author}")
    public Collection<Book> getByAuthor(@PathParam("author") String author) {
        return bookStorage.getByAuthor(author);
    }
}
