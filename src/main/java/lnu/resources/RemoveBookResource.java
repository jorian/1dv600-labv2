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
        catalog catalog = booksDAO.XMLToObject();

        if(!catalog.removeBook(id)){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        booksDAO.ObjectToXML(catalog);
        return Response.ok().build();
    }
}