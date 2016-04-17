package csata.jatek;

import java.util.ArrayList;

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

	public void add(Jatekos harcos) {
		csapat.add(harcos);
		harcos.setHadsereg(this);
	}

	public void remove(Jatekos harcos) {
		csapat.remove(harcos);
		harcos.setHadsereg(null);
	}

	public boolean urese() {
		return csapat.isEmpty();
	}

}
