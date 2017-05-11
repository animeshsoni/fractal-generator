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
	
	double xLow = -1.8;
	double xHigh = -1.7;
	double yLow = -0.08;
	double yHigh = 0.025;
	
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
		xLow = -1.8;
		xHigh = -1.7;
		yLow = -0.08;
		yHigh = 0.025;
		
	}

}
