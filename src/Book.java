/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.Objects;

/** 
 * Represents a book in our online media store.
 */
public class Book extends AbsItem {
    Author author;

    public Book(int id, String title, String description, int year, Author author, IPrice price, ILo<String> tags, Rating rating) {
        super(id, title, description, year, price, tags, rating);
        this.author = author;
        this.author.setBook(this);
    }

    // overloaded constructor
    public Book(int id, String title, String description, int year, String authorName, int authorYOB, int salePrice, int listPrice, String discount, String tags,
                    double ratingAverage, int ratingCount) {
        this(id, title, description, year, new Author(authorName, authorYOB), buildPrice(salePrice, listPrice, discount), 
                    StringHelpers.split(tags, ','), new Rating(ratingAverage, ratingCount));
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
        return new Book(this.id, this.title, this.description, this.year, this.author, this.price.adjustPrice(percent), this.tags, this.rating);
    }

    /**
     * Return the sale price of this book.
     */
    @Override
    public int salePrice() {
        return this.price.getSalePrice();
    }

    /** Produce true if this media item contains the given text in 
        any of its textual fields */
    @Override
    public boolean contains(String text) {
        String lowerText = text.toLowerCase();
        return this.title.toLowerCase().contains(lowerText) || this.description.toLowerCase().contains(lowerText) || this.author.contains(lowerText);
    }

    /**
     * Return a JSON string representation of this book.
     */
    @Override
    public String toJSONString() {
        return super.toJSONObject()
                .put("type", "print")
                .put("author", this.author.toJSONString())
                .toString();
    }

    /**
     * Produce true if the type of this media is one
     * of the given comma-separated list of types
     */
    public boolean typeMatches(String tys) {
        return tys.contains("print");
    }


    // AUTO-GENERATED: DO NOT EDIT BELOW

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, author, price, tags, rating);
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
                && Objects.equals(tags, other.tags) && Objects.equals(rating, other.rating);
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
                + ", price=" + price + ", tags=" + tags + ", rating=" + rating + "]";
    }

}

