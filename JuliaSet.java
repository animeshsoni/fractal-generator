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
	
	double xLow = -1.7;
	double xHigh = 1.7;
	double yLow = -1.0;
	double yHigh = 1.0;
	
	@Override
	public double xLow() {
		return xLow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xHigh()
	 */
	public double xHigh() {
		return xHigh;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yLow()
	 */
	@Override
	public double yLow() {
		return yLow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yHigh()
	 */
	public double yHigh() {
		return yHigh;
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
	
	@Override
	public void updateXLow(double a) {
		xLow = a;
		
	}

	@Override
	public void updateXHigh(double a) {
		xHigh = a;
		
	}

	@Override
	public void updateYLow(double a) {
		yLow = a;
		
	}

	@Override
	public void updateYHigh(double a) {
		yHigh = a;
		
	}

	@Override
	public void resetRange() {
		// TODO Auto-generated method stub
		xLow = -1.7;
		xHigh = 1.7;
		yLow = -1.0;
		yHigh = 1.0;
	}
}
