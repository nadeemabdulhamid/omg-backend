/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class BookTest {
    Book b1 = new Book(1, "Elements of Style", "A classic guide to writing in English.", new Author("William Strunk Jr.", 1869), new Price(1200, 1500, "20% off"), "nonfiction", new Rating(4.1, 574));
    Book b2 = new Book(2, "Old Man and the Sea", "A short novel written by an American author.", new Author("Ernest Hemingway", 1899), new Price(500, 500, ""), "fiction", new Rating(3.4, 14849));
    Book b3 = new Book(4, "The Little Prince", "A novella by Antoine de Saint-Exupery.", new Author("Antoine de Saint-Exupery", 1900), new Price(500, 350, "Holiday sale"), "fiction", new Rating(5.0, 3594104));
    Book b4 = new Book(5, "Introduction to the Theory of Computation", "A comprehensive textbook on the theory of computation.", 
                                new Author("Michael Sipser", 1954), new Price(10000, 8000, "20% off"), "textbook", new Rating(3.2, 9542));

    @Test
    public void testWrittenBy() {
        assertTrue(b1.writtenBy("William Strunk Jr."));
        assertFalse(b1.writtenBy("Ernest Hemingway"));
        assertTrue(b2.writtenBy("Ernest Hemingway"));
    }

    @Test
    public void testMoreExpensiveThan() {
        assertTrue(b1.moreExpensiveThan(1000));
        assertFalse(b1.moreExpensiveThan(1500));
        assertTrue(b4.moreExpensiveThan(5000));
    }

    @Test
    public void testAdjustPrice() {
        assertEquals(new Book(1, "Elements of Style", "A classic guide to writing in English.", new Author("William Strunk Jr.", 1869), new Price(900, 1125, "20% off"), "nonfiction", new Rating(4.1, 574)),
                     b1.adjustPrice(75));
        assertEquals(new Book(2, "Old Man and the Sea", "A short novel written by an American author.", new Author("Ernest Hemingway", 1899), new Price(575, 575, ""), "fiction", new Rating(3.4, 14849)),
                      b2.adjustPrice(115));
    }

    @Test
    public void testToJSONString() {
        assertEquals("""
                { "type": "print", "id": 1, "title": "Elements of Style", "description-full": "A classic guide to writing in English.", "description-short": "A classic guide...", "author": "William Strunk Jr. (b. 1869)", "price": { "sale" : "$12.00", "list" : "$15.00", "discount" : "20% off" }, "tags": "nonfiction", "rating-average": 4.1, "rating-count": "574" }""", 
                 b1.toJSONString());
    }
}
