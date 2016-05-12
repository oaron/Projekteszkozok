package csata.jatek.szereplo;


import org.junit.Assert;
import org.junit.Test;

public class NyilTest {

	@Test
	public void test() {
		Nyil nyil = new Nyil(5, 6, 10);
		
		Assert.assertEquals(10, nyil.mennyiVanVissza());
	}
	
	

}
