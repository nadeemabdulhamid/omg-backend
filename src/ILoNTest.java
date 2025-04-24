/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class ILoNTest {
    ILoN mt = new MTLoN();
    ILoN ns1 = new ConsLoN(10, mt);
    ILoN ns2 = new ConsLoN(20, ns1);
    ILoN ns3 = new ConsLoN(70, new ConsLoN(30, new ConsLoN(50, new ConsLoN(45, new ConsLoN(3, mt)))));

    @Test
    public void testAsJSONList() {
        assertEquals("[]", mt.asJSONList());
        assertEquals("[10]", ns1.asJSONList());
        assertEquals("[20,10]", ns2.asJSONList());
        assertEquals("[70,30,50,45,3]", ns3.asJSONList());
    }

    @Test
    public void testJoin() {
        assertEquals("", mt.join(","));
        assertEquals("10", ns1.join(","));
        assertEquals("20,10", ns2.join(","));
        assertEquals("70,30,50,45,3", ns3.join(","));
    }

    @Test
    public void testContains() {
        assertFalse(mt.contains(10));
        assertFalse(mt.contains(0));

        assertTrue(ns1.contains(10));
        assertFalse(ns1.contains(20));

        assertTrue(ns2.contains(10));
        assertTrue(ns2.contains(20));
        assertFalse(ns2.contains(30));

        assertTrue(ns3.contains(70));
        assertTrue(ns3.contains(45));
        assertTrue(ns3.contains(3));
        assertFalse(ns3.contains(100));
        assertFalse(ns3.contains(10));
        assertFalse(ns3.contains(0));

    }

    @Test
    public void testRemove() {
        assertEquals(mt, mt.remove(10));
        assertEquals(ns1, ns1.remove(20));

        assertEquals(new ConsLoN(20, mt), ns2.remove(10));
        assertEquals(ns1, ns2.remove(20));

        assertEquals("[70,30,50,45]", ns3.remove(3).asJSONList());
        assertEquals("[70,30,50,3]", ns3.remove(45).asJSONList());
        assertEquals("[70,30,45,3]", ns3.remove(50).asJSONList());
        assertEquals("[70,50,45,3]", ns3.remove(30).asJSONList());
        assertEquals("[30,50,45,3]", ns3.remove(70).asJSONList());
        assertEquals(ns3, ns3.remove(100));
        assertEquals(ns3, ns3.remove(0));
        assertEquals(ns3, ns3.remove(-50));
    }

    @Test
    public void testSize() {
        assertEquals(0, mt.size());
        assertEquals(1, ns1.size());
        assertEquals(2, ns2.size());
        assertEquals(5, ns3.size());
    }
}
