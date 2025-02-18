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
}
