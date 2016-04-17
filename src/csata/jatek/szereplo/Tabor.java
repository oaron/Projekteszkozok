package csata.jatek.szereplo;


public class Tabor extends AbstractJatekos {

	public Tabor(String nev) {
		super(nev, 0);
	}

	@Override
	public void lep() {
		// a tabor nem csinal semmit.
	}
	
	public String toString() {
		return "[Tabor] " + getNev();
	}
}
