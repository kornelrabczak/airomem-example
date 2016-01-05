package com.thecookiezen.airomem.bussiness.boundary;

import com.fasterxml.jackson.databind.JsonNode;
import com.thecookiezen.airomem.bussiness.control.BookRepository;
import com.thecookiezen.airomem.bussiness.entity.Book;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collection;

@Path("books")
@Produces("application/json")
@Consumes("application/json")
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

    @POST
    @Path("/")
    public void createBook(JsonNode jsonObject) {
        final String title = jsonObject.get("title").asText();
        final String author = jsonObject.get("author").asText();
        bookStorage.create(title, author);
    }
}
