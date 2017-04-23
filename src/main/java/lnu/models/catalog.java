package lnu.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
/**
 * Created by n41r0j on 2017-04-19.
 */

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class catalog {

    // These methods are called from the corresponding Resource classes.
    // This catalog should always be up to date, by using booksDAO, before doing operations!

    @XmlElement(name = "book")
    private List<book> books = new ArrayList<>();

    public List<book> getListOfBooks() {
        return books;
    }

    public void setBooks(List<book> books) {
        this.books = books;
    }

    public void addBook(book book) {
        System.out.println(book);
        assert book!= null;
        this.books.add(book);
    }

    public book getBook(String id) {
        for (book i : books) {
            if (i.getId() != null) {
                if (i.getId().equals(id)) {
                    return i;
                }
            }
        }
        return null;
    }

    public boolean removeBook(String id) {
        if (books != null) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId() != null) {
                    if (books.get(i).getId().equals(id)) {
                        books.remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean editBook(book book) {
        if (books != null) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId() != null) {
                    if (books.get(i).getId().equals(book.getId())) {
                        books.set(i, book);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // This class is called by addNewBook, to create a book id.
    public int getHighestId() {
        int max = 0;
        if (books != null) {
            for (book i : books) {
                if (i.getId() != null) {
                    int temp = Integer.valueOf(i.getId());
                    if (temp > max)
                        max = temp;
                }
            }
        }
        return max;
    }
}
