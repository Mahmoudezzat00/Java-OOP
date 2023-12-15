package magic;

import magic.library.Incantation;

public class Soliloquy {
	public static void main(String[] args) {
		Incantation inc1 = new Incantation("programming is a fun and creative activity", 6);
		Incantation inc2 = new Incantation("to be or not to be", -123);
		Incantation inc3 = new Incantation(inc2);

		int arg5 = 1;
		int arg6 = 4;

		reciteIncantations(inc1, inc2, arg5, true);
		inc1.setIndex(arg6);
		reciteIncantations(inc1, inc3, arg5, false);
	}

	public static void reciteIncantations(Incantation inc1, Incantation inc2, int idx, boolean startWithAppend) {
		boolean result1 = inc1.enchant(inc2, !startWithAppend);
		printStatus(result1, inc1, inc2);

		inc1.setIndex(idx);
		printStatus(result1, inc1, inc2);

		boolean result2 = inc1.enchant(inc2, startWithAppend);
		printStatus(result2, inc1, inc2);

		boolean result3 = inc1.enchant(inc2, true);
		printStatus(result3, inc1, inc2);
	}

	private static void printStatus(boolean result, Incantation inc1, Incantation inc2) {
		System.out.println(
			result
			+ ";" + inc1.getIndex()
			+ ";" + inc1.getText()
			+ ";" + inc2.getIndex()
			+ ";" + inc2.getText());
	}
}
