package lnu.resources;

import lnu.dao.booksDAO;
import lnu.models.book;
import lnu.models.catalog;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class GetBookResource {
    catalog catalog = booksDAO.XMLToObject();

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") String id){

        if(catalog.getBook(id) == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok("[" + catalog.getBook(id).toJson() + "]",MediaType.APPLICATION_JSON).build();
    }
}