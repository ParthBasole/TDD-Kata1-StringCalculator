package jUNITTEST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import static org.junit.jupiter.api.Assertions.assertThrows;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
public class JunitTest {
	 
		private StringCalculator calc;
		@BeforeEach
		public void setup() {
			calc=new StringCalculator();
		}
		
		@Test
		public void testAdd() throws NegativeEx {
	     assertEquals(0,calc.Add(""),"Null String should give out 0");
}
		
		@Test
		public void testAddS() throws NegativeEx {
	     assertEquals(5,calc.Add("2,3"),"This String should give out 5");
}
		@Test
		public void testAddMult() throws NegativeEx{
	     assertEquals(24,calc.Add("2,3,6,7,6"),"This String should give out 5");

		}
		@Test
		public void testDiffDel() throws NegativeEx
		{
			assertEquals(7,calc.Add("2\n2,3"),"This should give out 6 check split");
		}
		@Test
		public void testCustDel() throws NegativeEx
		{
			assertEquals(7,calc.Add("//;\n2;3;2"),"This should give out 7 check split");
		}
		@Test
		public void testCustDel1() throws NegativeEx
		{
			assertEquals(9,calc.Add("//p\n2p3p2p2"),"This should give out 9 check split");
		}
		
		//@SuppressWarnings("deprecation")
		
		@Test
		public void testNegatov()
		{
			NegativeEx thrown=assertThrows(
					NegativeEx.class,
					()->calc.Add("//p\n-2p3p2p2"),
					"expected negative throw"
					);
		}
		@Test
		public void checkMethodCalls() throws NegativeEx
		{
			System.out.print(calc.GetCalledCount());
		}
		
		@Test
		public void moreThanTwothousand() throws NegativeEx
		{
			assertEquals(326,calc.Add("4,322,3000"));
		}
		
		@Test
		public void anyLength() throws NegativeEx
		{
			assertEquals(326,calc.Add("//***\n4***322***3000"));
		}
		
		@Test
		public void FuncChecker()
		{
			calc.stringSplit("***","4***322***3000");
		}
}
