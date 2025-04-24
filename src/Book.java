/*
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
    IPrice price;
    String kind;
    Rating rating;

    public Book(int id, String title, String description, Author author, IPrice price, String kind, Rating rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.kind = kind;
        this.rating = rating;
    }

    // overloaded constructor
    public Book(int id, String title, String description, String authorName, int authorYOB, int salePrice, int listPrice, String discount, String kind,
            double ratingAverage, int ratingCount) {
        this(id, title, description, new Author(authorName, authorYOB), buildPrice(salePrice, listPrice, discount), kind, new Rating(ratingAverage, ratingCount));
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
     * Return a truncated version of the description of this book.
     */
    public String getShortDescription() {
        return this.description.substring(0, Math.min(15, this.description.length())) + "...";
    }

    /**
     * Return true if this book was written by the given author.
     */
    public boolean writtenBy(String author) {
        return this.author.equals(author);
    }

    /**
     * Return true if this book is more expensive than the given price.
     */
    public boolean moreExpensiveThan(int price) {
        return this.price > price;
    }

    /**
     * Produce the (possibly discounted) sale price for this book. 
     * The sale price of the book depends on the following discounts:
     * - 30% discount on fiction books
     * - 20% discount on nonfiction books
     * - textbooks sell at full price
	 */
	public int salePrice(){    
		if (this.kind.equals("fiction")) {
			return this.price - 3 * (this.price / 10);
		} else  if (this.kind.equals("nonfiction")) {
			return this.price - 2 * (this.price / 10);
		} else {
			return this.price;
		}
	}

    /**
     * Produce an updated version of this book with the 
     * price multiplied by the given percentage.
     */
    public Book adjustPrice(int percent) {
        return new Book(this.id, this.title, this.author, this.price * percent / 100, this.kind);
    }

    /**
     * Return a JSON string representation of this book.
     */
    public String toJSONString() {
        return "{ \"type\": \"print\", \"id\": " + this.id + ", \"title\": \"" + this.title
                 + "\", \"author\": \"" + this.author + "\", \"price\": \"$" 
                 + (this.price/100) + "." + (this.price%100) + "\", \"tags\": \"" + this.kind + "\" }";
    }


// In VS Code, right-click at the bottom of the class definition, select "Source Action", 
// then "Generate toString()"...

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", kind=" + kind
                + "]";
    }

// In VS Code settings, set both `Java › Code Generation › Hash Code Equals: Use Instanceof`
// and `Java › Code Generation › Hash Code Equals: Use Java 7 Objects` to true.
// This will generate the following `hashCode` and `equals` methods.

// In VS Code, right-click at the bottom of the class definition, select "Source Action", 
// then "Generate hashCode() and equals()"...

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
                && price == other.price && Objects.equals(kind, other.kind);
    }

}

