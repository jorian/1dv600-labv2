package lnu.models;


public class book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String price;
    private String publishDate;
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
        this.publishDate = publishDate;
        this.description = description;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.title).append(this.author);
        return String.valueOf(output);
    }

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