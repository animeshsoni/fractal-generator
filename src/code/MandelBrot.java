package code;

import code.FractalBase;

/**
 * @author Luke, Animesh, Ashok
 *
 */
public class MandelBrot extends FractalBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xLow()
	 */
	public double xLow() {
		return -2.15;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xHigh()
	 */
	public double xHigh() {
		return 0.6;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yLow()
	 */
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
	public double xUpdate(double x, double y, double xCo) {
		return Math.pow(x, 2) - Math.pow(y, 2) + xCo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yUpdate(double, double, double)
	 */
	public double yUpdate(double x, double y, double yCo) {
		return 2 * x * y + yCo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xDiff()
	 */
	public double xDiff() {
		double retVal = xHigh() - xLow();
		return retVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yDiff()
	 */
	public double yDiff() {
		double retVal = yHigh() - yLow();
		return retVal;
	}

}
