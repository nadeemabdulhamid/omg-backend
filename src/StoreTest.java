/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class StoreTest extends MediaTest {

    Store s1 = new Store(new ConsLoM(b1, new ConsLoM(a2, new ConsLoM(m1, new MTLoM()))));
    Store s2 = new Store(new ConsLoM(m2, new ConsLoM(b3, new ConsLoM(a1, new MTLoM()))));

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

    @Test
    public void testTagsList() {
        assertEquals("""
            ["drama","classic","film","fiction","novella","france","rock","classic","album"]""", s2.tagsList(-1));
        assertEquals("""
            ["drama","classic","film","fiction","novella"]""", s2.tagsList(5));
    }

}
