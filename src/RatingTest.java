/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class RatingTest {
    Rating r1 = new Rating(4.1, 574);
    Rating r2 = new Rating(3.5, 75123);
    Rating r3 = new Rating(4.8, 5987);
    Rating r4 = new Rating(2.9, 6735456);
    Rating r5 = new Rating(5.0, 57354789);
    Rating r6 = new Rating(0.5, 63);

    @Test
    public void testToJSONStringFragment() {
        assertEquals("""
                "rating-average": 4.1, "rating-count": "574" """, r1.toJSONStringFragment());
        assertEquals("""
                "rating-average": 3.5, "rating-count": "75K" """, r2.toJSONStringFragment());
        assertEquals("""
                "rating-average": 4.8, "rating-count": "6K" """, r3.toJSONStringFragment());
        assertEquals("""
                "rating-average": 2.9, "rating-count": "7M" """, r4.toJSONStringFragment());
        assertEquals("""
                "rating-average": 5.0, "rating-count": "57M" """, r5.toJSONStringFragment());
        assertEquals("""
                "rating-average": 0.5, "rating-count": "63" """, r6.toJSONStringFragment());
    }
}
