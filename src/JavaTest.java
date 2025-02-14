import org.junit.*;
import static org.junit.Assert.*;

public class JavaTest {
	@Test
	public void test() {

		// strings
		assertEquals("Hello World!", "Hello " + "World!");
		
		// primitive numbers (integers), booleans
		// Arithmetic operators: +  *  /   -
		// (parentheses used to overrule precedence)
		assertEquals(4, 2+2);
		assertEquals(5, 10/2);
		assertEquals(8, 10/2+3);
		assertEquals(2, 10/(2+3));
		assertEquals(3, 10/3);		// integer division

		
		// Relational operators: <   <=  >  >=  ==  !=
		assertEquals(true, 2+2 == 4);
		assertEquals(true, 2+2 <= 4);
		assertEquals(false, 2+2 > 4);
		
		// Logical operators: && (and) || (or) ! (not)
		assertEquals(true, true && true);
		assertEquals(false, true && false);
		assertEquals(false, 2+2==4 && 2-2>0);
		assertEquals(false, ! true);
		assertEquals(true, !(2+2==4 && 2-2>0));
		assertEquals(true, 2+2==4 || 2-2>0);
		
		// primitive numbers - double (floating-point values)
		assertEquals(0,  2 / 4);		    // integer division !!!!!!!
		assertEquals(.5, 2.0 / 4.0, 0.0);	// floating-point division
		// assertEquals(.41, .01 + .05 + .10 + .25);   // !!!!!!!!!
		assertEquals(.41, .01 + .05 + .10 + .25, .01); 	
		assertEquals(3.333, 10.0/3.0, .001);

	}    
}
