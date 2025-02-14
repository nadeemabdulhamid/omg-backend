/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class StoreTest extends BookTest {

    Store s1 = new Store(b1, b2, b3);
    Store s2 = new Store(b4, b3, b1);

    @Test
    public void testCatalog() {    
        assertEquals("[1, 2, 4]", s1.catalog());
        assertEquals("[5, 4, 1]", s2.catalog());
    }

    @Test
    public void testItemInfoAsJSON() {
        assertEquals("""
                { "type": "print", "id": 1, "title": "Elements of Style", "author": "William Strunk Jr. (b. 1869)", "price": { "sale" : "$12.00", "list" : "$15.00", "discount" : "20% off" }, "tags": "nonfiction" }""", 
                s1.itemInfoAsJSON(1));
        assertEquals("""
                { "type": "print", "id": 2, "title": "Old Man and the Sea", "author": "Ernest Hemingway (b. 1899)", "price": "$5.00", "tags": "fiction" }""",
                s1.itemInfoAsJSON(2));
    }

}
