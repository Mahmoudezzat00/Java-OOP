package linear;

import linear.algebra.GaussianElimination;

public class EquationSolver {
	// javac linear\EquationSolver.java linear\algebra\GaussianElimination.java
	// java linear.EquationSolver 1,3,1,9 1,1,-1,1 3,11,5,35
	// java linear.EquationSolver 2,1,-1,8 -3,-1,2,-11 -2,1,2,-3
	static double[] stringsToDoubles(String[] strings) {
		double array[] = new double[strings.length];
		for (int i = 0; i < strings.length; i++)
			array[i] = Double.parseDouble(strings[i]);
		return array;
	}

	public static void main(String[] args) {
		int rows = args.length;
		int cols = args[0].split(",").length;
		double matrix[][] = new double[rows][cols];
		for (int i = 0; i < args.length; i++) {
			matrix[i] = stringsToDoubles(args[i].split(","));
		}

		GaussianElimination ge = new GaussianElimination(rows, cols, matrix);
		ge.print();
		ge.rowEchelonForm();
		ge.print();
		ge.backSubstitution();
		ge.print();
	}
}