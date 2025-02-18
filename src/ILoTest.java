/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;
import org.json.JSONArray;

public class ILoTest {

    MediaTest media = new MediaTest();

    ILo<String> mtS = new MTLo<String>();
    ILo<IMedia> mtM = new MTLo<IMedia>();

    ILo<String> los = new ConsLo<String>("this", new ConsLo<String>("is", new ConsLo<String>("a", new ConsLo<String>("test", mtS))));
    ILo<IMedia> lom = new ConsLo<IMedia>(media.m1, new ConsLo<IMedia>(media.m2, new ConsLo<IMedia>(media.b2, new ConsLo<IMedia>(media.a1, new MTLo<IMedia>()))));

    @Test
    public void testSize() {
        ILo<Integer> mt = new MTLo<Integer>();
        ILo<Integer> lo1 = new ConsLo<Integer>(1, mt);
        ILo<Integer> lo2 = new ConsLo<Integer>(2, lo1);
        ILo<Integer> lo3 = new ConsLo<Integer>(3, lo2);
        assertEquals(0, mt.size());
        assertEquals(1, lo1.size());
        assertEquals(2, lo2.size());
        assertEquals(3, lo3.size());
    }
}
