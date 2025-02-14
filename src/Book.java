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
    Author author;
    Price price;
    String kind;

    public Book(int id, String title, Author author, Price price, String kind) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.kind = kind;
    }

    // overloaded constructor
    public Book(int id, String title, String authorName, int authorYOB, int salePrice, int listPrice, String discount, String kind) {
        this.id = id;
        this.title = title;
        this.author = new Author(authorName, authorYOB);
        this.price = new Price(salePrice, listPrice, discount);
        this.kind = kind;
    }

    /**
     * Return the ID of this book.
     */
    public int getId() {
        return this.id;
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
        return new Book(this.id, this.title, this.author, this.price.adjustPrice(percent), this.kind);
    }

    /**
     * Return a JSON string representation of this book.
     */
    public String toJSONString() {
        return "{ \"type\": \"print\", \"id\": " + this.id + ", \"title\": \"" + this.title
                 + "\", \"author\": " + this.author.toJSONString() + ", \"price\": " 
                 + this.price.toJSONString() + ", \"tags\": \"" + this.kind + "\" }";
    }

    // AUTO-GENERATED: DO NOT EDIT BELOW

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price, kind);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Book))
            return false;
        Book other = (Book) obj;
        return id == other.id && Objects.equals(title, other.title) && Objects.equals(author, other.author)
                && Objects.equals(price, other.price) && Objects.equals(kind, other.kind);
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", kind=" + kind
                + "]";
    }

}

