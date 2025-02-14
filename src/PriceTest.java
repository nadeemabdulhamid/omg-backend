/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class PriceTest {

    Price p1 = new Price(1000, 1500, "25% off");
    Price p2 = new Price(1500, 1500, "");
    Price p3 = new Price(1500, 2000, "33% off");

    @Test
    public void testFormatAsDollars() {
        assertEquals("\"$10.00\"", p1.formatAsDollars(1000));
        assertEquals("\"$0.50\"", p1.formatAsDollars(50));
        assertEquals("\"$0.00\"", p1.formatAsDollars(0));
        assertEquals("\"$123.59\"", p1.formatAsDollars(12359));
        assertEquals("\"$40.05\"", p1.formatAsDollars(4005));

    }

    @Test
    public void testIsOnSale() {
        assertTrue(p1.isOnSale());
        assertFalse(p2.isOnSale());
        assertTrue(p3.isOnSale());
    }

    @Test
    public void testGetSalePrice() {
        assertEquals(1000, p1.getSalePrice());
        assertEquals(1500, p2.getSalePrice());
        assertEquals(1500, p3.getSalePrice());
    }

    @Test
    public void testAdjustPrice() {
        assertEquals(new Price(500, 750, "25% off"), p1.adjustPrice(50));
        assertEquals(new Price(750, 750, ""), p2.adjustPrice(50));
        assertEquals(new Price(495, 660, "33% off"), p3.adjustPrice(33));
    }

    @Test
    public void testToJSONString() {
        assertEquals("""
                { "sale" : "$10.00", "list" : "$15.00", "discount" : "25% off" }""", p1.toJSONString());
        assertEquals("\"$15.00\"", p2.toJSONString());
    }
}
