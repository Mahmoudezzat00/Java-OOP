package array.util.main;

import java.util.Arrays;

import array.util.ArrayUtil;

public class Main {
	public static void main(String[] args) {
		String arrayLenTxt = System.console().readLine();
		int arrayLen = Integer.parseInt(arrayLenTxt);

		int[] array = new int[arrayLen];

		for (int i = 0; i < arrayLen; i++) {
			String elemTxt = System.console().readLine();
			array[i] = Integer.parseInt(elemTxt);
		}

		int result1 = ArrayUtil.max(array);
		int result2 = ArrayUtil.max2(array);
		int result3 = ArrayUtil.max3(array);
		int result4 = ArrayUtil.max4(array);

		int[] minMax = ArrayUtil.minMax(array);

		System.out.println("Ugly:");
		System.out.println(array);
		System.out.println(minMax);

		System.out.println("---------------------------");
		System.out.println(Arrays.toString(array));
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(Arrays.toString(minMax));
	}
}