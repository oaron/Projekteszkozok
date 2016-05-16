package csata.jatek.szereplo;
/**
 * 
 * Landzsast reprezentalo osztaly.
 *
 */
public class Landzsas extends Gyalogos {
	
	public Landzsas(String nev) {
		super(nev);
	}

	@Override
	public String toString() {
		return "[landzsas] " + getNev();
	}
}
