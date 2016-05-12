package csata.jatek.szereplo;

import org.junit.Assert;
import org.junit.Test;


public class LovasTest {

	@Test
	public void test() {
		Csatalo csatalo = new KonnyuCsatalo();
		Lovas lovas = new Lovas("Béla", csatalo);
		
		Assert.assertEquals("[lovas + konnyu csatalo] Béla", lovas.toString());
	}

}
