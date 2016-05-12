package csata.jatek.szereplo;

import org.junit.Assert;
import org.junit.Test;


public class LovasTest {

	@Test
	public void test() {
		Csatalo csatalo = new KonnyuCsatalo();
		Lovas lovas = new Lovas("B�la", csatalo);
		
		Assert.assertEquals("[lovas + konnyu csatalo] B�la", lovas.toString());
	}

}
