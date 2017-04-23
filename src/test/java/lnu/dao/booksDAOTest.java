package lnu.dao;

import lnu.models.book;
import lnu.models.catalog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by n41r0j on 2017-04-19.
 */
public class booksDAOTest {
    book testBook = new book("1", "Foundation", "Isaac Asimov", "Science Fiction", "164", "1951-08-21","Foundation is the first novel in Isaac Asimovs Foundation Trilogy (later expanded into The Foundation Series). Foundation is a cycle of five interrelated short stories, first published as a single book by Gnome Press in 1951. Collectively they tell the story of the Foundation, an institute to preserve the best of galactic civilization after the collapse of the Galactic Empire.");
    List<book> bookListExpected = new ArrayList<>();

    @Test
    public void XMLToObject() throws Exception {
        booksDAO booksDAO = new booksDAO();
        List<book> bookListFromDAO;

        /*
        The XML for this test contains one book, which we can verify. This XML is
        only used for this test.
         */
        String testXMLLocation = "src/test/resources/inputBooksDAOTest.xml";

        //The book inside the XML should convert to the following book object:

        bookListExpected.add(testBook);

        booksDAO.setXMLLocation(testXMLLocation);

        catalog cat = booksDAO.XMLToObject();
        bookListFromDAO = cat.getListOfBooks();

        assertEquals(bookListExpected.toString(),bookListFromDAO.toString());
    }

    @Test
    public void ObjectToXML() {
        booksDAO booksDAO = new booksDAO();

        String testXMLLocation = "src/test/resources/outputBooksDAOTest.xml";
        booksDAO.setXMLLocation(testXMLLocation);

        bookListExpected.add(testBook);

        catalog catalog = new catalog();
        catalog.setBooks(bookListExpected);

        booksDAO.ObjectToXML(catalog);

        assertEquals(testXMLLocation,booksDAO.getXMLLocation());
    }

}