package lnu.resources;

import lnu.dao.booksDAO;
import lnu.models.catalog;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/books")
public class RemoveBookResource {
    @DELETE
    @Path("{id}")
    public Response removeBooks(@PathParam("id") String id) {

        // Get the currently stored books
        catalog catalog = booksDAO.XMLToObject();

        // If book is not there, the removeBook method returns false. The response will then be a 404 Not Found.
        if (!catalog.removeBook(id)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // If it succeeds, the book is removed from the catalog and the XML is updated.
        // Lastly, an OK-response is returned.
        booksDAO.ObjectToXML(catalog);
        return Response.ok().build();
    }
}