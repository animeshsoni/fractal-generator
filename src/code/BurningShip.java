package code;

import code.FractalBase;

/**
 * @author Luke, Animesh, Ashok
 *
 */
public class BurningShip extends FractalBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xLow()
	 */
	public double xLow() {
		return -1.8;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xHigh()
	 */
	public double xHigh() {
		return -1.7;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yLow()
	 */
	@Override
	public double yLow() {
		return -0.08;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yHigh()
	 */
	public double yHigh() {
		return 0.025;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xUpdate(double, double, double)
	 */
	@Override
	public double xUpdate(double x, double y, double xCo) {
		return Math.pow(x, 2) - Math.pow(y, 2) + xCo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yUpdate(double, double, double)
	 */
	@Override
	public double yUpdate(double x, double y, double yCo) {
		return Math.abs(2 * x * y) + yCo;
	}

}
