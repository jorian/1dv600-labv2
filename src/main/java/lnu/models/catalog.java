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

    public int getHighestId() {
        int max = 0;
        for (book i : books) {
            int temp = Integer.valueOf(i.getId());
            if (temp > max)
                max = temp;
        }
        return max;
    }
}
