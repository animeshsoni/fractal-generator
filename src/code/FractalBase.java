package code;

/**
 * @author Luke, Animesh, Ashok
 *
 */

public abstract class FractalBase {

	/**
	 * @return Low x Value
	 */
	public abstract double xLow();

	/**
	 * @return High x Value
	 */
	public abstract double xHigh();

	/**
	 * @return Low y Value
	 */
	public abstract double yLow();

	/**
	 * @return High y Value
	 */
	public abstract double yHigh();

	/**
	 * @param x
	 *            Current x value
	 * @param y
	 *            Current y value
	 * @param xCo
	 *            Current point's x coordinate
	 * @return updated x value
	 */
	public abstract double xUpdate(double x, double y, double xCo);

	/**
	 * @param x
	 *            x Current x value
	 * @param y
	 *            y Current y value
	 * @param yCo
	 *            Current point's y coordinate
	 * @return updated y value
	 */
	public abstract double yUpdate(double x, double y, double yCo);

	/**
	 * @param r
	 *            the index of the row in the 2d-array
	 * @return x coordinate associated with the row
	 */
	public double xCalc(int r) {
		double diff = xDiff() / 511;
		double retVal = ((r * diff) + xLow());
		return retVal;
	}

	/**
	 * @param c
	 *            the index of the column in the 2d-array
	 * @return y coordinate associated with the column
	 */
	public double yCalc(int c) {
		double diff = yDiff() / 511;
		double retVal = (yHigh() - (c * diff));
		return retVal;
	}

	/**
	 * @return the range of x values for the specific fractals ( xHigh - xLow)
	 */
	public double xDiff() {
		double retVal = xHigh() - xLow();
		return retVal;
	}

	/**
	 * @return the range of y values for the specific fractals ( yHigh - yLow)
	 */
	public double yDiff() {
		double retVal = yHigh() - yLow();
		return retVal;
	}

	/**
	 * @return the 2d array of int with escape times of all the 262144
	 *         coordinate pairs
	 */
	public int[][] escapeTimes() {

		int[][] retVal = new int[512][512];
		for (int r = 0; r < retVal.length; r++) {
			for (int c = 0; c < retVal[0].length; c++) {
				retVal[r][c] = calcEscapeTime(xCalc(r), yCalc(c));
			}
		}
		return retVal;
	}

	/**
	 * @param x
	 *            the x coordinate of the point
	 * @param y
	 *            the y coordinate of the point
	 * @return the escape time of the point
	 */
	public int calcEscapeTime(double x, double y) {
		double xCalc = x;
		double xCo = x;
		double yCalc = y;
		double yCo = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		while (dist <= 2 && passes < 255) {
			double xTemp = xCalc;
			xCalc = xUpdate(xTemp, yCalc, xCo);
			yCalc = yUpdate(xTemp, yCalc, yCo);
			passes++;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		}
		return passes;
	}
}
