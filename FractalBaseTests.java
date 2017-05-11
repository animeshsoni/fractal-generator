package jUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import code.FractalBase;
import code.*;

/**
 * @author Luke, Animesh, Ashok
 *
 */
public class FractalBaseTests {

	@Test
	public void mandelBrotXTest() {
		FractalBase man = new MandelBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(-2.15, man.xCalc(0), 0.00001);
		assertEquals(-2.144618395, man.xCalc(1), 0.001);
		assertEquals(-1.61183953, man.xCalc(100), 0.001);
		assertEquals(.6, man.xCalc(511), 0.00001);
	}
  

	@Test
	public void juliaSetXTest() {
		FractalBase julia = new JuliaSet();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(-1.7, julia.xCalc(0), 0.00001);
		assertEquals(-1.034637965, julia.xCalc(100), 0.00001);
		assertEquals(1.7, julia.xCalc(511), 0.00001);
	}

	@Test
	public void burnShipXTest() {
		FractalBase ship = new BurningShip();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(-1.8, ship.xCalc(0), 0.00001);
		assertEquals(-1.780430528, ship.xCalc(100), 0.00001);
		assertEquals(-1.7, ship.xCalc(511), 0.00001);
	}

	@Test
	public void multiBrotXTest() {
		FractalBase multi = new MultiBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(-1.0, multi.xCalc(0), 0.00001);
		assertEquals(-.6086105675, multi.xCalc(100), 0.00001);
		assertEquals(1.0, multi.xCalc(511), 0.00001);
	}

	@Test
	public void mandelBrotYTest() {
		FractalBase man = new MandelBrot();
		FractalBase.setEscDist(2);FractalBase.setEscTime(255);
		assertEquals(-1.3, man.yCalc(0), 0.00001);
		assertEquals(-1.294921875, man.yCalc(1), 0.00001);
		assertEquals(-0.79119374, man.yCalc(100), 0.00001);
		assertEquals(1.3, man.yCalc(511), 0.00001);
	}

	@Test
	public void juliaSetYTest() {
		FractalBase julia = new JuliaSet();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(-1.0, julia.yCalc(0), 0.00001);
		assertEquals(-0.6086105675, julia.yCalc(100), 0.00001);
		assertEquals(1.0, julia.yCalc(511), 0.00001);
	}

	@Test
	public void burnShipYTest() {
		FractalBase ship = new BurningShip();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(-0.08, ship.yCalc(0), 0.00001);
		assertEquals(-0.05945205479, ship.yCalc(100), 0.00001);
		assertEquals(0.025, ship.yCalc(511), 0.0001);
	}

	@Test
	public void multiBrotYCalcTest() {
		FractalBase multi = new MultiBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(-1.3, multi.yCalc(0), 0.00001);
		assertEquals(-0.7911937377690802, multi.yCalc(100), 0.00001);
		assertEquals(1.3, multi.yCalc(511), 0.00001);
	}

	@Test
	public void mandelBrotEscTimeTest1() {
		FractalBase man = new MandelBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(255, man.calcEscapeTime(0.3207031250000001, -0.07109374999999386), 0.0000001);

	}

	@Test
	public void juliaSetEscTimeTest1() {
		FractalBase julia = new JuliaSet();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(255, julia.calcEscapeTime(1.0492187499999897, -0.234375));

	}

	@Test
	public void burnShipEscTimeTest1() {
		FractalBase ship = new BurningShip();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(255, ship.calcEscapeTime(-1.7443359374999874, -0.017451171875000338));
	}

	@Test
	public void multiBrotEscTimeTest1() {
		FractalBase multi = new MultiBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(255, multi.calcEscapeTime(0.5859375, 0.24375000000000108));

	}

	@Test
	public void mandelBrotEscTimeTest2() {
		FractalBase man = new MandelBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(1, man.calcEscapeTime(.5946289062500001, 1.2949218750000122), 0.0000001);
	}
	

	@Test
	public void juliaSetEscTimeTest2() {
		FractalBase julia = new JuliaSet();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(1, julia.calcEscapeTime(1.6933593749999853, 0.9765625));
	}
	
	@Test
	public void burnShipEscTimeTest2() {
		FractalBase ship = new BurningShip();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		int[][] result = ship.escapeTimes();
		boolean check = true;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				if (result[i][j] == 0 || result[i][j] == 0) {
					check = false;
				}
			}
		}
		assertTrue(check);
	}
	
	@Test
	public void multiBrotEscTimeTest2() {
		FractalBase multi = new MultiBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertEquals(1, multi.calcEscapeTime(0.9921875, 1.05625));
	}
	

	@Test
	public void mandelBrotResultTest() {
		FractalBase man = new MandelBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertTrue(man.escapeTimes() instanceof int[][]);
		assertEquals(512, man.escapeTimes().length);
		assertEquals(512, man.escapeTimes()[0].length);
	}

	@Test
	public void juliaSetResultTest() {
		FractalBase julia = new JuliaSet();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertTrue(julia.escapeTimes() instanceof int[][]);
		assertEquals(512, julia.escapeTimes().length);
		assertEquals(512, julia.escapeTimes()[0].length);
	}

	@Test
	public void burnShipResultTest() {
		FractalBase ship = new BurningShip();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertTrue(ship.escapeTimes() instanceof int[][]);
		assertEquals(512, ship.escapeTimes().length);
		assertEquals(512, ship.escapeTimes()[0].length);
	}

	@Test
	public void multiBrotResultTest() {
		FractalBase multi = new MultiBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(255);
		assertTrue(multi.escapeTimes() instanceof int[][]);
		assertEquals(512, multi.escapeTimes().length);
		assertEquals(512, multi.escapeTimes()[0].length);
	}
	@Test
	public void P2_burnShipEscTimeTest2() {
		FractalBase ship = new BurningShip();
		FractalBase.setEscDist(3);
		FractalBase.setEscTime(255);
		assertEquals(10, ship.calcEscapeTime(-1.6999999999999802,  0.0030136986301371603));
	}
	@Test
	public void P2_mandelBrotEscTimeTest2() {
		FractalBase man = new MandelBrot();
        FractalBase.setEscDist(3); 
        FractalBase.setEscTime(255);
		assertEquals(10, man.calcEscapeTime(0.46007827788650374, -0.3383561643835661), 0.0000001);
	}
	@Test
	public void P2_juliaSetEscTimeTest2() {
		FractalBase julia = new JuliaSet();
		FractalBase.setEscDist(3);
		FractalBase.setEscTime(255);
		assertEquals(10, julia.calcEscapeTime(1.4538160469667272,  -0.13502935420743645));
	}
	@Test
	public void P2_multiBrotEscTimeTest2() {
		FractalBase multi = new MultiBrot();
		FractalBase.setEscDist(3);
		FractalBase.setEscTime(255);
		assertEquals(10, multi.calcEscapeTime(0.7025440313111545, -0.5520547945205528));
	}
	@Test
	public void P3_burnShipEscTimeTest2() {
		FractalBase ship = new BurningShip();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(135);
		assertEquals(135, ship.calcEscapeTime(-1.7443359374999874, -0.017451171875000338));
	}
	@Test
	public void P3_mandelBrotEscTimeTest2() {
		FractalBase man = new MandelBrot();
        FractalBase.setEscDist(2); 
        FractalBase.setEscTime(135);
		assertEquals(135, man.calcEscapeTime(0.3207031250000001, -0.07109374999999386));
	}
	@Test
	public void P3_juliaSetEscTimeTest2() {
		FractalBase julia = new JuliaSet();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(135);
		assertEquals(135, julia.calcEscapeTime(1.0492187499999897, -0.234375));
	}
	@Test
	public void P3_multiBrotEscTimeTest2() {
		FractalBase multi = new MultiBrot();
		FractalBase.setEscDist(2);
		FractalBase.setEscTime(135);
		assertEquals(135, multi.calcEscapeTime(0.5859375, 0.24375000000000108));
	}
}
