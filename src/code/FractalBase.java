package code;

public interface FractalBase {

	/**
	 * @return the lowest x value from the range of the fractal
	 */
	public double xLow();

	/**
	 * @return the lowest y value from the range of the fractal
	 */
	public double yLow();

	/**
	 * @param x
	 *            current xCalc value during the runtime of escape-time
	 *            algorithm
	 * @param y
	 *            current yCalc value during the runtime of escape-time
	 *            algorithm
	 * @return the updated xCalc value
	 */
	public double xUpdate(double x, double y);

	/**
	 * @param x
	 *            current xCalc value during the runtime of escape-time
	 *            algorithm
	 * @param y
	 *            current yCalc value during the runtime of escape-time
	 *            algorithm
	 * @return the updated yCalc value
	 */
	public double yUpdate(double x, double y);

	/**
	 * @return the difference between each x value for the specific fractal
	 *         (range/512)
	 */
	public double xDiff();

	/**
	 * @return the difference between each y value for each fractal (range/512)
	 */
	public double yDiff();

}
