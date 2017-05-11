package code;

import code.FractalBase;

/**
 * @author Luke, Animesh, Ashok
 *
 */
public class MultiBrot extends FractalBase {

	double xLow = -1.0;
	double xHigh = 1.0;
	double yLow = -1.3;
	double yHigh = 1.3;
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#xLow()
	 */
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
		return (x*x*x) - (3 * x * (y*y)) + xCo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see codes.FractalBase#yUpdate(double, double, double)
	 */
	@Override
	public double yUpdate(double x, double y, double yCo) {
		return (3 * x * x  * y) - (y*y*y) + yCo;
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
		xLow = -1.0;
		xHigh = 1.0;
		yLow = -1.3;
		yHigh = 1.3;
	}

}
