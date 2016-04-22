package csata.jatek.harc;

import csata.jatek.HarcInterface;
import csata.jatek.Jatekos;
import csata.jatek.szereplo.Landzsas;

public class LandzsaLandzsa implements HarcInterface {
	@Override
	public Jatekos csataz(Jatekos jatekos1, Jatekos jatekos2) {
		System.out.println("Landzsas - Landzsas harc folyik");
		return jatekos2;
	}

	public Class getJatekosTipus1() {
		return Landzsas.class;
	}

	public Class getJatekosTipus2() {
		return Landzsas.class;
	}
}
