package code;

import code.FractalBase;

/**
 * @author Luke, Animesh, Ashok
 *
 */
public class MultiBrot extends FractalBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xLow()
	 */
	@Override
	public double xLow() {
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xHigh()
	 */
	public double xHigh() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yLow()
	 */
	@Override
	public double yLow() {
		return -1.3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yHigh()
	 */
	public double yHigh() {
		return 1.3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xUpdate(double, double, double)
	 */
	@Override
	public double xUpdate(double x, double y, double xCo) {
		return Math.pow(x, 3) - (3 * x * Math.pow(y, 2)) + xCo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yUpdate(double, double, double)
	 */
	@Override
	public double yUpdate(double x, double y, double yCo) {
		return Math.abs(3 * Math.pow(x, 2) * y) - Math.pow(y, 3) + yCo;
	}

}
