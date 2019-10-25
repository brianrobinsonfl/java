package brianRobinson;

import org.apache.commons.lang3.math.NumberUtils;
import java.math.BigDecimal;

public class Module1 {

	enum nTypes {
		Boolean, Byte, Char, Class, Interface, Double, Float, Int, Long, Short;
	}

	// ***********************************************
	Module1() { // Constructor
		// myTools.logit("Module1", "Constructor");
	} // END

	// ***********************************************
	void runExersizes() {
		String label = "runExersizes";
		int idx = 0;
		Object[] o = new Object[100];

		myTools.logit(label, "**************** Module 1 Begin ********************");

		myTools.logit(" ================= Data Manipulations and Tests ===================");
		int a = 10, b = 3, c = 0;
		myTools.logit();
		myTools.logit(label, "Numberic Operators ....");
		c = a + b;
		myTools.logit(label, a + "+" + b + "=" + c);
		c = a - b;
		myTools.logit(label, a + "-" + b + "=" + c);
		c = a * b;
		myTools.logit(label, a + "*" + b + "=" + c);
		c = a / b;
		myTools.logit(label, a + "/" + b + "=" + c);
		c = a % b;
		myTools.logit(label, a + "%" + b + "=" + c + " <-- Remainder");

		myTools.logit(" -------------- Voting Age ... asuming 18 is leagle -----------");
		initO(o);
		idx = 0;
		o[idx++] = "John Doe";
		o[idx++] = 16;
		o[idx++] = "Jane Doe";
		o[idx++] = 23;
		for (int i = 0; i < o.length && o[i] != null; i++) {
			if (o[i].getClass().getName().contains("String"))
				myTools.logit(label, "Name: " + o[i]);
			else if (18 > (int) o[i])
				myTools.logit(label, o[i] + " Not of Age to Vote");
			else
				myTools.logit(label, o[i] + " of Age to Vote");
		}

		myTools.logit(" -------------- Negative / Zero / Positive -----------");
		initO(o);
		idx = 0;
		o[idx++] = -2;
		o[idx++] = -1;
		o[idx++] = 0;
		o[idx++] = 1;
		o[idx++] = 2;

		for (int i = 0; i < o.length && o[i] != null; i++) {
			if ((int) o[i] < 0)
				myTools.logit(label, o[i] + " negative");
			else if ((int) o[i] == 0)
				myTools.logit(label, o[i] + " Zero");
			else
				myTools.logit(label, o[i] + " positive");
		}

		myTools.logit(" -------------- Compare some numbers -----------");
		myTools.logit();
		initO(o);
		idx = 0;
		o[idx++] = 5;
		o[idx++] = 6;
		o[idx++] = 6;
		o[idx++] = 5;
		o[idx++] = 4;
		o[idx++] = 4;
		int x = 0, y = 0;

		for (int i = 0; i < o.length && o[i] != null && o[i + 1] != null; i++) {
			x = (int) o[i];
			y = (int) o[i + 1];
			if (x < y)
				myTools.logit(label, x + " < " + y);
			if (x == y)
				myTools.logit(label, x + " == " + y);
			if (x > y)
				myTools.logit(label, x + " > " + y);
		}

		myTools.logit("\n================= forLoop ========================================== ");
		for (idx = 0; idx < 2; idx++) {
			myTools.logit("\n"+ idx + " ===================== forLoop "+idx+" =================== ");
			runTestBlock();
		}

		myTools.logit("\n ================= While  ========================================== ");
		idx = 0;
		while (idx++ < 2) {
			myTools.logit("\n"+ idx + " ===================== While "+idx+" =================== ");
			runTestBlock();
		}

		idx = 0;
		myTools.logit("\n ================= doWhile  ========================================== ");
		do {
			myTools.logit("\n"+ idx + " ===================== doWhile "+idx+" =================== ");
			runTestBlock();
		} while (++idx < 2);

	} // END

	// ***********************************************
	void runTestBlock() {
		int idx = 0;
		Object[] o = new Object[100];

		myTools.logit(" -------------- Even or Odd Numbers -----------");
		initO(o);
		for (int i = 0; i < 6; i++)
			o[i] = i;
		for (int i = 0; i < o.length && o[i] != null; i++) {
			if ((int) o[i] % 2 == 1)
				myTools.logit( o[i] + " is even");
			else
				myTools.logit( o[i] + " is odd");
		}

		myTools.logit(" -------------- Factorial of a Number -----------");
		int num = 5;
		for (int i = 1, fact = 1; i <= num; i++) {
			fact = fact * i;
			myTools.logit( num + ": " + fact);
		}
		num = 8;
		for (int i = 1, fact = 1; i <= num; i++) {
			fact = fact * i;
			myTools.logit( num + ": " + fact);
		}

		myTools.logit(" -------------- Table of 10 Rows, 10 Columns -----------");
		Object row[] = new Object[10];
		Object col[] = new Object[10];
		initO(row);
		initO(col);

		for (int i = 0; i < 10; i++) {
			for (int ii = 0; ii < 10; ii++)
				col[ii] = ii + 100;
			row[i] = col;
		}
		for (int i = 0; i < row.length && row[i] != null; i++) {
			myTools.logitAt(i + "|");
			for (int ii = 0; ii < col.length && col[ii] != null; ii++)
				myTools.logitAt(col[ii] + " ");
			myTools.logit("");
		}

		myTools.logit(" -------------- Add the Digits of a Number -----------");
		initO(o);
		for (int i = 0; i < 5; i++)
			o[i] = i + 100;
		for (int i = 0; i < o.length && o[i] != null; i++) {
			int x = 0, sum = 0, digit = 0;
			x = (int) o[i];
			myTools.logit(x+"  <-------------------------------");
			while (x > 0) {
				digit = x % 10;
				sum = sum + digit;
				x = x / 10;
				myTools.logit( "value:" + o[i] + " sum:" + sum + " num:" + x);
			}
		}
		myTools.logit( "----------  Same Digits but Reversed --------------");
		initO(o);
		for (int i = 0; i < 5; i++)
			o[i] = i + 100;
		for (int i = 0; i < o.length && o[i] != null; i++) {
			int x = 0, sum = 0, digit = 0;

			String reverse = new StringBuffer(""+o[i]).reverse().toString();
			x = (int) Integer.parseInt(reverse);
			myTools.logit(x+"  <-------------------------------");

			while (x > 0) {
				digit = x % 10;
				sum = sum + digit;
				x = x / 10;
				myTools.logit( "value: " + o[i] + " reverse:" + reverse + " sum:" + sum + " num:" + x);
			}
		}

		myTools.logit(" -------------- generate 10 Fibonacci numbers -----------");
		int n1 = 0, n2 = 1, nx, i, count = 10;
		myTools.logit("Value: "+ n1);
		myTools.logit("Value: "+ n2);

		for (i = 2; i < count; ++i)// loop starts from 2 because 0 and 1 are already printed
		{
			nx = n1 + n2;
			myTools.logit("Value: "+ nx);
			n1 = n2;
			n2 = nx;
		}

		return;
	} // END

	// ------------------------------------------------------------
	void initO(Object o[]) {
		for (int i = 0; i < o.length && o[i] != null; i++)
			o[i] = null;
	}

} // END
