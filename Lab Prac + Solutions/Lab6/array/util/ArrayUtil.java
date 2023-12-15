package array.util;

//import checkthat.annotation.IsUsingDefaultConstructor;

//@IsUsingDefaultConstructor
public class ArrayUtil {

	public static int max(int[] array) {
		if (array.length == 0)    return 0;

		int retval = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > retval)    retval = array[i];
		}

		return retval;
	}

	public static int max2(int[] array) {
		if (array.length == 0)    return 0;

		int retval = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			retval = array[i] > retval ? array[i] : retval;
		}

		return retval;
	}

	public static int max3(int[] array) {
		if (array.length == 0)    return 0;

		int retval = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			retval = Math.max(retval, array[i]);
		}

		return retval;
	}

	public static int max4(int[] array) {
		if (array.length == 0)    return 0;

		int retval = Integer.MIN_VALUE;
		for (int elem : array) {
			retval = Math.max(retval, elem);
		}

		return retval;
	}

	public static int[] minMax(int[] array) {
		if (array.length == 0)    return new int[] { 0, 0 };

		int[] retval = { Integer.MAX_VALUE, Integer.MIN_VALUE };
		for (int elem : array) {
			retval[0] = Math.min(retval[0], elem);
			retval[1] = Math.max(retval[1], elem);
		}

		return retval;
	}
}