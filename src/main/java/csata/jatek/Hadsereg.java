package csata.jatek;

import java.util.ArrayList;
/**
 * Hadsereget reprezentalo osztaly.
 */

public class Hadsereg {
	private String nev;
	private ArrayList<Jatekos> csapat = new ArrayList<Jatekos>();

	public Hadsereg(String nev) {
		this.nev = nev;
	}

	public String getNev() {
		return nev;
	}
	
	public String toString() {
		return nev + "[" + csapat.size() + "]";
	}
	/**
	 * Jatekos adhatunk hozza a csapatunkhoz.
	 * 
	 * @param harcos a csapathoz hozzaadni kivant jatekos
	 */
	public void add(Jatekos harcos) {
		csapat.add(harcos);
		harcos.setHadsereg(this);
	}
	/**
	 * Jatekost vehetunk ki a csapatbol.
	 * 
	 * @param harcos a csapatbol torolni kivant jatekos
	 */
	public void remove(Jatekos harcos) {
		csapat.remove(harcos);
		harcos.setHadsereg(null);
	}
	/**
	 * 
	 * @return  ures-e a csapat.
	 */
	public boolean urese() {
		return csapat.isEmpty();
	}

}
