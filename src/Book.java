/**
 * Nadeem Abdul Hamid, 2025.
 */

 import java.util.Objects;
 
 import org.json.JSONObject;

 /** 
  * Represents a book in our online media store.
  */
 public class Book extends AbsItem {
     Author author;
 
     public Book(int id, String title, String description, int year, Author author, IPrice price, ILoS tags, Rating rating) {
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
         return new Book(this.id, this.title, this.description, year, this.author, this.price.adjustPrice(percent), this.tags, this.rating);
     }
  
     /** Produce true if this media item contains the given text in 
         any of its textual fields */
     @Override
     public boolean contains(String text) {
         String lowerText = text.toLowerCase();
         return super.contains(text) || this.author.contains(lowerText);
     }

    @Override
    protected JSONObject toJSONObject() {
        return super.toJSONObject()
                    .put("type", "print")
                    .put("author", this.author.toJSONString() );
    }
 

 
     // AUTO-GENERATED: DO NOT EDIT BELOW
 
     @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(author);
        return result;
    }
 
     @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Book))
            return false;
        Book other = (Book) obj;
        return Objects.equals(author, other.author);
    }
 
     @Override
    public String toString() {
        return "Book [author=" + author + ", toString()=" + super.toString() + "]";
    }
 
 }
 
 