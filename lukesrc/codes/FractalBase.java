package codes;

public abstract class FractalBase {
		//Low x Value
		public abstract double xLow();
		
		//High x Value
		public abstract double xHigh();
		
		//Low y Value
		public abstract double yLow();
		
		//High y Value
		public abstract double yHigh();	
		
		//Updates the current position of x
		public abstract double xUpdate(double x, double y);
		
		//Updates the current position of y
		public abstract double yUpdate(double x, double y);
		
		//Takes in Array Index returns x Coordinate Value
		public double xCalc(int r){
			return (r)*xDiff() + xLow();
		}

		//Takes in Array Index returns y Coordinate Value
		public double yCalc(int c){
			return yHigh() - (c)*yDiff();
		}

		//x Range
		public double xDiff(){
			return xHigh()-xLow();
		}
		
		//y Domain
		public double yDiff(){
			return xHigh()-xLow();
		}

		public int[][] escapeTimes(){
			
			int[][] retVal = new int[512][512];
			for(int r = 0; r < retVal.length; r++){
				for(int c = 0; c < retVal[0].length; c++){
					retVal[r][c] = calcEscapeTime(xCalc(r),yCalc(c));
				}
			}
			return retVal;
		}

		public int calcEscapeTime(double x, double y){
			double xCalc = x;
			double yCalc = y;
			double dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
			int passes = 0;
			while(dist <= 2 && passes < 255){
				double xTemp = xCalc;
				xCalc = xUpdate(xTemp, yCalc);
				yCalc = yUpdate(xTemp, yCalc);
				passes++;
				dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
			}
			return passes;
		}
}
