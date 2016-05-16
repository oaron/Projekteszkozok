package csata.jatek.harc;

import csata.jatek.HarcInterface;
import csata.jatek.Jatekos;
import csata.jatek.szereplo.Gyalogos;
import csata.jatek.szereplo.Lovas;
/**
 * 
 * Lovas játékos gyalogos játékossal valo harcat reprezentalo osztaly.
 *
 */
public class LovasGyalogos implements HarcInterface {

	@Override
	public Class getJatekosTipus1() {
		return Lovas.class;
	}

	@Override
	public Class getJatekosTipus2() {
		return Gyalogos.class;
	}

	@Override
	public Jatekos csataz(Jatekos lovas, Jatekos gyalogos) {
		// mindig a gyalogos veszit a loval szemben
		return gyalogos;
	}

}
