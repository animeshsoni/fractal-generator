package codes;

public class MultiBrot extends FractalBase{

	@Override
	public double xLow(){
		return -1;
	}

	
	public double xHigh(){
		return 1;
	}

	@Override
	public double yLow(){
		return -1.3;
	}

	
	public double yHigh(){
		return 1.3;
	}

	@Override
	public double xUpdate(double x, double y){
		return Math.pow(x,3)-(3*x*Math.pow(y,2))+x;
	}

	@Override
	public double yUpdate(double x, double y){
		return Math.abs(3*Math.pow(x,2)*y)-Math.pow(y,3);
	}

	
}
