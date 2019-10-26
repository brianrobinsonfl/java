package brianRobinson;

 final class LogIt {
	// ******************************************************************************
	protected static void logit(String label, Object... obj) {
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
	protected  static void logitAt(String txt) {
		System.out.print(txt);
	}

	// ******************************************************************************
	protected  static void logit(char c) {
		System.out.print(c);
	}

	// ******************************************************************************
	protected  static void logit(String txt) {
		System.out.println(txt);
	}

} // END .....
