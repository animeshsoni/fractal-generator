package code;

/**
 * @author Animesh
 *
 */
public class Algorithm {
	public Algorithm() {

	}
	/*
	 * public static void main(String[] args){ Pixel p = new
	 * Pixel(-1.7443359374999874, -0.017451171875000338); BurningShip frac = new
	 * BurningShip(); Algorithm a = new Algorithm();
	 * System.out.print(a.escapeTime(p, frac)); }
	 */

	/**
	 * @param fractal
	 *            One of the 4 fractal types for which we need to calculate the
	 *            result
	 * @return the 2d array(int) with escape times of all the pixels in the
	 *         range
	 */
	public int[][] result(FractalBase fractal) {
		// assignment statement: FractalBase Object to the specified
		// FractalObject

		int[][] retVal = new int[512][512];

		Pixel[][] array = pixelArray(fractal);

		for (int i = 0; i < 512; i++) {
			for (int j = 0; i < 512; i++) {

				/*
				 * xCalc = array[i][j].x(); yCalc = array[i][j].y(); double dist
				 * = distance(xCalc, yCalc); int passes = 0;
				 * 
				 * while (dist <= 2 && passes < 255) { xCalc =
				 * frac.xUpdate(xCalc, yCalc); yCalc = frac.yUpdate(xCalc,
				 * yCalc); passes++; dist = distance(xCalc, yCalc); }
				 */
				retVal[i][j] = escapeTime(array[i][j], fractal);

			}

		}
		return retVal;
	}

	/**
	 * @param p
	 *            The pixel for which we need to calculate the escape time
	 * @param fractal
	 *            One of the 4 fractal types for which we need to calculate the
	 *            escape-time
	 * @return
	 */
	public int escapeTime(Pixel p, FractalBase fractal) {
		double xCalc = p.x();
		double yCalc = p.y();
		double dist = distance(xCalc, yCalc);
		int passes = 0;

		while (dist <= 2 && passes < 255) {
			xCalc = fractal.xUpdate(xCalc, yCalc);
			yCalc = fractal.yUpdate(xCalc, yCalc);
			passes++;
			dist = distance(xCalc, yCalc);
		}
		return passes;
	}

	/**
	 * @param x
	 *            The x coordinate for the point
	 * @param y
	 *            The y coordinate for the point
	 * @return The distance from thr origin to the point (x,y)
	 */
	public double distance(double x, double y) {
		double xSq = x * x;
		double ySq = y * y;
		double retVal = Math.sqrt(xSq + ySq);
		return retVal;
	}

	/**
	 * @param fractal
	 *            One of the 4 fractal types for which we need to calculate the
	 *            escape-time
	 * @return A 2d array with all the points in the range of the fractal for
	 *         which we need to calculate the escape-time
	 */
	public Pixel[][] pixelArray(FractalBase fractal) {

		double x = fractal.xLow();
		double y = fractal.yLow();
		Pixel[][] pixels = new Pixel[512][512];
		for (int i = 0; i < 512; i++) {
			for (int j = 0; j < 512; j++) {
				pixels[i][j] = new Pixel(x, y);
				y = y + fractal.yDiff();
			}
			x = x + fractal.xDiff();
		}
		return pixels;
	}
	/*
	 * public double xVal(Pixel p){ return p.x; } public double yVal(Pixel p){
	 * return p.y; }
	 */
}
