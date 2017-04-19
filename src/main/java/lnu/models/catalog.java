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

    @XmlElement(name = "book")
    private List<book> books = null;

    public List<book> getListOfBooks() {
        return books;
    }

    public void setBooks(List<book> books) {
        this.books = books;
    }

    public void addBook(book book) {
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
