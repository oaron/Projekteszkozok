package csata.jatek.harc;

import csata.jatek.HarcInterface;
import csata.jatek.Jatekos;
import csata.jatek.szereplo.Landzsas;
/**
 * 
 * L�ndzs�s j�t�kos l�ndzs�s j�t�kossal valo harcat reprezentalo osztaly.
 *
 */
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
