package csata.jatek.szereplo;

import csata.jatek.Hadsereg;
import csata.jatek.Hadszinter;
import csata.jatek.Jatekos;

public class Nyil implements Jatekos {
	private Hadszinter hadszinter;
	private int hanyszor;
	private int celX;
	private int celY;

	public Nyil(int celX, int celY, int hanyszor) {
		this.celX = celX;
		this.celY = celY;
		this.hanyszor = hanyszor;
	}

	public void setHadszinter(Hadszinter hadszinter) {
		this.hadszinter = hadszinter;
	}
	
	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}

	public int mennyiVanVissza() {
		return hanyszor;
	}

	public void setCoordinates(int x, int y) {
	}

	public String getNev() {
		return "egy repulo nyil";
	}
	
	public String toString() {
		return getNev();
	}

	public void lep() {
		if (hanyszor > 0) {
			hanyszor--;
		} else {
			System.out.println("Egy nyil celba ert!");
			hadszinter.kivesz(celX, celY);
			hadszinter.kivesz(this);
		}
	}

	@Override
	public Hadsereg getHadsereg() {
		return null;
	}

	@Override
	public void setHadsereg(Hadsereg hadsereg) {
	}
}
