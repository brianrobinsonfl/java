package brianRobinson;

public  class MyUtils {

	public enum StringType {
		INT, DOUBLE, STRING, OTHER;
	}

	// ******************************************************************************
	public  static boolean isNumber(Object o) {
		String label = "isNumber";
		boolean rtn = false;
			try {
				Double.parseDouble(o.toString());
				rtn = true;
			} catch (NumberFormatException ee) {
			}

		//logit(label , o.toString() + " " + rtn);
		return rtn;
	}

} // END .....