package csata.jatek.szereplo;

import org.junit.Assert;
import org.junit.Test;

public class KonnyuCsataloTest {

	@Test
	public void sebessegTeszt() {
		KonnyuCsatalo kcs = new KonnyuCsatalo();

		Assert.assertEquals(3, kcs.getSebesseg());
	}
	
	@Test 
	public void toStringTeszt(){
		KonnyuCsatalo kcs = new KonnyuCsatalo();
		Assert.assertEquals("konnyu csatalo", kcs.toString());
	}

}
