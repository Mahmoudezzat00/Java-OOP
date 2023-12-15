package math.operation.safe;

public class Increment {
	public static int increment(int num) {
		return num == Integer.MAX_VALUE ? Integer.MAX_VALUE : num + 1;
	}
}
