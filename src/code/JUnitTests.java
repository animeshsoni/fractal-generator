package code;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTests {

	@Test
	public void burningShip1() {
		Pixel p1 = new Pixel(-1.7569432, 0.0249627);
		assertEquals(p1.x(), -1.7569432, 0.000001);
	}

	@Test
	public void burningShip2() {
		Pixel p1 = new Pixel(-1.7569432, 0.0249627);
		assertEquals(p1.y(), 0.0249627, 0.000001);
	}

	@Test
	public void burningShip3() {
		Pixel p1 = new Pixel(-1.7443359374999874, -0.017451171875000338);
		BurningShip frac1 = new BurningShip();
		Algorithm test = new Algorithm();
		assertEquals(test.escapeTime(p1, frac1), 2);
	}

	@Test
	public void burningShip4() {
		Pixel p1 = new Pixel(-1.8, -0.08);
		Pixel p2 = new Pixel(-1.7, 0.025);
		Pixel p3 = new Pixel(-1.6998046875, -0.07979492187);
		BurningShip frac1 = new BurningShip();
		Algorithm test = new Algorithm();
		assertTrue(test.escapeTime(p1, frac1) != 0);
		assertTrue(test.escapeTime(p1, frac1) != 1);
		assertTrue(test.escapeTime(p2, frac1) != 0);
		assertTrue(test.escapeTime(p2, frac1) != 1);
		assertTrue(test.escapeTime(p3, frac1) != 0);
		assertTrue(test.escapeTime(p3, frac1) != 1);
	}

	@Test
	public void burningShip5() {
		BurningShip frac1 = new BurningShip();
		Algorithm test = new Algorithm();
		assertTrue(test.result(frac1) instanceof int[][]);
	}
}
