package codes;

public class JuliaSet extends FractalBase{
	
	@Override
	public double xLow(){
		return -1.7;
	}

	public double xHigh(){
		return 1.7;
	}

	@Override
	public double yLow(){
		return -1.0;
	}

	public double yHigh(){
		return 1.0;
	}

	@Override
	public double xUpdate(double x, double y){
		return Math.pow(x,2)-Math.pow(y,2)+(-0.72689);
	}

	@Override
	public double yUpdate(double x, double y){
		return 2*x*y+0.18887;
	}

	@Override
	public double xDiff() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double yDiff() {
		// TODO Auto-generated method stub
		return 0;
	}
}
