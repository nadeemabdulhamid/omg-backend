/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;
import org.json.JSONArray;

public class ILoSTest {

    ILoS s0 = new MTLoS();
    ILoS s1 = new ConsLoS("hello", new ConsLoS("world", s0));
    ILoS s2 = new ConsLoS("this", new ConsLoS("is", new ConsLoS("a", new ConsLoS("test", s0))));

    @Test
    public void testAsJSONList() {
        assertTrue(s0.asJSONList().similar(new JSONArray()));
        assertTrue(s1.asJSONList().similar(new JSONArray().put("hello").put("world")));
        assertTrue(s2.asJSONList().similar(new JSONArray().put("this").put("is").put("a").put("test")));
    }

    @Test
    public void testAppend() {
        assertEquals(s1, s0.append(s1));
        assertEquals(s1, s1.append(s0));
        assertEquals(new ConsLoS("hello", new ConsLoS("world", s2)), s1.append(s2));
    }

    @Test
    public void testTake() {
        assertEquals(s0, s0.take(0));
        assertEquals(s0, s0.take(5));
        assertEquals(new ConsLoS("hello", s0), s1.take(1));
        assertEquals(new ConsLoS("hello", new ConsLoS("world", s0)), s1.take(2));
        assertEquals(new ConsLoS("this", s0), s2.take(1));
        assertEquals(new ConsLoS("this", new ConsLoS("is", s0)), s2.take(2));
        assertEquals(new ConsLoS("this", new ConsLoS("is", new ConsLoS("a", s0))), s2.take(3));
        assertEquals(s2, s2.take(4));
        assertEquals(s0, s2.take(0));
    }
}
