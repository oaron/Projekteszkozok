package csata.jatek;

import java.util.ArrayList;

/**
 * 
 * Hadszintert reprezentalo osztaly
 *
 */
public class Hadszinter {
	private Jatekos mezo[][];
	private int tengerFelett[][];
	private int xmeret;
	private int ymeret;
	private ArrayList<HarcInterface> harcTipusok = new ArrayList<HarcInterface>();
	private ArrayList<Jatekos> szereplok = new ArrayList<Jatekos>();
	private Hadsereg hadsereg1, hadsereg2;

	/**
	 * Hadszinter konstruktora.
	 * 
	 * @param xmeret
	 *            hadszinter x tengelyu kiterjedese
	 * @param ymeret
	 *            hadszinter y tengelyu kiterjedese
	 * @param hadsereg1
	 *            elso hadsereg
	 * @param hadsereg2
	 *            masodik hadsereg
	 */
	public Hadszinter(int xmeret, int ymeret, Hadsereg hadsereg1, Hadsereg hadsereg2) {
		this.xmeret = xmeret;
		this.ymeret = ymeret;
		this.hadsereg1 = hadsereg1;
		this.hadsereg2 = hadsereg2;
		mezo = new Jatekos[xmeret][ymeret];
		tengerFelett = new int[xmeret][ymeret];
		// feltoltese egy alap ertekkel
		for (int i = 0; i < xmeret; i++) {
			for (int j = 0; j < ymeret; j++) {
				tengerFelett[i][j] = 250;
			}
		}
	}

	public int getXmeret() {
		return xmeret;
	}

	public int getYmeret() {
		return ymeret;
	}

	public int getTengerFelett(Jatekos szereplo) {
		return tengerFelett[szereplo.getX()][szereplo.getY()];
	}

	/**
	 * Hegy keszitesert felelos fuggveny
	 * 
	 * @param x
	 *            x kiindulo koordinata
	 * @param y
	 *            y kiindulo koordinata
	 * @param a
	 *            x iranyban a hegy nagysaga
	 * @param b
	 *            y iranyban a hegy nagysaga
	 * @param tetopont
	 *            a hegy magassaga
	 */
	public void hegyCsinal(int x, int y, int a, int b, int tetopont) {
		for (int i = x; i < (x + a); i++) {
			for (int j = y; j < (y + b); j++) {
				tengerFelett[i][j] = tetopont;
			}
		}
	}

	/**
	 * Jatekosok felhelyezese a hadszinterre
	 * 
	 * @param szereplo
	 *            felhelyezni kivant jatekos
	 * @param x
	 *            helyenek x koordinátája
	 * @param y
	 *            helyenek y koordinataja
	 */
	public void berak(Jatekos szereplo, int x, int y) {
		if (urese(x, y)) {
			mezo[x][y] = szereplo;
			szereplo.setCoordinates(x, y);
			szereplo.setHadszinter(this);
			szereplok.add(szereplo);
			System.out.println(szereplo.toString() + " felhelyezese a (" + Integer.toString(x) + ", "
					+ Integer.toString(y) + ") koordinatara.");
		}
	}

	/**
	 * Jatekos felhelyezese a hadszinterre, pozicio megadasa nelkul.
	 * 
	 * @param szereplo
	 */
	public void berak(Jatekos szereplo) {
		szereplo.setHadszinter(this);
		szereplok.add(szereplo);
		System.out.println(szereplo.toString() + " bekerult a jatekba, de nincs a hadter felszinen.");
	}
	/**
	 * Az adott pozicion van-e jatekos.
	 * @param x x koordinata
	 * @param y y koordinata
	 * @return van-e a megadott pozicion jatekos.
	 */
	public boolean urese(int x, int y) {
		return mezo[x][y] == null;
	}
	/**
	 * Jatekos levetele a megadot kordinataju mezorol.
	 * @param x x koordinata
	 * @param y y koordinata
	 */
	public void kivesz(int x, int y) {
		System.out.println("x: " + x + ", y: " + y);
		if (x < 0 || x >= xmeret || y < 0 || y >= ymeret) {
			return;
		}
		Jatekos jatekos = mezo[x][y];
		if (jatekos != null) {
			System.out.println(jatekos.toString() + " eltavolitasa a (" + Integer.toString(x) + ", "
					+ Integer.toString(y) + ") koordinatarol.");
			kivesz(jatekos);
		}
		mezo[x][y] = null;
	}
	/**
	 * Megadott jatekost kivesszük a hadseregbol.
	 * @param szereplo jatekos
	 */
	public void kivesz(Jatekos szereplo) {
		// elemet nem torlunk a fociklus miatt
		int i = szereplok.indexOf(szereplo);
		szereplok.set(i, null);
		Hadsereg hadsereg = szereplo.getHadsereg();
		if (hadsereg != null) {
			hadsereg.remove(szereplo);
		}
	}

	/**
	 * Jatekos atelyezese a hadszinteren.
	 * @param szereplo jatekos
	 * @param x x koordinata
	 * @param y y koordinata
	 */
	public void athelyez(Jatekos szereplo, int x, int y) {
		if (urese(x, y)) {
			System.out.println(szereplo.toString() + " áthelyezése: (" + szereplo.getX() + "," + szereplo.getY()
					+ ") -> (" + x + "," + y + ")");
			mezo[szereplo.getX()][szereplo.getY()] = null;
			mezo[x][y] = szereplo;
			szereplo.setCoordinates(x, y);
		}
	}
	/**
	 * Ket jatekos harca.
	 * @param jatekos1 elso jatekos
	 * @param jatekos2 masodik jatekos
	 * @return veszto jatekos
	 */
	public Jatekos harcol(Jatekos jatekos1, Jatekos jatekos2) {
		Jatekos vesztes = null;
		for (HarcInterface harc : harcTipusok) {
			Class<?> jatekosTipus1 = harc.getJatekosTipus1();
			Class<?> jatekosTipus2 = harc.getJatekosTipus2();
			if (jatekosTipus1.isInstance(jatekos1) && jatekosTipus2.isInstance(jatekos2)) {
				vesztes = harc.csataz(jatekos1, jatekos2);
				break;
			} else if (jatekosTipus1.isInstance(jatekos2) && jatekosTipus2.isInstance(jatekos1)) {
				vesztes = harc.csataz(jatekos2, jatekos1);
				break;
			}
		}
		if (vesztes != null) {
			System.out.println("A csatat " + vesztes.toString() + " elveszitette...");
			kivesz(vesztes.getX(), vesztes.getY());
		}
		return vesztes;
	}
	/**
	 * Ket jatekos harca.
	 * @param jatekos1 elso jatekos
	 * @param jatekos2 masodik jatekos
	 * @return veszto jatekos
	 */
	public Jatekos harcol(Jatekos jatekos, int x, int y) {
		return harcol(jatekos, mezo[x][y]);
	}
	/**
	 * Harctipus hozzadasa
	 * @param harcTipus
	 */
	public void addHarctipus(HarcInterface harcTipus) {
		harcTipusok.add(harcTipus);
	}
	/**
	 * Jatek futtasa
	 * @return gyoztes csapat
	 */
	public Hadsereg jatekFuttatasa() {
		while (!hadsereg1.urese() && !hadsereg2.urese()) {
			// iteratorral nem jarhatjuk be, mert kozben a lista modosulhat
			for (int i = 0; i < szereplok.size(); i++) {
				Jatekos szereplo = szereplok.get(i);
				if (szereplo != null) {
					szereplo.lep();
				}
			}
		}
		return hadsereg1.urese() ? hadsereg2 : hadsereg1;
	}
	/**
	 * Ellenorzi ellensege a masik jatekos aki az adott mezon all.
	 * @param x x koordinata
	 * @param y y koordinata
	 * @param szereplo jatekos
	 * @return megegyezo seregben vannak-e
	 */
	public boolean ellensege(int x, int y, Jatekos szereplo) {
		Jatekos masik = mezo[x][y];
		return masik != null && szereplo.getHadsereg() != masik.getHadsereg();
	}
}
