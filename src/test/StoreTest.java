package test;
/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;

import funcobjs.MinPricePredicate;
import funcobjs.MinYearPredicate;
import funcobjs.TextSearchPredicate;
import funcobjs.TypesPredicate;
import main.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class StoreTest extends MediaTest {
    Store s1 = new Store(List.of(b1, a2, m1));    // [1, 6, 7]
    Store s2 = new Store(List.of(m2, b3, a1));    // [8, 4, 3]
    Store s3 = new Store(List.of(m2, b3, a1), new ArrayList<>(List.of(4)), "");
    Store s4 = new Store(List.of(m2, b3, a1), new ArrayList<>(List.of(4, 8)), "");
    Store s5 = new Store(List.of(m2, b3, a1), new ArrayList<>(List.of(4, 8)), "50%OFF");
    Store s6 = new Store(List.of(m2, b3, a1), new ArrayList<>(List.of(4, 3, 8)), "AUDIO30");

    @Test
    public void testTotals() {
        assertEquals("\"$0.00\"", s1.cartSubtotal());
        assertEquals("\"$3.50\"", s3.cartSubtotal());
        assertEquals("\"$5.50\"", s4.cartSubtotal());
        assertEquals("\"$5.50\"", s5.cartSubtotal());
        assertEquals("\"$13.00\"", s6.cartSubtotal());

        assertEquals("\"$5.50\"", s4.cartTotal());
        assertEquals("\"$2.75\"", s5.cartTotal());
        assertEquals("\"$10.75\"", s6.cartTotal());
    }

    @Test
    public void testCatalogWithFilter() {    
        assertEquals("[1]", s1.catalog(new TypesPredicate("print")));
        assertEquals("[8,3]", s2.catalog(new TypesPredicate("video,audio")));

        assertEquals("[1,6,7]", s1.catalog(new TextSearchPredicate("clas")));
        assertEquals("[6,7]", s1.catalog(new TextSearchPredicate("by")));

    }

    @Test
    public void testItemInfoAsJSON() {
        assertEquals(b1.toJSONString(), s1.itemInfoAsJSON(1));
        assertEquals(a2.toJSONString(), s1.itemInfoAsJSON(6));
        assertEquals(m2.toJSONString(), s2.itemInfoAsJSON(8));
    }

    @Test
    public void testCountMatching() {
        assertEquals("3", s1.countMatching(new MinPricePredicate(0)));
        assertEquals("2", s2.countMatching(new MinYearPredicate(1950)));
        assertEquals("1", s2.countMatching(new TypesPredicate("audio")));
        assertEquals("2", s2.countMatching(new TypesPredicate("audio,video")));
    }

    @Test
    public void testTagCounts() {
        // drama,classic,film, fiction,novella,france,rock,classic,album
        assertEquals("""
            [["rock",1],["drama",1],["classic",2],["novella",1],["fiction",1],["album",1],["france",1],["film",1]]""", 
            s2.tagCounts(new MinPricePredicate(0),""));

        // nonfiction,classic,guide,writing,English,jazz,classic,album,crime,classic,film
        assertEquals("""
            [["English",1],["classic",3],["jazz",1],["album",1],["writing",1],["nonfiction",1],["crime",1],["film",1],["guide",1]]""",
            s1.tagCounts(new MinPricePredicate(0),""));

        assertEquals("""
            [["classic",3],["nonfiction",1],["crime",1]]""",
            s1.tagCounts(new MinPricePredicate(0),"c"));
    
        assertEquals("""
            [["classic",1],["jazz",1],["album",1]]""",
            s1.tagCounts(new TypesPredicate("audio"),""));

        assertEquals("""
            [["classic",1]]""",
            s1.tagCounts(new TypesPredicate("audio"),"c"));
    
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
        assertEquals("[4,8]", s4.cartList());
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
        assertEquals(new Range(1920, 1972).toJSONString(), s1.yearRangeAsJSON(new MinPricePredicate(0)));
        assertEquals(new Range(1943, 1994).toJSONString(), s2.yearRangeAsJSON(new MinPricePredicate(0)));
    }

    @Test
    public void testPriceRange() {
        assertEquals(new Range(300, 1200).toJSONString(), s1.priceRangeAsJSON(new MinPricePredicate(0)));
        assertEquals(new Range(200, 750).toJSONString(), s2.priceRangeAsJSON(new MinPricePredicate(0)));
    }

}
