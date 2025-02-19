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
                new ConsLoM(media.a1, new ConsLoM(media.a2, new ConsLoM(media.m3, 
                new ConsLoM(media.m2, mt)))))));    // [ b1, b2, b3, a1, a2, m3, m2 ]

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
        //JSONArray a = lom2.collectTags().asJSONList();              // for debugging
        assertTrue(lom2.collectTags().asJSONList()
                    .similar(new JSONArray("[rock,classic,album,crime,classic,film,nonfiction,classic,guide,writing,English]")));
    }

    @Test
    public void testYearRange() {
        assertEquals(new Range(), mt.yearRange());
        assertEquals(new Range(1920), lom1.yearRange());
        assertEquals(new Range(1920, 1973), lom2.yearRange());
        assertEquals(new Range(1920, 1994), lom3.yearRange());
    }

    @Test
    public void testPriceRange() {
        assertEquals(new Range(), mt.priceRange());
        assertEquals(new Range(1200), lom1.priceRange());
        assertEquals(new Range(300, 1200), lom2.priceRange());
        assertEquals(new Range(200, 1200), lom3.priceRange());
    }

    @Test
    public void testOnlyPrint() {
        assertEquals("", mt.onlyPrint().collectIds());
        assertEquals("1", lom1.onlyPrint().collectIds());
        assertEquals("1", lom2.onlyPrint().collectIds());
        assertEquals("1, 2, 4", lom3.onlyPrint().collectIds());
    }

    @Test
    public void testAfter2000() {
        assertEquals("", mt.after2000().collectIds());
        assertEquals("", lom2.after2000().collectIds());
        assertEquals("9", lom3.after2000().collectIds());
    }

}
