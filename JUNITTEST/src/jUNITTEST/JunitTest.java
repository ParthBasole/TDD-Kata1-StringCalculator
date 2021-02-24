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
		
		@Test
		public void testAddS() {
	     assertEquals(5,calc.Add("2,3"),"This String should give out 5");
}
		@Test
		public void testAddMult() {
	     assertEquals(24,calc.Add("2,3,6,7,6"),"This String should give out 5");

		}
		@Test
		public void testDiffDel()
		{
			assertEquals(6,calc.Add("2\n2,3"),"This should give out 6 check split");
		}
		@Test
		public void testCustDel()
		{
			assertEquals(7,calc.Add("//;\n2;3;2"),"This should give out 7 check split");
		}
		@Test
		public void testCustDel1()
		{
			assertEquals(9,calc.Add("//p\n2p3p2p2"),"This should give out 9 check split");
		}
}
