package brianRobinson;

import java.lang.*;

// ***********************************************************************************
public class myTools {
	
	//******************** TEST TEST TEST TEST TEST ***************************
	public static void logitTest() {
		myTools.logit(33);
		myTools.logit(5.5f);

		myTools.logit('c');
		myTools.logit('\n');
		myTools.logit("string");
	}

	// *************** variable Arg like C/C++ .. good ot know  ********************
	public static void logit(String label, Object ... obj) { // who would have guess this :) great find
        System.out.print(label+"("+obj.length+"):"); // quantity of object being passed
	        
        int i = 0; // for loop protected from other variables... need to look at this
        for (Object x: obj) { // not sure of Object type, Vargs for JAVA :) !!!
    		System.out.print(x); 
    		if(++i != obj.length)  // 0 based array so preIncrement, checking for last token before printing ","
        		System.out.print(",");         		
        }
        System.out.println();  
        return;
	}

	// ******************************************************************************
	public static void logitAt(String txt) {
	   System.out.print(txt);
	}
	// ******************************************************************************
	public static void logit() {
	   System.out.println("---------------------------------------");
	}

	// ******************************************************************************
	public static void logit(char c ) {
	   System.out.print(c);
	}
	// ******************************************************************************
	public static void logit(boolean b) {
		if(b) {
			logit();
			System.out.println("Begin--------------------------------------");
		} else
			System.out.println("End----------------------------------------");
	}
	// ******************************************************************************
	public static void logit(String txt ) {
	   System.out.println(txt);
	}
	
	// ******************************************************************************
	public static void logit(Object o) {

		System.out.println("------>logit Object<------");
		System.out.println("logit: "+o.toString());
		System.out.println(o.getClass().getName());
		//		Days currentDay = Days.valueOf(o.getClass().getName().toUpperCase());  // enum this for Switch
		
	      if (o.getClass() == Integer.class) {
	            System.out.println("This is an Integer "+o.toString());
	        }else if(o.getClass() == String.class){
	            System.out.println("This is a String "+o.toString());
	        }else if(o.getClass() == Float.class){
	            System.out.println("This is a Float "+o.toString());
	        } else {
	            System.out.println("This is a Other "+o.toString());
	        }
	}

} // END OF myTools .....
