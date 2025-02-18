/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class PriceTest {

    IPrice p1 = new DiscountPrice(1000, 1500, "25% off");
    IPrice p2 = new SimplePrice(1500);
    IPrice p3 = new DiscountPrice(1500, 2000, "33% off");


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
        assertEquals(new DiscountPrice(500, 750, "25% off"), p1.adjustPrice(50));
        assertEquals(new SimplePrice(750), p2.adjustPrice(50));
        assertEquals(new DiscountPrice(495, 660, "33% off"), p3.adjustPrice(33));
    }

    @Test
    public void testToJSONString() {
        assertEquals("""
                {"sale":"$10.00","discount":"25% off","list":"$15.00"}""", p1.toJSON().toString());
        assertEquals("$15.00", p2.toJSON().toString());
    }
}
