/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class BookTest {
    Book b1 = new Book(1, "Elements of Style", new Author("William Strunk Jr.", 1869), new Price(1200, 1500, "20% off"), "nonfiction");
    Book b2 = new Book(2, "Old Man and the Sea", new Author("Ernest Hemingway", 1899), new Price(500, 500, ""), "fiction");
    Book b3 = new Book(4, "The Little Prince", new Author("Antoine de Saint-Exupery", 1900), new Price(500, 350, "Holiday sale"), "fiction");
    Book b4 = new Book(5, "Introduction to the Theory of Computation", new Author("Michael Sipser", 1954), new Price(10000, 8000, "20% off"), "textbook");

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
        assertEquals(new Book(1, "Elements of Style", new Author("William Strunk Jr.", 1869), new Price(900, 1125, "20% off"), "nonfiction"), 
                     b1.adjustPrice(75));
        assertEquals(new Book(2, "Old Man and the Sea", new Author("Ernest Hemingway", 1899), new Price(575, 575, ""), "fiction"),
                      b2.adjustPrice(115));
    }

    @Test
    public void testToJSONString() {
        assertEquals("""
                { "type": "print", "id": 1, "title": "Elements of Style", "author": "William Strunk Jr. (b. 1869)", "price": { "sale" : "$12.00", "list" : "$15.00", "discount" : "20% off" }, "tags": "nonfiction" }""", 
                 b1.toJSONString());
    }
}
