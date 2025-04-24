/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class ILoSTest {

    ILoS s0 = new MTLoS();
    ILoS s1 = new ConsLoS("hello", new ConsLoS("world", s0));
    ILoS s2 = new ConsLoS("this", new ConsLoS("is", new ConsLoS("a", new ConsLoS("test", s0))));

    @Test
    public void testAsJSONList() {
        assertEquals("[]", s0.asJSONList());
        assertEquals("[\"hello\",\"world\"]", s1.asJSONList());
        assertEquals("[\"this\",\"is\",\"a\",\"test\"]", s2.asJSONList());
    }

    @Test
    public void testJoin() {
        assertEquals("", s0.join(",", true));
        assertEquals("\"hello\",\"world\"", s1.join(",", true));
        assertEquals("this is a test", s2.join(" ", false));
        assertEquals("this|is|a|test", s2.join("|", false));
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
