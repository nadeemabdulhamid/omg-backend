package test;
/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;

import list.MTLo;
import media.Author;
import media.Book;
import media.Rating;
import media.SimplePrice;

import static org.junit.Assert.*;

public class AuthorTest {
    Author a1 = new Author("Tolkien", 1892);
    Author a2 = new Author("Ghazzali", 1058);
    Author a3 = new Author("Cooper", 1895);

    @Test 
    public void testBook() {
        assertEquals(null, a1.getBook());
        Book b1 = new Book(0, "Hobbit", "A fantasy novel and children's book by J.R.R. Tolkien.", 1937, a1, new SimplePrice(1000), new MTLo<>(), new Rating(5.0, 1000000));
        assertEquals(b1, a1.getBook());
    }

    @Test
    public void testBornBefore() {
        assertTrue(a2.bornBefore(a1));
        assertFalse(a1.bornBefore(a2));
        assertTrue(a1.bornBefore(a3));
        assertFalse(a3.bornBefore(a3));
    }

    @Test
    public void testNameMatches() {
        assertTrue(a1.nameMatches("Tolkien"));
        assertFalse(a1.nameMatches("Ghazzali"));
        assertTrue(a2.nameMatches("Ghazzali"));
    }

    @Test
    public void testToJSONString() {
        assertEquals("Tolkien (b. 1892)", a1.toJSONString());
        assertEquals("Ghazzali (b. 1058)", a2.toJSONString());
        assertEquals("Cooper (b. 1895)", a3.toJSONString());
    }
}
