package brianRobinson;

import org.apache.commons.lang3.math.NumberUtils;
import java.math.BigDecimal; 

public class Test {
	
	enum DataTypes { BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING }

	//------------------------------------------------------------
	Test() {  // Constructor
		myTools.logit("Module1", "Constructor");
	} // END

	//------------------------------------------------------------
	void ifExample(Object o[]) {
		String label = "ifExample";
		myTools.logit();
		myTools.logit(label,o.length,o.toString());

		for (int i = 0; i < o.length && o[i] != null; i++) { 
			myTools.logit(label,o[i]);

			if(NumberUtils.isNumber(o[i].toString())) {				// IF String is Number
				BigDecimal bd = new BigDecimal(o[i].toString()); 
				myTools.logit(label,"String contains a number("+bd+")");
			} else {
				myTools.logit(label,"Not a number("+o[i].toString()+")");
			}			
		}
		return;
	} // END
	// ------------------------------------------------------------
	void forLoop(Object o[]) {
		String label = "forLoopExample";
		myTools.logit();
		// myTools.logit(label,o.length,o.toString());
		for (int i = 0; i < o.length && o[i] != null; i++) { // increment I after For process Block
			myTools.logit(label, o[i]);
		}
		return;
	} // END

	// ------------------------------------------------------------
	void whileTrue(Object o[]) {
		String label = "whileExample";
		myTools.logit();
		// myTools.logit(label,o.length,o.toString());
		int i = 0;
		while (i < o.length && o[i] != null) {
			myTools.logit(label, o[i++]); // increment I after While, in process Block
		}

		return;
	} // END

	// ------------------------------------------------------------
	void doWhileTrue(Object o[]) {
		String label = "doWhileExample";
		myTools.logit();
		// myTools.logit(label,o.length,o.toString());
		int i = 0;
		do {
			myTools.logit(label, o[i]);
		} while (i < o.length && o[++i] != null); // increment I BEFORE !!! While Condition, after process Block

		return;
	} // END

	//------------------------------------------------------------
	void ifStatementExample(Object o[]) {
		String label = "ifStatementExample";
		myTools.logit();
		myTools.logit(label,o.length,o.toString());

		for (int i = 0; i < o.length && o[i] != null; i++) { 
			myTools.logit(label,o[i]);

			if(NumberUtils.isNumber(o[i].toString())) {
				BigDecimal bd = new BigDecimal(o[i].toString()); 
				myTools.logit(label,"BigDecimal("+bd+")");
				
			}

		}

		return;
	} // END


	
	/*
	//------------------------------------------------------------
	void getToken(String txt) {
		String label = "getValue";
		myTools.logit();
		myTools.logit(label,o.length,o.toString());

		for (int i = 0; i < o.length && o[i] != null; i++) { 
			myTools.logit(label,o[i]);

			if(NumberUtils.isNumber(o[i].toString())) {				// IF String is Number
				BigDecimal bd = new BigDecimal(o[i].toString()); 
				myTools.logit(label,"String contains a number("+bd+")");
			} else {
				myTools.logit(label,"Not a number("+o[i].toString()+")");
			}			
		}
		return;
	} // END
	*/

	
	
	
	
	
	
	//***********************************************
	//***********************************************
	//***********************************************
	void runTests() {
		String label = "runTests";
		myTools.logit(true);

		// ------- forLoopExample --- print contents of objet -----
		Object[] o = new Object[10];
		o[0]="test forLoop";
		o[1]=1234;
		o[2]=12.34F;
		forLoopExample(o);

		// ------- whileExample --- print contents of objet -----
		o[0]="test whileLoop";
		o[1]=5678;
		o[2]=56.78F;
		whileExample(o);

		// ------- doWhileExample --- print contents of objet -----
		o[0]="test doWhileLoop";
		o[1]=9012;
		o[2]=90.12F;
		doWhileExample(o);

		myTools.logit(false);

	} // END
	
	//------------------------------------------------------------
	void forLoopExample(Object o[]) {
		String label = "forLoopExample";
		myTools.logit();
		//myTools.logit(label,o.length,o.toString());
		for (int i = 0; i < o.length && o[i] != null; i++) { // increment I after For process Block
			myTools.logit(label,o[i]);
		}
		return;
	} // END

	//------------------------------------------------------------
	void whileExample(Object o[]) {
		String label = "whileExample";
		myTools.logit();
		//myTools.logit(label,o.length,o.toString());
		int i = 0;
		while(i < o.length && o[i] != null) {
			myTools.logit(label,o[i++]);  // increment I after While, in process Block
		} 

		return;
	} // END

	//------------------------------------------------------------
	void doWhileExample(Object o[]) {
		String label = "doWhileExample";
		myTools.logit();
		//myTools.logit(label,o.length,o.toString());
		int i = 0;
		do {
			myTools.logit(label,o[i]);
		}
		while(i < o.length && o[++i] != null); 		// increment I BEFORE !!! While Condition, after process Block

		return;
	} // END
	
} // END

