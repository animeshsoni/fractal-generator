package code;


/**
 * @author Animesh
 *
 */
public class BurningShip implements FractalBase {

	public BurningShip() {

	}

	@Override
	public double xLow() {
		// TODO Auto-generated method stub
		return -1.8;
	}

	@Override
	public double yLow() {
		// TODO Auto-generated method stub
		return -0.08;
	}

	@Override
	public double xUpdate(double x, double y) {
		// TODO Auto-generated method stub
		double xSq = x * x;
		double ySq = y * y;
		double retVal = xSq - ySq + x;
		return retVal;
	}

	@Override
	public double yUpdate(double x, double y) {
		// TODO Auto-generated method stub
		double retVal = (Math.abs(2 * x * y)) + y;
		return retVal;
	}

	@Override
	public double xDiff() {
		// TODO Auto-generated method stub
		double retVal = ((1.8 - 1.7) / 512);
		return retVal;
	}

	@Override
	public double yDiff() {
		// TODO Auto-generated method stub
		double retVal = ((0.08 + 0.025) / 512);
		return retVal;
	}

}
