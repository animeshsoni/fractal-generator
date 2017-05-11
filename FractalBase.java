package code;

/**
 * @author Luke, Animesh, Ashok
 *
 */

/**
 * @author Animesh
 *
 */
/**
 * @author Animesh
 *
 */
public abstract class FractalBase {
	/**
	 * Escape Distance
	 */
	private static int escDist = 2;
	/**
	 * Maximum Escape Time
	 */
	private static int maxEscTime = 255;
	/**
	 * @return Low x Value
	 */
	public abstract double xLow();

	
	/**
	 * @param a New x Low Value
	 */
	public abstract void updateXLow(double a);
	
	
	/**
	 * @return High x Value
	 */
	public abstract double xHigh();

	
	
	/**
	 * @param a New x High Value
	 */
	public abstract void updateXHigh(double a);
	
	/**
	 * @return Low y Value
	 */
	public abstract double yLow();

	
	/**
	 * @param a New y Low Value
	 */
	public abstract void updateYLow(double a);
	
	
	/**
	 * @return High y Value
	 */
	public abstract double yHigh();
	
	/**
	 * @param a New y High Value
	 */
	public abstract void updateYHigh(double a);

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
		double diff = xDiff() /511;
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
		double retVal = (yLow() + (c * diff));
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
		while (dist <= escDist &&  passes < maxEscTime) {
			double xTemp = xCalc;
			xCalc = xUpdate(xTemp, yCalc, xCo);
			yCalc = yUpdate(xTemp, yCalc, yCo);
			passes++;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			//System.out.println(xCalc + ", " + yCalc +", " + dist + ", " +passes);
		}
		return passes;
	}
	
	
	
	/**
	 * @param x The value to which we want to set the escape distance.
	 */
	public static void setEscDist(int x){
		escDist = x;
	}
	
	/**
	 * @param x The new escape time value
	 */
	public static void setEscTime(int x){
		maxEscTime = x;
	}
	
	/**
	 * Resets the x and y ranges
	 */
	public abstract void resetRange();
}
