/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

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
    public void testInfoAsJSON() {
        assertEquals("", mt.infoAsJSON(1));
        assertEquals("", lom2.infoAsJSON(2));
        assertEquals(media.m1.toJSONString(), lom2.infoAsJSON(7));
        assertEquals(media.b2.toJSONString(), lom3.infoAsJSON(2));
    }

    @Test
    public void testCollectTags() {
        assertEquals("", mt.collectTags().join(",", false));
        assertEquals("nonfiction,classic,guide,writing,English", lom1.collectTags().join(",", false));
        assertEquals("rock,classic,album,crime,classic,film,nonfiction,classic,guide,writing,English", lom2.collectTags().join(",", false));
    }
}
