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
    String author;
    int price;          // in cents
    String kind;        // "fiction", "nonfiction", "textbook"

    public Book(int id, String title, String author, int price, String kind) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.kind = kind;
    }

    /**
     * Return true if this book was written by the given author.
     */
    boolean writtenBy(String author) {
        return this.author.equals(author);
    }

    /**
     * Return true if this book is more expensive than the given price.
     */
    boolean moreExpensiveThan(int price) {
        return this.price > price;
    }

    /**
     * Produce the (possibly discounted) sale price for this book. 
     * The sale price of the book depends on the following discounts:
     * - 30% discount on fiction books
     * - 20% discount on nonfiction books
     * - textbooks sell at full price
	 */
	int salePrice(){    
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
    Book adjustPrice(int percent) {
        return new Book(this.id, this.title, this.author, this.price * percent / 100, this.kind);
    }

    /**
     * Return a JSON string representation of this book.
     */
    String toJSONString() {
        return "{ \"type\": \"print\", \"id\": " + this.id + ", \"title\": \"" + this.title
                 + "\", \"author\": \"" + this.author + "\", \"price\": \"$" 
                 + (this.price/100) + "." + (this.price%100) + "\", \"tag\": \"" + this.kind + "\" }";
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

