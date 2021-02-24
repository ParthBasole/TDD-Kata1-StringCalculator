package jUNITTEST;


public class StringCalculator {

	public int Add(String numbers)
	{
		if(numbers.length()==0)
		return 0;
	//	System.out.print(numbers);
	String[] strarr=numbers.split("\n",2);
	int sum=0;
    char del=strarr[0].charAt(strarr[0].length()-1);
    String[] rstrarr=strarr[1].split(Character.toString(del),-1);
    for(String a: rstrarr)
	{sum+=Integer.parseInt(a);
		
	}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
