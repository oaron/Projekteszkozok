package csata.jatek.szereplo;

import org.junit.Assert;
import org.junit.Test;

import csata.jatek.Hadsereg;
import csata.jatek.Hadszinter;

public class IjaszTest {

	@Test
	public void nevTeszt() {
		Ijasz ijasz = new Ijasz("Béla", 20);

		Assert.assertEquals("Béla", ijasz.getNev());
	}
	
	@Test
	public void alapKoordinataTeszt() {
		Ijasz ijasz = new Ijasz("Béla", 20);
		Assert.assertEquals(0, ijasz.getX());
		Assert.assertEquals(0, ijasz.getY());
	}
	
	@Test
	public void beallitottKoordinataTeszt() {
		Ijasz ijasz = new Ijasz("Béla", 20);
		ijasz.setCoordinates(5, 6);
		Assert.assertEquals(5, ijasz.getX());
		Assert.assertEquals(6, ijasz.getY());
	}
	
	@Test
	public void iranyTeszt() {
		Ijasz ijasz = new Ijasz("Béla", 20);
		Hadsereg hadsereg1 = new Hadsereg("Lannister");
		Hadsereg hadsereg2 = new Hadsereg("Stark");
		Hadszinter hadter = new Hadszinter(10, 10, hadsereg1, hadsereg2);
		
		ijasz.fel();
		ijasz.lep();

		Assert.assertEquals(1, ijasz.getY());
	}
	
	
}
