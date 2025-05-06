package test;
/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;
import org.json.*;

public class JSONTestDemo {
    
    // JSONObject
    @Test
    public void demo1() {
        JSONObject obj = new JSONObject();   //  {}
        assertEquals("{}", obj.toString());

        JSONObject obj2 = new JSONObject().put("name", "Aliya");   //  { "name": "Aliya" }
        assertEquals("{\"name\":\"Aliya\"}", obj2.toString());

        JSONObject obj3 = new JSONObject().put("name", "Aliya").put("age", 20);   //  { "name": "Aliya", "age": 20 }
        assertEquals("{\"name\":\"Aliya\",\"age\":20}", obj3.toString());

        // use assertTrue with .similar() to compare ignoring field order
        assertTrue(obj3.similar(new JSONObject().put("age", 20).put("name", "Aliya")));

        // nested objects
        JSONObject obj4 = new JSONObject().put("name", "Aliya").put("age", 20)
                .put("address", new JSONObject().put("city", "Lahore").put("country", "Pakistan")); // { "name": "Aliya", "age": 20, "address": { "city": "Lahore", "country": "Pakistan" } }

        // order of fields coming back from toString() is unpredicatable; this likely fails:
        //    assertEquals("{\"name\":\"Aliya\",\"age\":20,\"address\":{\"city\":\"Lahore\",\"country\":\"Pakistan\"}}",
        //             obj4.toString());

        // use assertTrue with .similar() to compare ignoring field order
        // use JSONObject constructor to parse a string into a JSONObject
        // note that the strings in the string don't necessarily have to be quoted, convenient!

        assertTrue(new JSONObject("{name:Aliya,age:20,address:{city:Lahore,country:Pakistan}}")
                        .similar( new JSONObject(obj4.toString()) ));
        assertTrue(new JSONObject("{age:20,address:{city:Lahore,country:Pakistan},name:Aliya}")     // order doesn't matter when parsed as a JSONObject
                        .similar( new JSONObject(obj4.toString()) ));
    }

    // JSONArray - a list of JSON data
    @Test
    public void demo2() {
        JSONArray arr = new JSONArray();   //  []
        assertEquals("[]", arr.toString());

        JSONArray arr2 = new JSONArray().put("Aliya").put("Burhan");   //  [ "Aliya", "Burhan" ]
        assertEquals("[\"Aliya\",\"Burhan\"]", arr2.toString());

        // for comparing JSONArrays, can also use assertTrue with .similar() and the JSONArray constructor
        //  to parse a string as a JSONArray format object
        assertTrue(arr2.similar( new JSONArray("[Aliya,Burhan]") ));

        // array of numbers
        JSONArray arr3 = new JSONArray().put(10).put(20).put(30);   //  [ 1, 2, 3 ]
        assertTrue(arr3.similar( new JSONArray("[10,20,30]") ));
        assertFalse(arr3.similar( new JSONArray("[30,20,10]") ));   // order of elements is important
    }

}
