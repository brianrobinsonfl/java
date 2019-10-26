package brianRobinson;

import java.util.Scanner;

final class Module2 {

	// ***********************************************
	Module2() { // Constructor
		LogIt.logit("Module2", "Constructor");
	} // END

	// ***********************************************
	public void runExersizes() {
		String label = "runExersizes";

		MyEmployees myHR = new MyEmployees(10);
		Scanner scanner = new Scanner(System.in);

		String uid, name, salary, str;
		int 	aId[] = new int[10];
		int 	aUid[] = new int[10];
		String 	aName[] = new String[10];
		double 	aSalary[] = new double[10];

		do {
			LogIt.logit(label, "");
			LogIt.logit(label, "=================================================================");
			LogIt.logit(label, " Please chose action - (A)dd, (D)isplay, (S)earch or e(X)it. ");
			str = scanner.next().toUpperCase();

			// ------------- ADD -----------------
			if (str.charAt(0) == 'A') {
				LogIt.logit("-------------- Add Employee------------------");
					LogIt.logit(label, "Enter Employee ID ... ");
					uid = scanner.next();
					LogIt.logit(label, "Enter Employee Name ... ");
					name = scanner.next();
					LogIt.logit(label, "Enter Employee Salary ... ");
					salary = scanner.next();
					LogIt.logit(label, "Adding .. UID (" + uid + ") Name (" + name + ") Salary ( $ " + salary + ")");
					myHR.add(uid, name, salary);
			}

			// ------------- DISPLAY -------------------
			if (str.charAt(0) == 'D') {
				
				LogIt.logit("-------------- Display Employees ------------------");

				// Load Arrays for Display Overloading ...
				for (int i = 0; i < myHR.getCount(); i++) {
					aId[i] = myHR.getMyEmployees()[i].getID();
					aUid[i] = myHR.getMyEmployees()[i].getUID(); 
					aName[i] = myHR.getMyEmployees()[i].getName(); 
					aSalary[i] = myHR.getMyEmployees()[i].getSalary();
				}
			
				// Now show overloading ....
				myHR.display(aId, aUid, aName, aSalary);
				myHR.display(aId, aUid, aName);
				myHR.display(aId, aName);
			}

			// ------------- DISPLAY -------------------
			if (str.charAt(0) == 'S') {
				LogIt.logit("-------------- Search for Employee---------------------");
				LogIt.logit(label, "Enter Employee Name ... ");
				name = scanner.next();

				// Load Arrays for Display Overloading ...
				for (int i = 0; i < myHR.getCount(); i++) {
					aId[i] = myHR.getMyEmployees()[i].getID();
					aUid[i] = myHR.getMyEmployees()[i].getUID(); 
					aName[i] = myHR.getMyEmployees()[i].getName(); 
					aSalary[i] = myHR.getMyEmployees()[i].getSalary();
				}
			
				// Now show overloading ....
				myHR.display(name, aId, aUid, aName, aSalary);
			}


		} while (str.charAt(0) != 'X');

		scanner.close();

	}
}

// ***********************************************
// ***********************************************
final class MyEmployees {

	private MyEmp myEmployees[] = new MyEmp[0];
	private int count = 0;

	// ***********************************************
	MyEmployees(int s) {
		myEmployees = new MyEmp[s];
	}

	// ***********************************************
	public int getCount() {
		return count;
	}

	// ***********************************************
	public MyEmp[] getMyEmployees() {
		return myEmployees;
	}

	// ***********************************************
	public void display(String search, int aId[], int aUid[], String aName[], double aSalary[]) {
		LogIt.logit("------------ Search -----------");
		boolean found = false;
		for (int i = 0; i < getCount() ; i++) {
			String s = aName[i].toUpperCase();
//			LogIt.logit("display","Searching .... ("+search+") in "+s);
			if(s.contains(search.toUpperCase()) ) {
				LogIt.logit("display","Found ("+search+") in "+aId[i]+"\t"+aUid[i]+"\t"+aName[i]+"\t$ "+aSalary[i]);
				found=true;
			}
		}
		if(!found)
			LogIt.logit("display","("+search+") was Not Found!");
	}
	// ***********************************************
	public void display(int aId[], int aUid[], String aName[], double aSalary[]) {
		LogIt.logit("------------ Display -----------");
		for (int i = 0; i < getCount() ; i++) {
			LogIt.logit("display","4 args ... ["+	aId[i]+"]  "+aUid[i]+"\t"+aName[i]+"\t$ "+aSalary[i]);
		}
	}
	// ***********************************************
	public void display(int aId[], int aUid[], String aName[]) {
		LogIt.logit("------------ Display -----------");
		for (int i = 0; i < getCount() ; i++) {
			LogIt.logit("display","3 args ... ["+aId[i]+"]  "+aUid[i]+"\t"+aName[i]);
		}
	}
	// ***********************************************
	public void display(int aId[], String aName[]) {
		LogIt.logit("------------ Display -----------");
		for (int i = 0; i < getCount(); i++) {
			LogIt.logit("display", "2 args ... ["+aId[i]+"]  "+	aName[i]);
		}
	}
	// ***********************************************
	public void add(Object... o) {
		String label = "add";
		String e = "";
		double s = -1;
		int uid = -1;
		int idx = 0;
		if (o.length != 3) {
			LogIt.logit(label, "Failed on Field Count: " + o.length + " !!");
			return;
		}

		for (Object x : o) {
			switch (++idx) {
			case 1: {
				uid = -1;
				if (MyUtils.isNumber(x)) {
					uid = Integer.parseInt(String.valueOf(x));
				}
				break;
			}
			case 2: {
				e = "(null)";
				if (!MyUtils.isNumber(x)) {
					e = String.valueOf(x);
				}
				break;
			}
			case 3: {
				s = -1;
				if (MyUtils.isNumber(x)) {
					s = Double.parseDouble(String.valueOf(x));
				}
				break;
			}
			default: {
				LogIt.logit(label, "Failed (" + x + ")");
				break;
			}
			}
		}

		MyEmp myEmp = new MyEmp(uid, e, s);
		myEmployees[count++] = myEmp;
		//dumpEmployees();
	}

	// ***********************************************
	public void dumpEmployees() {
		for (int i = 0; i < myEmployees.length && myEmployees[i] != null; i++) {
			LogIt.logit("dumpEmployees", "idx(" + i + ")", myEmployees[i].getUID(), myEmployees[i].getName(),
					myEmployees[i].getSalary());
		}
	}

} // END

// ***********************************************
// ***********************************************
final class MyEmp {

	private int ID = 0;
	private String name = "";
	private double salary = 0.0;
	private int UID = 0;

	// ***********************************************
	public int getUID() {
		return UID;
	}

	// ***********************************************
	public void setUID(int uID) {
		UID = uID;
	}

	// ***********************************************
	MyEmp(int uid, String l, double d) {
		name = l;
		salary = d;
		UID = uid;
		ID++;
	}

	// ***********************************************
	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	// ***********************************************
	public double getSalary() {
		return salary;
	}

	// ***********************************************
	public void setName(String l) {
		name = l;
	}

	// ***********************************************
	public void setSalary(double d) {
		salary = d;
	}
}
