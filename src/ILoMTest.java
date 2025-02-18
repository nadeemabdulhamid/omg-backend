/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

import org.json.JSONArray;

public class ILoMTest {

    MediaTest media = new MediaTest();
    ILoM mt = new MTLoM();
    ILoM lom1 = new ConsLoM(media.b1, mt);                              // [ b1 ]
    ILoM lom2 = new ConsLoM(media.a1, new ConsLoM(media.m1, lom1));     // [ a1, m1, b1 ]
    ILoM lom3 = new ConsLoM(media.b1, new ConsLoM(media.b2, new ConsLoM(media.b3, 
                new ConsLoM(media.a1, new ConsLoM(media.a2, new ConsLoM(media.m1, 
                new ConsLoM(media.m2, mt)))))));    // [ b1, b2, b3, a1, a2, m1, m2 ]

    @Test
    public void testCollectIds() {
        assertEquals("", mt.collectIds());
        assertEquals("3, 7, 1", lom2.collectIds());
        assertEquals("1, 2, 4, 3, 6, 7, 8", lom3.collectIds());
    }

    @Test
    public void testFindItem() {
        assertEquals(null, mt.findItem(1));
        assertEquals(null, lom2.findItem(2));
        assertEquals(media.m1, lom2.findItem(7));
        assertEquals(media.b2, lom3.findItem(2));
    }

    @Test
    public void testCollectTags() {
        assertTrue(mt.collectTags().asJSONList().similar(new JSONArray("[]")));
        assertTrue(new JSONArray("[nonfiction,classic,guide,writing,English]").similar(lom1.collectTags().asJSONList()));
        JSONArray a = lom2.collectTags().asJSONList();              // for debugging
        assertTrue(lom2.collectTags().asJSONList()
                    .similar(new JSONArray("[rock,classic,album,crime,classic,film,nonfiction,classic,guide,writing,English]")));
    }
}
