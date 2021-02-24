package jUNITTEST;

import java.util.ArrayList;

public class StringCalculator {
public int a=0;
public int flag=0;
	public int Add(String numbers) throws NegativeEx
		{ a++;
		if(numbers.length()==0)
		return 0;
		int sum=0;
		String[] strarr = null;
		String[] rstrarr = null;
		//System.out.print(numbers.substring(0,2));	
		if(numbers.substring(0,2).equals("//"))
    		{
	        strarr=numbers.split("\n",2);
	      //  System.out.print(strarr[0].length());
					if(strarr.length>1){
						String del=strarr[0].substring(strarr[0].indexOf("/") + 2, strarr[0].length());
					
						String Target=indexofallBrack(del,strarr[1]);
						if(flag==1)
							{rstrarr=stringSplit(",",Target);}
						else
						{rstrarr=stringSplit(del,Target);}
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
	
	
	
	
	
	
	
	public String[] stringSplit(String str,String target)
 	{  //Object arr;
		 String[] rtr;
		 if(str.length()==1)
		 {
			 rtr=target.split(str,-1);
			 return rtr;
		 }
		ArrayList<String> ar = new ArrayList<String>();
        int F_index=0,B_index=0,W_index=0;
        B_index=str.length();
 	    String temp;
        while(B_index<=target.length())
        	{
        	temp=target.substring(F_index,B_index);
        //	System.out.println(temp+"  B_index "+B_index+"  F_index "+F_index+"  W_index "+W_index); 
        	if(temp.equals(str))
        	 	{ar.add(target.substring(W_index,F_index));
        	 //	 System.out.println("Added"+target.substring(W_index,F_index));
 		         F_index=B_index;
 		         W_index=B_index;
 		         B_index+=Math.min(str.length(),target.length()-B_index);
 		       //  System.out.println(target.length()-B_index);
 		       // System.out.println(temp+"  B_index "+B_index+"  F_index "+F_index+"  W_index "+W_index);
        	 	}
        		F_index++;
        		B_index++;
        	 }
        //System.out.print("added"+target.substring(F_index-1,B_index-1));
        ar.add(target.substring(F_index-1,B_index-1));
        rtr=new String[ar.size()];    
        rtr=ar.toArray(rtr);
		 return rtr;
	}
	
	public String indexofallBrack(String str,String Target)
	{int index_FB=str.indexOf('[');
	 int index_BB=str.indexOf(']');
	// int cntr1=0,cntr0=0;
	 //StringBuilder str_t=new StringBuilder("");
	 String T_str = Target;
	// ArrayList<String> ar = new ArrayList<String>(); 
	 while(index_FB!=-1)
	 { T_str= T_str.replace(str.substring(index_FB+1,index_BB),",");
	    //System.out.println(str.substring(index_FB+1,index_BB));
	   flag=1;
	    index_FB=str.indexOf('[',index_FB+1);
	    index_BB=str.indexOf(']',index_BB+1);	 
	 }
	    System.out.println(T_str);
		return T_str;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
