package csata.jatek.harc;

import csata.jatek.HarcInterface;
import csata.jatek.Jatekos;
/**
 * 
 * B�rmilyen j�t�kos b�rmilyen j�t�kossal valo harcat reprezentalo osztaly.
 *
 */
public class BarmiBarmi implements HarcInterface {

	@Override
	public Class getJatekosTipus1() {
		return Jatekos.class;
	}

	@Override
	public Class getJatekosTipus2() {
		return Jatekos.class;
	}

	@Override
	public Jatekos csataz(Jatekos jatekos1, Jatekos jatekos2) {
		// veletlenszeru
		return jatekos1;
	}

}
