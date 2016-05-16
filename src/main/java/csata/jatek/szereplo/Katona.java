package csata.jatek.szereplo;
/**
 * 
 * Katonat reprezentalo osztaly.
 *
 */
public class Katona extends Gyalogos {

	public Katona(String nev) {
		super(nev);
	}

	public String toString() {
		return "[katona] " + getNev();
	}
}
