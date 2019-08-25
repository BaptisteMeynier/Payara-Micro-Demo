package com.meynier.payara.micro.demo;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 */
@Path("book")
@ApplicationScoped
public class BookResource {

    @Context
    private UriInfo context;

    private Map<String, Book> library = new HashMap<>();

    /**
     * Get the value of library
     *
     * @return the value of library
     */
    public Map getLibrary() {
        return library;
    }

    /**
     * Set the value of library
     *
     * @param library new value of library
     */
    public void setLibrary(Map library) {
        this.library = library;
    }

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }

    /**
     * Retrieves representation of an instance of fish.payara.examples.rest.BookResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Book[] getJson() {
        return library.values().toArray(new Book[0]);
    }

    /**
     * Retrieves representation of an instance of fish.payara.examples.rest.BookResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{isbn}")
    @Produces("application/json")
    public JsonObject getJsonByIsbn(@PathParam("isbn") String isbn) {
        return Json.createObjectBuilder().add(isbn, library.get(isbn).getTitle()).build();
    }

    /**
     * PUT method for updating or creating an instance of BookResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(Book content) {
        System.out.println(content.toJson());
        library.put(UUID.randomUUID().toString(),content);
    }
}
