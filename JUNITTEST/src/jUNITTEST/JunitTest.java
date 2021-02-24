package jUNITTEST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class JunitTest {
	 
		private StringCalculator calc;
		@BeforeEach
		public void setup() {
			calc=new StringCalculator();
		}
		
		@Test
		public void testAdd() {
	     assertEquals(0,calc.Add(""),"Null String should give out 0");
}
}
