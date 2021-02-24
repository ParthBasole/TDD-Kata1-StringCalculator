package tdda;

public class StringCalculator {
	public int Add(String str) throws NegativeEx 
    {// String plr=str;
        //System.out.print("plr"+plr);
        str = str.replaceAll("[^\\d-]", " "); 
        str = str.trim(); 
        str = str.replaceAll(" +", " "); 
        if (str.equals("")) 
            return 0; 
        String [] Prod;
        Prod=str.split(" ",-1);
        
        int sum=0;
        for(String a: Prod)
        {  int temp=Integer.parseInt(a); 								//parsing the string as int
       // System.out.print(a+" ");   
        if(temp<0)                       						//if negative number is present then throws custom made exception check the other file attached for defination
			 {
  		     throw new NegativeEx(a);
			 }
            if(temp<1000)     									// adds number only if they are below 1000 
           sum+=temp; 
        }
    return sum;
    }
	
	
}
