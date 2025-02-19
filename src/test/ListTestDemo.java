package test;
/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ListTestDemo {
    @Test
    public void demo() {
        List<String> list = List.of("a", "b", "c"); // immutable list
        assertEquals(3, list.size());
        assertTrue(list.contains("b"));
        assertFalse(list.contains("d"));
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));

        List<String> list2 = new ArrayList<>();     // a mutable list
        list2.add("a");
        list2.add("d");
        list2.add("b");
        list2.add("c");
        list2.remove("d");
        assertEquals(list2, list);

        // for-each loop to iterate over the list, using an accumulator with mutation
        String str = "";
        for (String s : list) {     // like  <list>.map( λ(<s>) 
            str = str + s;    // str += s                    ....
        }                           //                             )
        assertEquals("abc", str);
    }

    @Test
    public void demo2() {
        // List<int> listN = List.of(10, 20, 30); // invalid syntax
        List<Integer> list = List.of(10, 20, 30);
        //List<Integer> list = List.of(new Integer(10), new Integer(20), new Integer(30));

        assertEquals(3, list.size());
        assertTrue(list.contains(20));
        assertFalse(list.contains(40));
    }

}
