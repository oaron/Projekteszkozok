package csata.jatek.szereplo;

public class Ijasz extends Gyalogos {

	private int nyilakSzama;

	public Ijasz(String nev, int nyilakSzama) {
		super(nev);
		this.nyilakSzama = nyilakSzama;
	}

	@Override
	public String toString() {
		return "[ijasz] " + getNev();
	}

	@Override
	public void lep() {
		if (nyilakSzama > 0) {
			// ha van, kilovunk egy nyilat
			int tavolsag = getHadszinter().getTengerFelett(this) / 100;
			int celX = getX() + iranyKomponensX[getIrany()] * tavolsag;
			int celY = getY() + iranyKomponensY[getIrany()] * tavolsag;
			Nyil nyil = new Nyil(celX, celY, tavolsag);
			getHadszinter().berak(nyil);
			nyilakSzama--;
		} else {
			// ha mar nincs nyil, akkor halad es kozelharcot folytat
			mozog();
		}
	}

}
