package code;

public class MandelBrot implements FractalBase{
	
	double xTop = 0.6; 
	double xBot = -2.15; 
	double yTop = 1.3;
	double yBot = -1.3;
	double xCalc = xBot;
	double yCalc = yBot;
	double dist = Math.sqrt(Math.pow(xBot,2)+Math.pow(yBot,2));
	
	
	//Escape Time for Mandelbrot
	public int escapeTime(){
		int passes = 0; 
		while(dist <= 2 && passes < 255){
			double xTemp = xCalc;
			double yTemp = yCalc;
			xCalc = Math.pow(xTemp,2) + Math.pow(yTemp,2) + xTemp;
			yCalc = Math.pow(yTemp,2) + Math.pow(xTemp,2) + yTemp;
			dist = Math.sqrt(Math.pow(xCalc,2)+Math.pow(yCalc,2));
			passes++;
		}
		return passes;
	}

}
