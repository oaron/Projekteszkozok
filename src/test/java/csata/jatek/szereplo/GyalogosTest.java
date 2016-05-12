package csata.jatek.szereplo;

import org.junit.Assert;
import org.junit.Test;

import csata.jatek.Hadsereg;
import csata.jatek.Hadszinter;

public class GyalogosTest {

	@Test
	public void nevTeszt() {
		Gyalogos gyalogos = new Gyalogos("Béla");

		Assert.assertEquals("Béla", gyalogos.getNev());
	}
	
	@Test
	public void alapKoordinataTeszt() {
		Gyalogos gyalogos = new Gyalogos("Béla");
		Assert.assertEquals(0, gyalogos.getX());
		Assert.assertEquals(0, gyalogos.getY());
	}
	
	@Test
	public void beallitottKoordinataTeszt() {
		Gyalogos gyalogos = new Gyalogos("Béla");
		gyalogos.setCoordinates(5, 6);
		Assert.assertEquals(5, gyalogos.getX());
		Assert.assertEquals(6, gyalogos.getY());
	}
	
	@Test
	public void iranyTeszt() {
		Gyalogos gyalogos = new Gyalogos("Béla");
		Hadsereg hadsereg1 = new Hadsereg("Lannister");
		Hadsereg hadsereg2 = new Hadsereg("Stark");
		Hadszinter hadter = new Hadszinter(10, 10, hadsereg1, hadsereg2);
		
		gyalogos.fel();
		gyalogos.lep();

		Assert.assertEquals(1, gyalogos.getY());
	}
	
	
}
