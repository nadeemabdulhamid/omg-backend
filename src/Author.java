/*
 * Nadeem Abdul Hamid, 2025.
 */

import java.util.Objects;

/**
 * Represents the author of a book in our online media store.
 */
public class Author {
    private String name;
    private int yob;
    private Book book;
    
    public Author(String name, int yob) {
        this.name = name;
        this.yob = yob;
    }

    /** 
     * Produces the book of this author.
     */
    public Book getBook() {
        return this.book;
    }

    /**
     * Sets the book of this author (by mutating the `book` field of this class).
     */
    public void setBook(Book book) {
        if (book.writtenBy(this.name)) {
            this.book = book;
        }
    }

    /**
    * Produces true if any portion of this author's name is the same as the given name.
    */
    public boolean nameMatches(String namePortion) {
        return this.name.contains(namePortion);
    }
    
    /** 
     * Produces true if this author was born before that given author
     */
    public boolean bornBefore(Author that) {
        return this.yob < that.yob;
    }

    /**
     * Produces a JSON object representation of this author
     */
    public String toJSONString() {
    	return this.name + " (b. " + this.yob + ")";
    }

    /**
     * Produces true if this author's description contains the given text
     */
    public boolean contains(String text) {
        String lowerText = text.toLowerCase();
        String str = this.toJSONString().toLowerCase();
        return str.contains(lowerText);
    }


    // AUTO-GENERATED CODE BELOW. DO NOT MODIFY!
    
    @Override
    public int hashCode() {
        return Objects.hash(name, yob);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Author))
            return false;
        Author other = (Author) obj;
        return Objects.equals(name, other.name) && yob == other.yob;
    }

    @Override
    public String toString() {
        return "Author [name=" + name + ", yob=" + yob + "]";
    }

}