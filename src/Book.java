/**
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.Objects;

/** 
 * Represents a book in our online media store.
 */
public class Book implements IMedia {
    int id;
    String title;
    String description;
    Author author;
    IPrice price;
    ILoS tags;
    Rating rating;

    public Book(int id, String title, String description, Author author, IPrice price, ILoS tags, Rating rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
        this.tags = tags;
        this.rating = rating;
    }

    // overloaded constructor
    public Book(int id, String title, String description, String authorName, int authorYOB, int salePrice, int listPrice, String discount, String tags,
            double ratingAverage, int ratingCount) {
        this(id, title, description, new Author(authorName, authorYOB), buildPrice(salePrice, listPrice, discount), 
                    StringHelpers.split(tags, ','), new Rating(ratingAverage, ratingCount));
    }

    /*
     * Builds a DiscountPrice object if the sale price is different from the list
     */
    private static IPrice buildPrice(int salePrice, int listPrice, String discount) {
        if (salePrice == listPrice) {
            return new SimplePrice(salePrice);
        } else {
            return new DiscountPrice(salePrice, listPrice, discount);
        }
    }

    /**
     * Return the ID of this book.
     */
    @Override
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
     * Produce the tags for this audio item
     */
    public ILoS getTags() { 
        return this.tags;
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
        return new Book(this.id, this.title, this.description, this.author, this.price.adjustPrice(percent), this.tags, this.rating);
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
        return "{ "
                + StringHelpers.keyValuePair("type", "print") + ", "
                + StringHelpers.keyValuePair("id", getId()) + ", "
                + StringHelpers.keyValuePair("title", this.title) + ", "
                + StringHelpers.keyValuePair("description-full", this.description) + ", "
                + StringHelpers.keyValuePair("description-short", this.getShortDescription()) + ", "
                + StringHelpers.keyValuePair("author", this.author.toJSONString(), false) + ", "
                + StringHelpers.keyValuePair("price", this.price.toJSONString(), false) + ", "
                + StringHelpers.keyValuePair("tags", this.tags.asJSONList(), false) + ", "
                + this.rating.toJSONStringFragment()
                + " }";
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

