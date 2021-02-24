package jUNITTEST;

import java.util.ArrayList;

public class StringCalculator {
public int flag=0;
	public int Add(String numbers) throws NegativeEx  						 	//Adds String
		{ 
			if(numbers.length()==0)
			return 0;
			int sum=0;
			String[] strarr = null;
			String[] rstrarr = null;
			//System.out.print(numbers.substring(0,2));	
				if(numbers.substring(0,2).equals("//")) 	 					//Checks if first two characters are "//"  
					{	strarr=numbers.split("\n",2);    						// Splits the String in two different parts keeping \n as its pivot point 
		     
					   if(strarr.length>1)					 					//Condition added to see if actually number is splittable or not.
						{    
								String del=strarr[0].substring(strarr[0].indexOf("/") + 2, strarr[0].length()); //if custom delimiter is given this extracts portion between //  and \n 
					
								String Target=indexofallBrack(del,strarr[1]);  //if delimiter has multiple delimiter 
						                                                       //i.e "//[delimeter1][[delimeter2]\n" 
																	           //then this helper function takes those delimiters and replaces them with "," in the the addition part of string 
						 										
						        if(flag==1)                                            //This flag is set in helper function below which checks if there are multiple delimiter or not if there are then flag =1 else 0
							     {rstrarr=stringSplit(",",Target);}
						        else
						         {rstrarr=stringSplit(del,Target);} 					//rstrarr is a string array which has all the number present as string
                 		}
    		        }																	//Closes if there is custom delimiter 
			    else{                                                                 //if default case is present 
			    		rstrarr=numbers.split("\n|\\,",-1); 						//or regex used for checking if the string has \n or , as delimiter	
			    	}
		    for(String a: rstrarr)   											  // Iterator to take single number in consideration
				  	{    int temp=Integer.parseInt(a); 								//parsing the string as int
				  		
				  	      if(temp<0)                       						//if negative number is present then throws custom made exception check the other file attached for defination
				  			{
			        		throw new NegativeEx(a);
				  			}
	                      if(temp<1000)     									// adds number only if they are below 1000 
			              sum+=temp; 
					}
		    return sum;
		}
	
	
	
	public String[] stringSplit(String str,String target) 					//Helper function which splits string via string i.e abra ##$$ cadabra becomes a array[abra,cadabra]  
 	{  //Object arr;
		 String[] rtr;
		 if(str.length()==1)              									//if the given delimiter has single character as its defination then this uses System Split method
		 {
			 rtr=target.split(str,-1);
			 return rtr;
		 }
		ArrayList<String> ar = new ArrayList<String>();						//String aray list generation for dynamic addition
        int F_index=0,B_index=0,W_index=0;  								//F_index =Front Index B_index= Back_Index  
        B_index=str.length(); 
 	    String temp;
        while(B_index<=target.length())  									// logic behind this is basically check if target has str i.e del in main code
        																	//present in it and then break target string to make a array of string numbers which are seperated by str
        	{
        	temp=target.substring(F_index,B_index); 						//makes substring     
   
        	if(temp.equals(str))                    						//checks if it is equal to str
        	 	{ar.add(target.substring(W_index,F_index));   				//if it then adds it to our collection of numerical string
 
 		         F_index=B_index;
 		         W_index=B_index;
 		         B_index+=Math.min(str.length(),target.length()-B_index); 	//Used min for borderline condition 
 
        	 	}
        		F_index++;
        		B_index++;
        	 }
 
        ar.add(target.substring(F_index-1,B_index-1));  					//-1 added because incrementing nature of while loop giving offset
        rtr=new String[ar.size()];    
        rtr=ar.toArray(rtr); 												//converts arraylist to array
		 return rtr;
	}
	
	
	
	public String indexofallBrack(String str,String Target)  			// Box cutter helper and replacer i.e [delimiter1][delimiter2] changes to a single delimter i.e ,
	                                                        			//which is returned to main function
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
	

}
