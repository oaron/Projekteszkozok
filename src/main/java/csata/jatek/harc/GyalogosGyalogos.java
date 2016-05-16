package csata.jatek.harc;

import csata.jatek.HarcInterface;
import csata.jatek.Jatekos;
import csata.jatek.szereplo.Gyalogos;
/**
 * 
 * Gyalogos játékos gyalogos játékossal valo harcat reprezentalo osztaly.
 *
 */
public class GyalogosGyalogos implements HarcInterface {

	@Override
	public Class getJatekosTipus1() {
		return Gyalogos.class;
	}

	@Override
	public Class getJatekosTipus2() {
		return Gyalogos.class;
	}

	@Override
	public Jatekos csataz(Jatekos jatekos1, Jatekos jatekos2) {
		// veletlenszeru...
		return jatekos1;
	}

}
