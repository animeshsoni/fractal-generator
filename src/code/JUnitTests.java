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
		
		BurningShip frac1 = new BurningShip();
		Algorithm test = new Algorithm();
		int[][] array = test.result(frac1);
		boolean check = true;
		for(int i = 0; i < 512; i++){
			for (int j = 0; j<512; j++){
				if((array[i][j]==0) || array[i][j]==1){
					check = false;
				}
			}
		}
		assertTrue(check);
	}

	@Test
	public void burningShip5() {
		BurningShip frac1 = new BurningShip();
		Algorithm test = new Algorithm();
		int [][] array = test.result(frac1);
		assertTrue((array) instanceof int[][]);
		assertEquals(array.length,512);
		assertEquals(array[0].length, 512);
	}
}
