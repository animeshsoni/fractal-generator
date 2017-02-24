/*package code;

*//**
 * @author Luke Bulatowicz
 *
 *//*
public class JuliaSet implements FractalBase {

	@Override
	public double xLow() {
		// TODO Auto-generated method stub
		return -1.7;
	}

	@Override
	public double yLow() {
		// TODO Auto-generated method stub
		return -1.0;
	}
	
	public double xHigh(){
		return 1.7;
	}
	
	
	public double yHigh(){
		return 1.0;
	}
	
	//Updates the current x value
	@Override
	public double xUpdate(double x, double y) {
		// TODO Auto-generated method stub
		double retVal = Math.pow(x, 2)-Math.pow(y, 2)+(-0.72689);
		return retVal;
	}
	
	//Updates the current y value
	@Override
	public double yUpdate(double x, double y) {
		// TODO Auto-generated method stub
		double retVal = 2*x*y+0.188887;
		return retVal;
	}
	
	//Finds the range of x
	@Override
	public double xDiff() {
		// TODO Auto-generated method stub
		double retVal = xHigh() - xLow();
		return retVal;
	}
	
	//Finds the range of y 
	@Override
	public double yDiff() {
		// TODO Auto-generated method stub
		double retVal = yHigh() - yLow();
		return retVal;
	}

}
*/