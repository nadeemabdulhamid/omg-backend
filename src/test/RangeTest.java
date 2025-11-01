package test;
/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;

import main.Range;

import static org.junit.Assert.*;

public class RangeTest {

    Range rE = new Range();
    Range r5 = new Range(5);
    Range r3_7 = new Range(3, 7);

    @Test
    public void testToJSONString() {
        assertEquals("false", rE.toJSONString());
        assertEquals("{ \"min\": 5, \"max\": 5 }", r5.toJSONString());
        assertEquals("{ \"min\": 3, \"max\": 7 }", r3_7.toJSONString());
    }

    @Test 
    public void testAddValue() {
        rE.addValue(5);
        assertEquals(r5, rE);
        rE.addValue(3);
        rE.addValue(6);
        rE.addValue(7);
        assertEquals(r3_7, rE);
        rE.addValue(5);
        assertEquals(r3_7, rE);
    }
}
