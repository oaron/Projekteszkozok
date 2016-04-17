package csata.jatek.harc;

import csata.jatek.HarcInterface;
import csata.jatek.Jatekos;
import csata.jatek.szereplo.Gyalogos;
import csata.jatek.szereplo.Landzsas;

public class GyalogosLandzsas implements HarcInterface {

	@Override
	public Class getJatekosTipus1() {
		return Gyalogos.class;
	}

	@Override
	public Class getJatekosTipus2() {
		return Landzsas.class;
	}

	@Override
	public Jatekos csataz(Jatekos gyalogos, Jatekos landzsas) {
		// a Landzsas a legerosebb a gyalogosok kozul, mindig o gyoz
		return gyalogos;
	}

}
