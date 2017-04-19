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
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") String id, String json){
        System.out.println("id: " + id);
        System.out.println("json: " + json);

        catalog catalog = booksDAO.XMLToObject();
        book toEdit;
        try{
            ObjectMapper mapper = new ObjectMapper();
            toEdit = mapper.readValue(json, book.class);
        } catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        if (!catalog.editBook(toEdit)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        booksDAO.ObjectToXML(catalog);
        return Response.ok().build();
    }
}