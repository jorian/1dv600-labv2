package lnu.resources;

import lnu.models.book;
import lnu.dao.booksDAO;
import lnu.models.catalog;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Response will be JSON
@Produces(MediaType.APPLICATION_JSON)

// This is the class that will be called when "localhost:9090/api/books" get called by the browser.
// FOR THE CURIOUS: Take a look in the config.yml to find out why "/api" is present in the path.
@Path("/books")
public class GetBooksResource {
	private List<book> books = new ArrayList<>();
	private booksDAO booksDAO = new booksDAO();

	@GET
	public Response getBooks() {
		catalog catalog = booksDAO.XMLToObject();
		books = catalog.getListOfBooks();

		System.out.println(books);

		ObjectMapper mapper = new ObjectMapper();

		String out;
		System.out.println(books.toString());
		if (books != null || books.size() != 0) {
			try {
				out = mapper.writeValueAsString(books);
			} catch (IOException e) {
				out = null;
				e.printStackTrace();
			}
		} else
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(out,MediaType.APPLICATION_JSON).build();
	}

	void setBookslist(List<book> list) {
		this.books = list;
	}

	List<book> getBooksList() {
		return this.books;
	}

}