package csata.jatek.szereplo;
/**
 * 
 * Lovas reprezentalo osztaly.
 *
 */
public class Lovas extends AbstractJatekos {
	
	private Csatalo csatalo;

	public Lovas(String nev, Csatalo csatalo) {
		super(nev, csatalo.getSebesseg());
		this.csatalo = csatalo;
	}

	@Override
	public void lep() {
		mozog();
	}
	
	public String toString() {
		return "[lovas + " + csatalo.toString() + "] " + getNev();
	}

}
