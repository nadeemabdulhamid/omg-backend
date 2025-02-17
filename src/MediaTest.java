/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class MediaTest {
    Book b1 = new Book(1, "Elements of Style", "A classic guide to writing in English.", new Author("William Strunk Jr.", 1869), new DiscountPrice(1200, 1500, "20% off"), "nonfiction", new Rating(4.1, 574));
    Book b2 = new Book(2, "Old Man and the Sea", "A short novel written by an American author.", new Author("Ernest Hemingway", 1899), new DiscountPrice(500, 500, ""), "fiction", new Rating(3.4, 14849));
    Book b3 = new Book(4, "The Little Prince", "A novella by Antoine de Saint-Exupery.", new Author("Antoine de Saint-Exupery", 1900), new DiscountPrice(350, 500, "Holiday sale"), "fiction", new Rating(5.0, 3594104));
    Book b4 = new Book(5, "Introduction to the Theory of Computation", "A comprehensive textbook on the theory of computation.", 
                                new Author("Michael Sipser", 1954), new DiscountPrice(8000, 10000, "20% off"), "textbook", new Rating(3.2, 9542));

    Audio a1 = new Audio(3, "The Dark Side of the Moon", "A classic rock album by Pink Floyd.", "Pink Floyd", 2954, new DiscountPrice(750, 750, ""), "rock", new Rating(4.8, 12345));
    Audio a2 = new Audio(6, "Kind of Blue", "A classic jazz album by Miles Davis.", "Miles Davis", 3200, new DiscountPrice(400, 600, "Jazz sale"), "jazz", new Rating(3.9, 9876));

    Movie m1 = new Movie(7, "The Godfather", "A classic crime film directed by Francis Ford Coppola.", "Marlon Brando", "Francis Ford Coppola", new DiscountPrice(300, 500, "Mafia sale"), "crime", new Rating(4.7, 54321));
    Movie m2 = new Movie(8, "The Shawshank Redemption", "A classic drama film directed by Frank Darabont.", "Tim Robbins", "Frank Darabont", new DiscountPrice(200, 300, "Prison sale"), "drama", new Rating(4.9, 98765));

    @Test
    public void textGetID() {
        assertEquals(2, b2.getId());
        assertEquals(5, b4.getId());
        assertEquals(3, a1.getId());
        assertEquals(6, a2.getId());
        assertEquals(7, m1.getId());
        assertEquals(8, m2.getId());
    }

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
        assertFalse(b4.moreExpensiveThan(9000));
    }

    @Test
    public void testAdjustPrice() {
        assertEquals(new Book(1, "Elements of Style", "A classic guide to writing in English.", new Author("William Strunk Jr.", 1869), new DiscountPrice(900, 1125, "20% off"), "nonfiction", new Rating(4.1, 574)),
                     b1.adjustPrice(75));
        assertEquals(new Book(2, "Old Man and the Sea", "A short novel written by an American author.", new Author("Ernest Hemingway", 1899), new DiscountPrice(575, 575, ""), "fiction", new Rating(3.4, 14849)),
                      b2.adjustPrice(115));
    }

    @Test
    public void testToJSONString() {
        assertEquals("""
                { "type": "print", "id": 1, "title": "Elements of Style", "description-full": "A classic guide to writing in English.", "description-short": "A classic guide...", "author": "William Strunk Jr. (b. 1869)", "price": { "sale": "$12.00", "list": "$15.00", "discount": "20% off" }, "tags": "nonfiction", "rating-average": 4.1, "rating-count": "574" }""", 
                 b1.toJSONString());
        assertEquals("""
                { "type": "audio", "id": 3, "title": "The Dark Side of the Moon", "description-full": "A classic rock album by Pink Floyd.", "description-short": "A classic rock ...", "artist": "Pink Floyd", "info-line": "49 minutes 14 seconds", "price": "$7.50", "tags": "rock", "rating-average": 4.8, "rating-count": "12K" }""",
                 a1.toJSONString());
        assertEquals("""
                { "type": "video", "id": 7, "title": "The Godfather", "description-full": "A classic crime film directed by Francis Ford Coppola.", "description-short": "A classic crime...", "starring": "Marlon Brando", "directed-by": "Francis Ford Coppola", "price": { "sale": "$3.00", "list": "$5.00", "discount": "Mafia sale" }, "tags": "crime", "rating-average": 4.7, "rating-count": "54K" }""",
                 m1.toJSONString());
    }

    @Test
    public void testSalePrice() {
        assertEquals(1200, b1.salePrice());
        assertEquals(500, b2.salePrice());
        assertEquals(350, b3.salePrice());
        assertEquals(8000, b4.salePrice());

        assertEquals(750, a1.salePrice());
        assertEquals(400, a2.salePrice());

        assertEquals(300, m1.salePrice());
        assertEquals(200, m2.salePrice());
    }

    @Test
    public void testContains() {
        assertTrue(b1.contains("GUIde"));
        assertTrue(b1.contains("1869"));
        assertTrue(b3.contains("novella"));
        assertFalse(b1.contains("Hemingway"));

        assertTrue(a1.contains("side"));
        assertTrue(a1.contains("FLOYD"));
        assertFalse(a1.contains("jazz"));

        assertTrue(m1.contains("crime"));
        assertTrue(m1.contains("Coppola"));
        assertTrue(m1.contains("brand"));
        assertFalse(m1.contains("Shawshank"));
    }
}
