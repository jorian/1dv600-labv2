package lnu.resources;

import lnu.dao.booksDAO;
import lnu.models.book;
import lnu.models.catalog;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/books")
public class EditBookResource {

    //     Edit book replaces the old book with a newer version. This class does basically the same as addBook.

    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") String id, String json){

        // Retrieve current catalog of books.
        catalog catalog = booksDAO.XMLToObject();
        book toEdit;

        // This converts the json to a book object
        try{
            ObjectMapper mapper = new ObjectMapper();
            toEdit = mapper.readValue(json, book.class);
        } catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        // Since the method editBook is a boolean, it will return false if the book is not found or unable to update.
        // If it is false, the Response will be a 404.
        if (!catalog.editBook(toEdit)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // If not false, the XML is updated and a correct Response is returned.
        booksDAO.ObjectToXML(catalog);
        return Response.ok().build();
    }
}