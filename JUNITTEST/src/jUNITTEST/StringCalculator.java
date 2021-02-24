package jUNITTEST;
public class StringCalculator {
public int a=0;
	public int Add(String numbers) throws NegativeEx
		{ a++;
		if(numbers.length()==0)
		return 0;
		int sum=0;
		String[] strarr = null;
		String[] rstrarr = null;
		System.out.print(numbers.substring(0,2));	
		if(numbers.substring(0,2).equals("//"))
    		{
	        strarr=numbers.split("\n",2);	
					if(strarr.length>1){
						System.out.print(strarr.length);
						char del=strarr[0].charAt(strarr[0].length()-1);
						rstrarr=strarr[1].split(Character.toString(del),-1);
						}
    		}
		else{
			rstrarr=numbers.split("\n|\\,",-1);	
	 	    }
		    for(String a: rstrarr)
				  {   int temp=Integer.parseInt(a);
			        if(temp<0)
			        	{
			        		throw new NegativeEx(a);
			        	}
			        if(temp<1000)
			        sum+=temp; 
					}
		    return sum;
			 }
	
	public int GetCalledCount()
	{
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
