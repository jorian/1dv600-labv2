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
    public void getBooks() throws Exception {
        //Set up
        GetBooksResource getBooksResource = new GetBooksResource();

        book book1 = new book("Masters of London", "Stimorol");
        book book2 = new book("Amsterdam", "Andre Hazes");

        List<book> bookList = new ArrayList<>(2);
        bookList.add(book1);
        bookList.add(book2);

        getBooksResource.setBookslist(bookList);

        ObjectMapper om = new ObjectMapper();
        String testoutput = om.writeValueAsString(bookList);

        assertEquals(testoutput,getBooksResource.getBooks());
    }

}