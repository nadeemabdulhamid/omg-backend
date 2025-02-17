/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class StoreTest extends MediaTest {

    Store s1 = new Store(b1, a2, m1);
    Store s2 = new Store(m2, b3, a1);

    @Test
    public void testCatalog() {    
        assertEquals("[1, 6, 7]", s1.catalog());
        assertEquals("[8, 4, 3]", s2.catalog());
    }

    @Test
    public void testItemInfoAsJSON() {
        assertEquals(b1.toJSONString(), s1.itemInfoAsJSON(1));
        assertEquals(a2.toJSONString(), s1.itemInfoAsJSON(6));
        assertEquals(m2.toJSONString(), s2.itemInfoAsJSON(8));
    }

}
