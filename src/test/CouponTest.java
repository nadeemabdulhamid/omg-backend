package test;
/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

import funcobjs.*;
import java.util.List;

public class CouponTest {
    MediaTest media = new MediaTest();
    ICoupon noDisc = new NoDiscountCoupon();
    ICoupon halfOff = new HalfOffCoupon();
    ICoupon audio30 = new Audio30OffCoupon();

    @Test
    public void testNoDiscountCoupon() {
        assertEquals(0, noDisc.calculateTotal(List.of()));
        assertEquals(2250, noDisc.calculateTotal(List.of(media.b1, media.a1, media.m1)));
        assertEquals(2750, noDisc.calculateTotal(List.of(media.b1, media.a1, media.m1, media.b2)));
    }

    @Test
    public void testHalfOffCoupon() {
        assertEquals(0, halfOff.calculateTotal(List.of()));
        assertEquals(1125, halfOff.calculateTotal(List.of(media.b1, media.a1, media.m1)));
        assertEquals(1375, halfOff.calculateTotal(List.of(media.b1, media.a1, media.m1, media.b2)));
    }

    @Test
    public void testAudio30OffCoupon() {
        assertEquals(0, audio30.calculateTotal(List.of()));
        assertEquals(2025, audio30.calculateTotal(List.of(media.b1, media.a1, media.m1)));
        assertEquals(2525, audio30.calculateTotal(List.of(media.b1, media.a1, media.m1, media.b2)));
    }
}
