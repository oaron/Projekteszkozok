package csata.jatek.szereplo;

import org.junit.Assert;
import org.junit.Test;

import csata.jatek.Hadsereg;
import csata.jatek.Hadszinter;

public class KatonaTest {

	@Test
	public void nevTeszt() {
		Katona katona = new Katona("Béla");

		Assert.assertEquals("Béla", katona.getNev());
	}
	
	@Test
	public void alapKoordinataTeszt() {
		Katona katona = new Katona("Béla");
		Assert.assertEquals(0, katona.getX());
		Assert.assertEquals(0, katona.getY());
	}
	
	@Test
	public void beallitottKoordinataTeszt() {
		Katona katona = new Katona("Béla");
		katona.setCoordinates(5, 6);
		Assert.assertEquals(5, katona.getX());
		Assert.assertEquals(6, katona.getY());
	}
	
	@Test
	public void iranyTeszt() {
		Katona katona = new Katona("Béla");
		Hadsereg hadsereg1 = new Hadsereg("Lannister");
		Hadsereg hadsereg2 = new Hadsereg("Stark");
		Hadszinter hadter = new Hadszinter(10, 10, hadsereg1, hadsereg2);
		katona.setHadsereg(hadsereg2);
		katona.setHadszinter(hadter);
		katona.jobbra();
		katona.lep();

		Assert.assertEquals(1, katona.getX());
	}
	
	
}
