package lnu.resources;

import lnu.models.book;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by n41r0j on 2017-04-19.
 */
public class GetBooksResourceTest {
    @Test
    public void get2Books() throws Exception {
        GetBooksResource getBooksResource = new GetBooksResource();
        List<book> bookList = new ArrayList<>();

        //book book1 = new book("Masters of London", "Stimorol");
        //book book2 = new book("Amsterdam", "Andre Hazes");
        getBooksResource.setBookslist(bookList);

        ObjectMapper om = new ObjectMapper();
        String testoutput = om.writeValueAsString(bookList);

        assertEquals(testoutput,getBooksResource.getBooks());
    }

    @Test
    public void get1Book() throws Exception {
        GetBooksResource getBooksResource = new GetBooksResource();
        List<book> bookList = new ArrayList<>();

        //book book1 = new book("Masters of London", "Stimorol");
        getBooksResource.setBookslist(bookList);

        ObjectMapper om = new ObjectMapper();
        String testoutput = om.writeValueAsString(bookList);

        assertEquals(testoutput,getBooksResource.getBooks());
    }

    @Test
    public void get0Books() throws Exception {
        GetBooksResource getBooksResource = new GetBooksResource();
        List<book> bookList = new ArrayList<>();

        getBooksResource.setBookslist(bookList);

        ObjectMapper om = new ObjectMapper();
        String testoutput = om.writeValueAsString(bookList);

        assertEquals(testoutput,getBooksResource.getBooks());
    }
}