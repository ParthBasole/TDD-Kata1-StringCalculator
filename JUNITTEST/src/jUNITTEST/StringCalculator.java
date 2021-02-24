package jUNITTEST;


public class StringCalculator {

	public int Add(String numbers)
	{
		if(numbers.length()==0)
		return 0;
		
	String[] strarr=numbers.split(",",-1);
		int sum=0;
	for(String a: strarr)
	{sum+=Integer.parseInt(a);
		
	}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
