package lnu.models;

import lnu.dao.booksDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JorianWielink on 23/04/2017.
 */
public class catalogTest {
    List<book> expectedBookList = new ArrayList<>();
    catalog catalog = new catalog();

    /*
    For these tests, a test XML location will be used.
     */
    @Before
    public void setUp() {
        book book1 = new book("book1", "book1", "book1", "book1", "999", "1999-09-09", "book1");
        book book2 = new book("book2", "book2", "book2", "book2", "999", "1999-09-09", "book2");

        expectedBookList.add(book1);
        expectedBookList.add(book2);
    }

    @Test
    public void getListOfBooks() throws Exception {
        booksDAO.setXMLLocation("/src/test/java/lnu/models/initialBooks.xml");

        catalog.setBooks(expectedBookList);
        List<book> actualBookList = catalog.getListOfBooks();
        assertEquals(expectedBookList,actualBookList);
    }


    @Test
    public void addBook() throws Exception {

    }

    @Test
    public void getBook() throws Exception {

    }

    @Test
    public void removeBook() throws Exception {

    }

    @Test
    public void editBook() throws Exception {

    }

    @After
    public void tearDown() {
        booksDAO.setXMLLocation("src/main/java/lnu/resources/books.xml");
    }
}