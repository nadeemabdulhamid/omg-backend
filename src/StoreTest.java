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
        assertEquals(b1.toJSONString(), s1.itemInfoAsJSON(1));
        assertEquals(b2.toJSONString(), s1.itemInfoAsJSON(2));
    }

}
