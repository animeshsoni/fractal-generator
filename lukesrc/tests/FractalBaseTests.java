package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import codes.*;

public class FractalBaseTests {
	
	@Test
	public void mandelXCalcTest(){
		FractalBase man = new MandelBrot();
		assertEquals(-2.15, man.xCalc(0), 0.00001);
		assertEquals(.6, man.xCalc(511), 0.00001);
	}

	@Test
	public void mandelYCalcTest(){
		FractalBase man = new MandelBrot();
		assertEquals(-1.3, man.yCalc(0), 0.00001);
		assertEquals(1.3, man.yCalc(511),0.00001);
	}

	@Test
	public void mandelEscTimeTest(){
		FractalBase man = new MandelBrot();
		assertEquals(255, man.calcEscapeTime(.3207031250000001, -.07109374999999386), 0.0000001);
		assertEquals(1, man.calcEscapeTime(.5946289062500001, 1.2949218750000122), 0.0000001);
	}

	@Test
	public void mandelResultTest(){
		FractalBase man = new MandelBrot();
		assertEquals(512, man.escapeTimes().length);
		assertEquals(512, man.escapeTimes()[0].length);
	}
	
	@Test
	public void juliaXCalcTest(){
		
	}
	
	@Test
	public void juliaYCalcTest(){
		
	}
	
	@Test
	public void juliaEscTimeTest(){
		
	}
	
	@Test
	public void juliaResultTest(){
		
	}
	
	@Test
	public void shipXCalcTest(){
		
	}
	
	@Test
	public void shipYCalcTest(){
		
	}
	
	@Test
	public void shipEscTimeTest(){
		
	}
	
	@Test
	public void shipResultTest(){
		
	}
	
	@Test
	public void multiXCalcTest(){
		
	}
	
	@Test
	public void multiYCalcTest(){
		
	}
	
	@Test
	public void multiEscTimeTest(){
		
	}
	
	@Test
	public void multiResultTest(){
		
	}
}
