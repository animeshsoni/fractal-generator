package code;

import code.FractalBase;

/**
 * @author Luke, Animesh, Ashok
 *
 */
public class JuliaSet extends FractalBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xLow()
	 */
	@Override
	public double xLow() {
		return -1.7;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xHigh()
	 */
	public double xHigh() {
		return 1.7;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yLow()
	 */
	@Override
	public double yLow() {
		return -1.0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yHigh()
	 */
	public double yHigh() {
		return 1.0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xUpdate(double, double, double)
	 */
	@Override
	public double xUpdate(double x, double y, double xCo) {
		return Math.pow(x, 2) - Math.pow(y, 2) + (-0.72689);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yUpdate(double, double, double)
	 */
	@Override
	public double yUpdate(double x, double y, double yCo) {
		return 2 * x * y + 0.18887;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xDiff()
	 */
	@Override
	public double xDiff() {
		double retVal = xHigh() - xLow();
		return retVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yDiff()
	 */
	@Override
	public double yDiff() {
		double retVal = yHigh() - yLow();
		return retVal;
	}
}
