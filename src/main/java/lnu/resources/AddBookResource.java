package lnu.resources;

import lnu.dao.booksDAO;
import lnu.models.book;
import lnu.models.catalog;
import org.codehaus.jackson.map.ObjectMapper;


import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/books")
public class AddBookResource {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(String json){
        catalog catalog = booksDAO.XMLToObject();
        System.out.println(json);
        book toAdd;

        try{
            ObjectMapper mapper = new ObjectMapper();
            toAdd = mapper.readValue(json, book.class);
        } catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if(toAdd.getId() == null){
            toAdd.setId((String.valueOf(catalog.getHighestId() + 1)));
        }

        System.out.println(toAdd);

        catalog.addBook(toAdd);
        booksDAO.ObjectToXML(catalog);
        return Response.ok().build();
    }
}
