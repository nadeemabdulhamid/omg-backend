/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class StoreTest extends MediaTest {

    Store s1 = new Store(new ConsLoM(b1, new ConsLoM(a2, new ConsLoM(m1, new MTLoM()))));   // [1, 6, 7]
    Store s2 = new Store(new ConsLoM(m2, new ConsLoM(b3, new ConsLoM(a1, new MTLoM()))));   // [8, 4, 3]
    Store s3 = new Store(new ConsLoM(m2, new ConsLoM(b3, new ConsLoM(a1, new MTLoM()))), new ConsLoN(4, new MTLoN()));
    Store s4 = new Store(new ConsLoM(m2, new ConsLoM(b3, new ConsLoM(a1, new MTLoM()))), new ConsLoN(8, new ConsLoN(4, new MTLoN())));

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

    @Test
    public void testCartSize() {
        assertEquals("0", s1.cartSize());
        assertEquals("1", s3.cartSize());
        assertEquals("2", s4.cartSize());
    }

    @Test 
    public void testCartList() {
        assertEquals("[]", s1.cartList());
        assertEquals("[4]", s3.cartList());
        assertEquals("[8,4]", s4.cartList());
    }

    @Test
    public void testCartAddRemove() {
        assertEquals("[]", s2.cartList());
        assertEquals("true", s2.addToCart(4));
        assertEquals(s3, s2);
        assertEquals("false", s2.addToCart(4));
        assertEquals(s3, s2);

        assertEquals("true", s2.addToCart(8));
        assertEquals(s4, s2);
        assertEquals("false", s2.addToCart(4));
        assertEquals("false", s2.addToCart(8));

        assertEquals("false", s2.removeFromCart(3));
        assertEquals(s4, s2);
        assertEquals("true", s2.removeFromCart(8));
        assertEquals("false", s2.removeFromCart(8));
        assertEquals(s3, s2);
    }

}
