package jUNITTEST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import static org.junit.jupiter.api.Assertions.assertThrows;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
public class JunitTest {
	 
		private StringCalculator calc;     
		@BeforeEach            //Setup 
		public void setup() {
			calc=new StringCalculator();
		}
		
		@Test
		public void testAdd() throws NegativeEx {    //NULL Test
	     assertEquals(0,calc.Add(""),"Null String should give out 0");
        }
		
		@Test
		public void testAddS() throws NegativeEx { //Simple addition
	     assertEquals(5,calc.Add("2,3"),"This String should give out 5");
}
		@Test 
		public void testAddMult() throws NegativeEx{ //Multiple addition
	     assertEquals(24,calc.Add("2,3,6,7,6"),"This String should give out 5");

		}
		@Test
		public void testDiffDel() throws NegativeEx  //Uses different Delimiter which is \n with ,
		{
			assertEquals(7,calc.Add("2\n2,3"),"This should give out 6 check split");
		}
		@Test
		public void testCustDel() throws NegativeEx    //Uses custom delimiter
		{
			assertEquals(7,calc.Add("//;\n2;3;2"),"This should give out 7 check split");
		}
		@Test
		public void testCustDel1() throws NegativeEx  //another one of custom delimiter 
		{
			assertEquals(9,calc.Add("//p\n2p3p2p2"),"This should give out 9 check split");
		}
		
		//@SuppressWarnings("deprecation")
		
		@Test
		public void testNegatov() //exception handling when negative
		{
			NegativeEx thrown=assertThrows(
					NegativeEx.class,
					()->calc.Add("//p\n-2p3p2p2"),
					"expected negative throw"
					);
		}
		
		@Test
		public void moreThanTwothousand() throws NegativeEx //more than thousand not accepted
 		{
			assertEquals(326,calc.Add("4,322,3000"));
		}
		
		@Test
		public void anyLength() throws NegativeEx  //string delimiter
		{
			assertEquals(626,calc.Add("//+++**\n4+++**322+++**300"));
		}
		
		@Test
		public void FuncChecker() //helper function checker the one which extracts numbers 
		{ 
			calc.stringSplit("+++*","4+++*322+++*3000");
		}
		
		@Test
		public void MultipleDel() throws NegativeEx   //Multiple delimiter checker
		{
			assertEquals(100,calc.Add("//[%][*]\n4%56*40"));
		}
		
		@Test
		public void Brack() throws NegativeEx //another function checker this one deals with box cutter one
		{
			calc.indexofallBrack("[%][*]","4%56*40");
		}
		@Test
		public void MultipleLDel() throws NegativeEx   //Uses multiple string delimeters
		{
			assertEquals(100,calc.Add("//[%**][##*]\n4%**56##*40"));
		}
}
