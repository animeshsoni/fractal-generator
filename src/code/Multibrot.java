package code;

public class Multibrot implements FractalBase{
	
	double xTop = 1; 
	double xBot = -1; 
	double yTop = 1.3;
	double yBot = -1.3;
	double xCalc = xBot;
	double yCalc = yBot;
	double dist = Math.sqrt(Math.pow(xBot,2)+Math.pow(yBot,2));
	
	
	//Escape Time for Multibrot
	public int escapeTime(){
		int passes = 0; 
		while(dist <= 2 && passes < 255){
			double xTemp = xCalc;
			double yTemp = yCalc;
			//xCalc = Math.pow(xTemp,2) + Math.pow(yTemp,2) + xTemp;
			//yCalc = Math.pow(yTemp,2) + Math.pow(xTemp,2) + yTemp;
			dist = Math.sqrt(Math.pow(xCalc,2)+Math.pow(yCalc,2));
			passes++;
		}
		return passes;
	}
}
