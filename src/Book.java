/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.Objects;

/** 
 * Represents a book in our online media store.
 */
public class Book {
    int id;
    String title;
    String description;
    Author author;
    Price price;
    String kind;
    Rating rating;

    public Book(int id, String title, String description, Author author, Price price, String kind, Rating rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
        this.kind = kind;
        this.rating = rating;
    }

    // overloaded constructor
    public Book(int id, String title, String description, String authorName, int authorYOB, int salePrice, int listPrice, String discount, String kind,
            double ratingAverage, int ratingCount) {
        this(id, title, description, new Author(authorName, authorYOB), new Price(salePrice, listPrice, discount), kind, new Rating(ratingAverage, ratingCount));
    }

    /**
     * Return the ID of this book.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Return the description of this book.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Return a truncated version of the description of this book.
     */
    public String getShortDescription() {
        return this.description.substring(0, Math.min(15, this.description.length())) + "...";
    }

    /**
     * Return true if this book was written by the given author.
     */
    public boolean writtenBy(String author) {
        return this.author.nameMatches(author);
    }

    /**
     * Return true if this book's sale price is more expensive than the given price.
     */
    public boolean moreExpensiveThan(int price) {
        return this.price.getSalePrice() > price;
    }

    /**
     * Produce an updated version of this book with the 
     * price multiplied by the given percentage.
     */
    public Book adjustPrice(int percent) {
        return new Book(this.id, this.title, this.description, this.author, this.price.adjustPrice(percent), this.kind, this.rating);
    }

    /**
     * Return a JSON string representation of this book.
     */
    public String toJSONString() {
        return "{ \"type\": \"print\", \"id\": " + this.id + ", \"title\": \"" + this.title
                 + "\", \"description-full\": \"" + this.description + "\", \"description-short\": \"" + this.getShortDescription()
                 + "\", \"author\": " + this.author.toJSONString() + ", \"price\": " 
                 + this.price.toJSONString() + ", \"tags\": \"" + this.kind
                 + "\", " + this.rating.toJSONStringFragment()
                 + " }";
    }

    // AUTO-GENERATED: DO NOT EDIT BELOW

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, author, price, kind);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Book))
            return false;
        Book other = (Book) obj;
        return id == other.id && Objects.equals(title, other.title) && Objects.equals(description, other.description)
                && Objects.equals(author, other.author) && Objects.equals(price, other.price)
                && Objects.equals(kind, other.kind);
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
                + ", price=" + price + ", kind=" + kind + "]";
    }

}

