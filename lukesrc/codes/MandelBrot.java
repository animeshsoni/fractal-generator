package codes;

public class MandelBrot extends FractalBase{
	public double xLow(){
		return -2.15;
	}	

	public double xHigh(){
		return 0.6;
	}

	public double yLow(){
		return -1.3;
	}

	public double yHigh(){
		return 1.3;
	}

	public double xUpdate(double x, double y){
		return Math.pow(x,2)-Math.pow(y,2)+x;
	}

	public double yUpdate(double x, double y){
		return 2*x*y+y;
	}

	public double xDiff() {
		double retVal = xHigh()-xLow();
		return retVal;
	}

	public double yDiff() {
		double retVal = yHigh()-yLow();
		return retVal;
	}


}
