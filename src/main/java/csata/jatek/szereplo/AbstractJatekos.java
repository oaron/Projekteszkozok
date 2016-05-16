package csata.jatek.szereplo;

import csata.jatek.Hadsereg;
import csata.jatek.Hadszinter;
import csata.jatek.Jatekos;
/**
 * 
 * Absztrakt jatekos.
 *
 */
public abstract class AbstractJatekos implements Jatekos {
	private Hadszinter hadszinter;
	private Hadsereg hadsereg;
	private int coordX;
	private int coordY;
	private String nev;
	private int irany;
	private int sebesseg;
	protected int[] iranyKomponensX = {0, 1, 0, -1}; // fel, jobbra, le, balra 
	protected int[] iranyKomponensY = {1, 0, -1, 0}; // fel, jobbra, le, balra 
	

	public AbstractJatekos(String nev, int sebesseg) {
		this.nev = nev;
		this.sebesseg = sebesseg;
	}
	
	public int getIrany() {
		return irany;
	}
	
	public void fel() {
		irany = 0;
	}
	
	public void jobbra() {
		irany = 1;
	}
	
	public void le() {
		irany = 2;
	}
	
	public void balra() {
		irany = 3;
	}
	
	public void setHadszinter(Hadszinter hadszinter) {
		this.hadszinter = hadszinter;
	}
	
	public Hadszinter getHadszinter() {
		return this.hadszinter;
	}
	
	public int getX() {
		return coordX;
	}

	public int getY() {
		return coordY;
	}

	public void setCoordinates(int x, int y) {
		coordX = x;
		coordY = y;
	}

	public String getNev() {
		return nev;
	}

	public Hadsereg getHadsereg() {
		return hadsereg;
	}

	public void setHadsereg(Hadsereg hadsereg) {
		this.hadsereg = hadsereg;
	}
	/**
	 * Adott iranyba lepes
	 * @param relativIrany amelyik iranyba szeretne lepni
	 * @return tudott-e az adott iranyba lepni
	 */
	protected boolean lepIranyba(int relativIrany) {
		int effektivIrany = (irany + relativIrany) % 3; // modulo, 2 biten taroljuk az iranyt és korbefordul
		
		int ujX = coordX + iranyKomponensX[effektivIrany] * sebesseg;
		int ujY = coordY + iranyKomponensY[effektivIrany] * sebesseg;
		
		if (ujX < 0 || ujX >= hadszinter.getXmeret()) {
			return false;
		}
		if (ujY < 0 || ujY >= hadszinter.getYmeret()) {
			return false;
		}
		
		if (hadszinter.urese(ujX, ujY)) {
			hadszinter.athelyez(this, ujX, ujY);
			return true;
		} else if (hadszinter.ellensege(ujX, ujY, this)) {
			Jatekos vesztes = hadszinter.harcol(this, ujX, ujY);
			if (vesztes != null && vesztes != this) {
				hadszinter.athelyez(this, ujX, ujY);
				return true;
			}
		}
		return false;
	}
	/**
	 * Amelyik iranyba tudjuk, mozgatjuk a jatekost.
	 */
	protected void mozog() {
		// megprobalunk elore lepni sebességnyit
		if (lepIranyba(0)) {
			return;
		}
		// balra kiteres
		if (lepIranyba(3)) {
			return;
		}
		// valamerre
		int fordulas = 1 + (int) (Math.random()*3); // 1..3
		irany = (irany + fordulas ) % 3;
	}
}
