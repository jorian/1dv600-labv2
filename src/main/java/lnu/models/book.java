package lnu.models;


import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

@XmlRootElement(name = "book")
public class book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String price;
    private String publishDate;
    private String description;

    //public book(String title, String author) {
    //    this.title = title;
    //    this.author = author;
    //}

    public book(String id, String title, String author, String genre, String price, String publishDate, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.description = description;
    }

    public book() {

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
        output.append(this.id).append(", ")
                .append(this.title).append(", ")
                .append(this.author).append(", ")
                .append(this.genre).append(", ")
                .append(this.price).append(". ");
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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}