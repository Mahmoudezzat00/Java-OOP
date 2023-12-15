package linear.algebra;

public class GaussianElimination {
	private int rows;
	private int cols;
	private double matrix[][];

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public double[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(double matrix[][]) {
		checkMatrixDimensions(matrix);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
	}

	private void checkMatrixDimensions(double[][] matrix) {
		if (this.matrix.length != matrix.length)
			throw new IllegalArgumentException();

		for (int i = 0; i < rows; i++) {
			if (this.matrix[i].length != matrix[i].length)
				throw new IllegalArgumentException();
		}
	}

	public GaussianElimination(int rows, int cols, double matrix[][]) {
		this.rows = rows;
		this.cols = cols;
		this.matrix = new double[rows][cols];
		setMatrix(matrix);
	}

	private int argMax(int rowIndex, int colIndex) {
		int maxIndex = rowIndex;
		double max = Math.abs(matrix[rowIndex][colIndex]);
		for (int i = rowIndex + 1; i < rows; i++) {
			if (Math.abs(matrix[i][colIndex]) > max) {
				max = Math.abs(matrix[i][colIndex]);
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private void swapRows(int row1, int row2) {
		for (int j = 0; j < cols; j++) {
			double temp = matrix[row1][j];
			matrix[row1][j] = matrix[row2][j];
			matrix[row2][j] = temp;
		}
	}

	private void multiplyAndAddRow(int addRow, int mulRow, int colIndex) {
		double f = matrix[addRow][colIndex] / matrix[mulRow][colIndex];
		/* Fill with zeros the lower part of pivot column: */
		matrix[addRow][colIndex] = 0;
		/* Do for all remaining elements in current row: */
		for (int j = colIndex + 1; j < cols; j++) {
			matrix[addRow][j] = matrix[addRow][j] - matrix[mulRow][j] * f;
		}
	}

	private void multiplyRow(int rowIndex, int colIndex) {
		for (int j = colIndex + 1; j < cols; j++) {
			matrix[rowIndex][j] /= matrix[rowIndex][colIndex];
		}
		matrix[rowIndex][colIndex] = 1.0;
	}

	public void rowEchelonForm() {
		int rowIndex = 0, colIndex = 0; /* Initialization of the pivot row, column */
		while (rowIndex < rows && colIndex < cols) {
			/* Find the k-th pivot: */
			int iMax = argMax(rowIndex, colIndex);
			if (matrix[iMax][colIndex] == 0) {
				/* No pivot in this column, pass to next column */
				colIndex++;
			} else {
				swapRows(rowIndex, iMax);
				/* Do for all rows below pivot: */
				for (int i = rowIndex + 1; i < rows; i++) {
					multiplyAndAddRow(i, rowIndex, colIndex);
				}
				// reduced row echelon form
				multiplyRow(rowIndex, colIndex);
				/* Increase pivot row and column */
				rowIndex++;
				colIndex++;
			}
		}
	}

	public void backSubstitution() {
		for (int i = rows - 1; i >= 0; i--) {
			if (matrix[i][i] == 0)
				throw new IllegalArgumentException();
			for (int j = i - 1; j >= 0; j--) {
				multiplyAndAddRow(j, i, i);
			}
		}
	}

	public void print() {
		String message = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (j == cols - 1)
					message += "=";
				else if (matrix[i][j] >= 0)
					message += "+";
				message += matrix[i][j];
				if (j != cols - 1)
					message += Character.toString('z' - (cols - 2) + j);
			}
			message += System.lineSeparator();
		}
		System.out.println(message);
	}
}
