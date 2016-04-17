package csata.jatek.harc;

import csata.jatek.HarcInterface;
import csata.jatek.Jatekos;
import csata.jatek.szereplo.Tabor;

public class TaborBarmi implements HarcInterface {

	@Override
	public Class getJatekosTipus1() {
		return Tabor.class;
	}

	@Override
	public Class getJatekosTipus2() {
		return Jatekos.class;
	}

	@Override
	public Jatekos csataz(Jatekos tabor, Jatekos barmi) {
		// a tabor nem tud vedekezni
		return tabor;
	}

}
