package test;
/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;

import funcobjs.TextSearchPredicate;
import funcobjs.TypesPredicate;
import list.ConsLo;
import list.ConsLoM;
import list.MTLo;
import list.MTLoM;
import main.Range;
import main.Store;

import static org.junit.Assert.*;

public class StoreTest extends MediaTest {

    Store s1 = new Store(new ConsLoM(b1, new ConsLoM(a2, new ConsLoM(m1, new MTLoM()))));   // [1, 6, 7]
    Store s2 = new Store(new ConsLoM(m2, new ConsLoM(b3, new ConsLoM(a1, new MTLoM()))));   // [8, 4, 3]
    Store s3 = new Store(new ConsLoM(m2, new ConsLoM(b3, new ConsLoM(a1, new MTLoM()))), new ConsLo<>(4, new MTLo<>()), "");
    Store s4 = new Store(new ConsLoM(m2, new ConsLoM(b3, new ConsLoM(a1, new MTLoM()))), new ConsLo<>(8, new ConsLo<>(4, new MTLo<>())), "");
    Store s5 = new Store(new ConsLoM(m2, new ConsLoM(b3, new ConsLoM(a1, new MTLoM()))), new ConsLo<>(8, new ConsLo<>(4, new MTLo<>())), "50%OFF");

    @Test
    public void testCatalog() {    
        assertEquals("[1, 6, 7]", s1.catalog());
        assertEquals("[8, 4, 3]", s2.catalog());
    }

    @Test
    public void testCatalogWithFilter() {    
        assertEquals("[1]", s1.catalog(new TypesPredicate("print")));
        assertEquals("[8, 3]", s2.catalog(new TypesPredicate("video,audio")));

        assertEquals("[1, 6, 7]", s1.catalog(new TextSearchPredicate("clas")));
        assertEquals("[6, 7]", s1.catalog(new TextSearchPredicate("by")));

    }

    @Test
    public void testItemInfoAsJSON() {
        assertEquals(b1.toJSONString(), s1.itemInfoAsJSON(1));
        assertEquals(a2.toJSONString(), s1.itemInfoAsJSON(6));
        assertEquals(m2.toJSONString(), s2.itemInfoAsJSON(8));
    }

    @Test
    public void testTagCounts() {
        // drama,classic,film, fiction,novella,france,rock,classic,album
        assertEquals("""
            [["drama",1],["classic",2],["film",1],["fiction",1],["novella",1],["france",1],["rock",1],["album",1]]""", 
            s2.tagCounts());

        // nonfiction,classic,guide,writing,English,jazz,classic,album,crime,classic,film
        assertEquals("""
            [["nonfiction",1],["classic",3],["guide",1],["writing",1],["English",1],["jazz",1],["album",1],["crime",1],["film",1]]""",
            s1.tagCounts());
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
        assertNotEquals(s3, s2);
        assertNotEquals(s4, s2);

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

    @Test
    public void testCoupon() {
        assertNotEquals(s4, s5);
        assertEquals("\"50%OFF\"", s5.getCoupon());
        assertEquals("false", s5.applyCoupon("SALE"));
        assertEquals("false", s5.applyCoupon("50%OFF"));
        assertEquals("false", s5.removeCoupon("SALE"));
        assertEquals("true", s5.removeCoupon("50%OFF"));
        assertEquals(s4, s5);
        assertEquals("false", s5.removeCoupon("50%OFF"));

        assertEquals("true", s5.applyCoupon("50%off"));
        assertEquals("\"50%OFF\"", s5.getCoupon());         // uppercased
        assertNotEquals(s4, s5);
    }

    @Test
    public void testYearRange() {
        assertEquals(new Range(1920, 1972).toJSONString(), s1.yearRangeAsJSON());
        assertEquals(new Range(1943, 1994).toJSONString(), s2.yearRangeAsJSON());
    }

    @Test
    public void testPriceRange() {
        assertEquals(new Range(300, 1200).toJSONString(), s1.priceRangeAsJSON());
        assertEquals(new Range(200, 750).toJSONString(), s2.priceRangeAsJSON());
    }

}
