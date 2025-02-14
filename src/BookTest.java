/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class BookTest {
    Book b1 = new Book(1, "Elements of Style", "William Strunk Jr.", 1200, "nonfiction");
    Book b2 = new Book(2, "Old Man and the Sea", "Ernest Hemingway", 500, "fiction");
    Book b3 = new Book(4, "The Little Prince", "Antoine de Saint-Exupery", 350, "fiction");
    Book b4 = new Book(5, "Introduction to the Theory of Computation", "Michael Sipser", 8000, "textbook");

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
    public void testSalePrice() {
        assertEquals(960, b1.salePrice());
        assertEquals(350, b2.salePrice());
        assertEquals(245, b3.salePrice());
        assertEquals(8000, b4.salePrice());
    }

    @Test
    public void testAdjustPrice() {
        assertEquals(new Book(1, "Elements of Style", "William Strunk Jr.", 900, "nonfiction"), 
                     b1.adjustPrice(75));
        assertEquals(new Book(5, "Introduction to the Theory of Computation", "Michael Sipser", 9200, "textbook"), 
                     b4.adjustPrice(115));
    }

    @Test
    public void testToJSONString() {
        assertEquals("""
                        { "type": "print", "id": 1, "title": "Elements of Style", "author": "William Strunk Jr.", "price": "$12.0", "tags": "nonfiction" }""",
                        b1.toJSONString());
    }
}
