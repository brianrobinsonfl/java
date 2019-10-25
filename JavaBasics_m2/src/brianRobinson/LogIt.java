package brianRobinson;

public class LogIt {
	// ******************************************************************************
	public  static void logit(String label, Object... obj) {
		System.out.print(
				"[" + Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + "]" + label + ":");
		int i = 0;
		for (Object x : obj) {
			System.out.print(x);
			if (++i != obj.length)
				System.out.print(",");
		}
		System.out.println();
		return;
	}

	// ******************************************************************************
	public  static void logitAt(String txt) {
		System.out.print(txt);
	}

	// ******************************************************************************
	public  static void logit(char c) {
		System.out.print(c);
	}

	// ******************************************************************************
	public  static void logit(String txt) {
		System.out.println(txt);
	}

} // END .....
