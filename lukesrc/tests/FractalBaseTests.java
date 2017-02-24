package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import codes.*;

public class FractalBaseTests {
	
	@Test
	public void mandelXCalcTest(){
		FractalBase man = new MandelBrot();
		assertEquals(-2.15, man.xCalc(0), 0.00001);
		assertEquals(-2.144618395, man.xCalc(1), 0.001);
		assertEquals(-1.61183953, man.xCalc(100), 0.001);
		assertEquals(.6, man.xCalc(511), 0.00001);
	}

	@Test
	public void mandelYCalcTest(){
		FractalBase man = new MandelBrot();
		assertEquals(1.3, man.yCalc(0), 0.00001);
		assertEquals(1.294921875, man.yCalc(1),0.00001);
		assertEquals(.79119374, man.yCalc(100), 0.00001);
		assertEquals(-1.3, man.yCalc(511),0.00001);
	}

	@Test
	public void mandelEscTimeTest(){
		FractalBase man = new MandelBrot();
		assertEquals(255, man.calcEscapeTime(0.3207031250000001, -0.07109374999999386), 0.0000001);
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
		FractalBase julia = new JuliaSet();
		assertEquals(-1.7, julia.xCalc(0), 0.00001);
		assertEquals(-1.034637965, julia.xCalc(100), 0.00001);
		assertEquals(1.7, julia.xCalc(511), 0.00001);
	}
	
	@Test
	public void juliaYCalcTest(){
		FractalBase julia = new JuliaSet();
		assertEquals(1.0, julia.yCalc(0), 0.00001);
		assertEquals(.6086105675, julia.yCalc(100), 0.00001);
		assertEquals(-1.0, julia.yCalc(511), 0.00001);
	}
	
	@Test
	public void juliaEscTimeTest(){
		FractalBase julia = new JuliaSet();
		assertEquals(255, julia.calcEscapeTime(1.0492187499999897, -0.234375));
		assertEquals(1, julia.calcEscapeTime(1.6933593749999853, 0.9765625));
	}
	
	@Test
	public void juliaEscTimeTest2(){
		FractalBase julia = new JuliaSet();
		assertEquals(1, julia.calcEscapeTime(1.6933593749999853, 0.9765625));
	}
	
	@Test
	public void juliaResultTest(){
		FractalBase julia = new JuliaSet();
		assertEquals(512, julia.escapeTimes().length);
		assertEquals(512, julia.escapeTimes()[0].length);
	}
	
	@Test
	public void shipXCalcTest(){
		FractalBase ship = new BurningShip();
		assertEquals(-1.8, ship.xCalc(0), 0.00001);
		assertEquals(-1.780430528, ship.xCalc(100), 0.00001);
		assertEquals(-1.7, ship.xCalc(511), 0.00001);
	}
	
	@Test
	public void shipYCalcTest(){
		FractalBase ship = new BurningShip();
		assertEquals(0.025, ship.yCalc(0), 0.00001);
		assertEquals(.0044520548, ship.yCalc(100), 0.00001);
		assertEquals(-.08, ship.yCalc(511), 0.0001);
	}
	
	@Test
	public void shipEscTimeTest(){
		FractalBase ship = new BurningShip();
		assertEquals(255, ship.calcEscapeTime(-1.7443359374999874, -0.017451171875000338));
	}
	
	@Test
	public void shipResultTest(){
		FractalBase ship = new BurningShip();
		assertEquals(512, ship.escapeTimes().length);
		assertEquals(512, ship.escapeTimes()[0].length);
	}
	
	@Test
	public void multiXCalcTest(){
		FractalBase multi = new MultiBrot();
		assertEquals(-1.0, multi.xCalc(0), 0.00001);
		assertEquals(-.6086105675, multi.xCalc(100), 0.00001);
		assertEquals(1.0, multi.xCalc(511), 0.00001);
	}
	
	@Test
	public void multiYCalcTest(){
		FractalBase multi = new MultiBrot();
		assertEquals(1.3, multi.yCalc(0), 0.00001);
		assertEquals(.7911937378, multi.yCalc(100), 0.00001);
		assertEquals(-1.3, multi.yCalc(511), 0.00001);
	}
	
	@Test
	public void multiEscTimeTest(){
		FractalBase multi = new MultiBrot();
		assertEquals(255, multi.calcEscapeTime(0.5859375, 0.24375000000000108));
		assertEquals(1, multi.calcEscapeTime(0.9921875, 1.05625));
	}
	
	@Test
	public void multiResultTest(){
		FractalBase multi = new MultiBrot();
		assertEquals(512, multi.escapeTimes().length);
		assertEquals(512, multi.escapeTimes()[0].length);
	}
}
