package math.operation.textual;

public class Adder {
	public String addAsText(String opTxt1, String opTxt2) {
		try {
			int ia = Integer.parseInt(opTxt1);
			int ib = Integer.parseInt(opTxt2);
			return Integer.toString(ia + ib);
		} catch (NumberFormatException e) {
			try {
				double da = Double.parseDouble(opTxt1);
				double db = Double.parseDouble(opTxt2);
				return Double.toString(da + db);
			} catch (NumberFormatException e2) {
			}
		}

		return "Operands are not numbers";
	}
}
