/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

import org.json.JSONObject;

public class RatingTest {
    Rating r1 = new Rating(4.1, 574);
    Rating r2 = new Rating(3.5, 75123);
    Rating r3 = new Rating(4.8, 5987);
    Rating r4 = new Rating(2.9, 6735456);
    Rating r5 = new Rating(5.0, 57354789);
    Rating r6 = new Rating(0.5, 63);

    @Test
    public void testToJSONStringFragment() {
        assertTrue(r1.addToJSONObject(new JSONObject()).similar(new JSONObject().put("rating-average", 4.1).put("rating-count", "574")));
        assertTrue(r2.addToJSONObject(new JSONObject()).similar(new JSONObject().put("rating-average", 3.5).put("rating-count", "75K")));
        assertTrue(r3.addToJSONObject(new JSONObject()).similar(new JSONObject().put("rating-average", 4.8).put("rating-count", "6K")));
        assertTrue(r4.addToJSONObject(new JSONObject()).similar(new JSONObject().put("rating-average", 2.9).put("rating-count", "7M")));
        assertTrue(r5.addToJSONObject(new JSONObject()).similar(new JSONObject().put("rating-average", 5.0).put("rating-count", "57M")));
        assertTrue(r6.addToJSONObject(new JSONObject()).similar(new JSONObject().put("rating-average", 0.5).put("rating-count", "63")));
    }
}
