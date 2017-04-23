import io.dropwizard.testing.junit.ResourceTestRule;
import lnu.dao.booksDAO;
import lnu.models.book;
import lnu.models.catalog;
import lnu.resources.*;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static java.lang.System.gc;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by JorianWielink on 05/03/2017.
 */
public class ApiTest {
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new AddBookResource())
            .addResource(new EditBookResource())
            .addResource(new GetBookResource())
            .addResource(new GetBooksResource())
            .addResource(new RemoveBookResource())
            .build();

    @Test
    public void testGetBooks() {
   //     assertThat(resources.client().target("/books").request().get(String.class))
   //             .isEqualTo(fixture("books.json"));
        assertThat(resources.client().target("/books").request().get().getStatus())
                .isEqualTo(200);
    }

    @Test
    public void testGetBook() {
        assertThat(resources.client().target("/books/545").request().get().getStatus())
                .isEqualTo(404);
        assertThat(resources.client().target("/books/4").request().get().getStatus())
                .isEqualTo(200);
        //After implementation this should return 200, since the book exists but the class is not implemented.
    }

    @Test
    public void testAddBook() {
        // Store current catalog:
        catalog initialCatalog = booksDAO.XMLToObject();
        System.out.println(initialCatalog.getListOfBooks());

        book testBookToAdd = new book("767", "TestTitle", "TestAuthor", "TestGenre", "123", "2009-09-09", "TestDescription");

        catalog catalog = new catalog();
        booksDAO.ObjectToXML(catalog);

        String json = testBookToAdd.toJson();
        System.out.println(json);

        assertThat(resources.client().target("/books/").request().put(Entity.json(json)).getStatus())
                .isEqualTo(200);

        catalog catalogOutput = booksDAO.XMLToObject();
        List<book> listOutput = catalogOutput.getListOfBooks();

        if (listOutput != null) {
            assertThat(listOutput.get(0).getAuthor()).isEqualTo(testBookToAdd.getAuthor());
        }
        // Clean up:
        booksDAO.ObjectToXML(initialCatalog);
    }

    @Test
    public void testEditBook() {
        //Stuff should happen here, using POST etc, but I couldn't find out how.
    }

    @Test
    public void testRemoveBook() {
        // Save the current state of books:
        catalog initialCatalog = booksDAO.XMLToObject();

        // First, set up the books.xml to always have a good 'book' to remove.
        book bookToRemove = new book();
        String id = "767";
        bookToRemove.setId(id);

        List<book> listBooks = new ArrayList<>();
        listBooks.add(bookToRemove);

        // Replace current books.xml:
        catalog catalog = new catalog();
        catalog.setBooks(listBooks);
        booksDAO.ObjectToXML(catalog);

        //Do the test.
        assertThat(resources.client().target("/books/" + id).request().delete().getStatus())
                .isEqualTo(200);

        // A second time should give a 404, since the book is removed:
        assertThat(resources.client().target("/books/" + id).request().delete().getStatus())
                .isEqualTo(404);

        // Empty bookID in url should return 404:
        assertThat(resources.client().target("/books/ ").request().delete().getStatus())
                .isEqualTo(404);

        // Clean up (restore initial book catalog):
        booksDAO.ObjectToXML(initialCatalog);
        System.out.println(booksDAO.XMLToObject().getListOfBooks());
        gc();
    }
}