package csata.jatek.szereplo;

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
