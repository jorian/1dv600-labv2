package lnu.resources;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.org.apache.regexp.internal.RE;
import lnu.dao.booksDAO;
import lnu.models.book;
import lnu.models.catalog;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.print.Book;
import java.io.IOException;

// Response will be JSON
@Produces(MediaType.APPLICATION_JSON)

// This is the class that will be called when "localhost:9090/api/books" get called by the browser.
// FOR THE CURIOUS: Take a look in the config.yml to find out why "/api" is present in the path.
@Path("/books")
public class GetBooksResource {

	@GET
	public String getBooks() {
		book sampleBook = new book("Hallo,",
				"Henk",
				"Fiction",
				"1999-10-10",
				"100",
				"This book is so utterly boring",
				"100.45");

		int length = 0;
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString += mapper.writeValueAsString(sampleBook);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(jsonString);
		return "[" + jsonString + "]";
	}

}

	/*private booksDAO read = new booksDAO();

	@GET
	public Response getBooks(@DefaultValue("All") @QueryParam("title") String title) {
		catalog books = read.BooksFromFile();
		if(books == null){
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		if(books.getBooks().size() == 0){
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		if(title.equals("All")){
			return Response.ok("[" + books.toJson() + "]",MediaType.APPLICATION_JSON).build();
		}else {
			catalog filter = new catalog();
			books.filterBooks(filter, title);
			if(filter.getBooks().isEmpty()){
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			return Response.ok("[" + filter.toJson() + "]",MediaType.APPLICATION_JSON).build();
		}
	}

}

	*/