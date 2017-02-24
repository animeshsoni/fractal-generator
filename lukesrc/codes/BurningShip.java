package codes;

public class BurningShip extends FractalBase{
	
	public double xLow(){
		return -1.8;
	}

	
	public double xHigh(){
		return -1.7;
	}

	@Override
	public double yLow(){
		return -0.08;
	}

	
	public double yHigh(){
		return 0.025;
	}

	@Override
	public double xUpdate(double x, double y){
		return Math.pow(x,2)-Math.pow(y,2)+x;
	}

	@Override
	public double yUpdate(double x, double y){
		return Math.abs(2*x*y)+y;
	}

}
