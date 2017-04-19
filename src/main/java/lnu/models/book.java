package lnu.models;


import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

@XmlRootElement(name = "book")
public class book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String price;
    private String publish_date;
    private String description;

    public book() {

    }

    public book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public book(String title, String author, String genre, String price, String publishDate, String description) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.publish_date = publishDate;
        this.description = description;
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        String out = "";

        try {
            out = mapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.title).append(this.author);
        return String.valueOf(output);
    }
    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}