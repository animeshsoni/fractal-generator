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
	double xLow = -2.15;
	double xHigh = 0.6;
	double yLow = -1.3;
	double yHigh = 1.3;
	
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
		xLow = -2.15;
		xHigh = 0.6;
		yLow = -1.3;
		yHigh = 1.3;
		
	}

}
