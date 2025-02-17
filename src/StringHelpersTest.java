/**
* Nadeem Abdul Hamid, 2025.
*/

import org.junit.*;
import static org.junit.Assert.*;

public class StringHelpersTest {

    @Test
    public void testFormatAsDollars() {
        assertEquals("$10.00", StringHelpers.formatAsDollars(1000));
        assertEquals("$0.50", StringHelpers.formatAsDollars(50));
        assertEquals("$0.00", StringHelpers.formatAsDollars(0));
        assertEquals("$123.59", StringHelpers.formatAsDollars(12359));
        assertEquals("$40.05", StringHelpers.formatAsDollars(4005));
    }

    @Test
    public void testQuote() {
        assertEquals("\"hello\"", StringHelpers.quote("hello"));
        assertEquals("\"$14.99\"", StringHelpers.quote("$14.99"));
        assertEquals("\"\"", StringHelpers.quote(""));
    }

    @Test
    public void testKeyValuePair() {
        assertEquals("\"key\": \"value\"", StringHelpers.keyValuePair("key", "value", true));
        assertEquals("\"price\": { \"sale\": 10 }", StringHelpers.keyValuePair("price", "{ \"sale\": 10 }", false));
        assertEquals("\"code\": \"\"", StringHelpers.keyValuePair("code", "", true));

        // string value - default quote
        assertEquals("\"key\": \"value\"", StringHelpers.keyValuePair("key", "value"));
        assertEquals("\"code\": \"\"", StringHelpers.keyValuePair("code", ""));

        // int value
        assertEquals("\"id\": 10", StringHelpers.keyValuePair("id", 10));

        // int value not as dollars
        assertEquals("\"id\": 1798", StringHelpers.keyValuePair("id", 1798));

        // int value as dollars
        assertEquals("\"cost\": \"$14.50\"", StringHelpers.keyValuePair("cost", 1450, true));
    }

}

