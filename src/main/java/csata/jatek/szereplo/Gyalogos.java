package csata.jatek.szereplo;
/**
 * 
 * Gyalogost reprezentalo absztrakt osztaly.
 *
 */
public class Gyalogos extends AbstractJatekos {

	public Gyalogos(String nev) {
		super(nev, 1);
	}

	public String toString() {
		return "[Gyalogos] " + getNev();
	}

	@Override
	public void lep() {
		mozog();
	}
}
