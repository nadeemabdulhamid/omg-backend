/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class ILoTest {

    MediaTest media = new MediaTest();

    ILo<String> mtS = new MTLo<String>();
    ILo<IMedia> mtM = new MTLo<IMedia>();
    ILo<Integer> mtN = new MTLo<Integer>();

    ILo<String> los = new ConsLo<String>("this", new ConsLo<String>("is", new ConsLo<String>("a", new ConsLo<String>("test", mtS))));
    ILo<IMedia> lom = new ConsLo<IMedia>(media.m1, new ConsLo<IMedia>(media.b2, new ConsLo<IMedia>(media.a1, new MTLo<IMedia>())));
    ILo<Integer> lon = new ConsLo<Integer>(15, new ConsLo<Integer>(24, new ConsLo<Integer>(33, new ConsLo<Integer>(42, new ConsLo<Integer>(51, new ConsLo<Integer>(33, new MTLo<Integer>()))))));

    @Test
    public void testSize() {
        assertEquals(0, mtS.size());
        assertEquals(4, los.size());
        assertEquals(3, lom.size());
        assertEquals(6, lon.size());
    }

    @Test
    public void testAsJSONList() {
        assertEquals("[]", mtS.asJSONList().toString());
        assertEquals("[\"this\",\"is\",\"a\",\"test\"]", los.asJSONList().toString());
        assertEquals("[15,24,33,42,51,33]", lon.asJSONList().toString());
    }

    @Test
    public void testContains() {
        assertFalse(mtS.contains("test"));
        assertTrue(los.contains("test"));
        assertTrue(lon.contains(24));
        assertFalse(lon.contains(25));
    }

    @Test
    public void testRemoveAll() {
        assertEquals(mtS, mtS.removeAll("test"));
        assertEquals("[\"this\",\"is\",\"a\"]", los.removeAll("test").asJSONList().toString());
        assertEquals("[15,33,42,51,33]", lon.removeAll(24).asJSONList().toString());
        assertEquals("[15,24,42,51]", lon.removeAll(33).asJSONList().toString());
        assertEquals(lon, lon.removeAll(25));
    }
}
