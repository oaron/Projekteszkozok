package csata.jatek;

import java.util.ArrayList;

public class Hadszinter {
	private Jatekos mezo[][];
	private int tengerFelett[][];
	private int xmeret;
	private int ymeret;
	private ArrayList<HarcInterface> harcTipusok = new ArrayList<HarcInterface>();
	private ArrayList<Jatekos> szereplok = new ArrayList<Jatekos>();
	private Hadsereg hadsereg1, hadsereg2;

	public Hadszinter(int xmeret, int ymeret, Hadsereg hadsereg1,
			Hadsereg hadsereg2) {
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
	
	public void hegyCsinal(int x, int y, int a, int b, int tetopont) {
		// x y a kiindulo koordinata,a b a hegy nagysaga
		for (int i = x; i < (x + a); i++) {
			for (int j = y; j < (y + b); j++) {
				tengerFelett[i][j] = tetopont;
			}
		}
	}

	public void berak(Jatekos szereplo, int x, int y) {
		if (urese(x, y)) {
			mezo[x][y] = szereplo;
			szereplo.setCoordinates(x, y);
			szereplo.setHadszinter(this);
			szereplok.add(szereplo);
			System.out.println(szereplo.toString() + " felhelyezese a ("
					+ Integer.toString(x) + ", " + Integer.toString(y)
					+ ") koordinatara.");
		}
	}

	public void berak(Jatekos szereplo) {
		szereplo.setHadszinter(this);
		szereplok.add(szereplo);
		System.out.println(szereplo.toString()
				+ " bekerult a jatekba, de nincs a hadter felszinen.");
	}

	public boolean urese(int x, int y) {
		return mezo[x][y] == null;
	}

	public void kivesz(int x, int y) {
System.out.println("x: " + x + ", y: " + y);		
		if (x < 0 || x >= xmeret || y < 0 || y >= ymeret) {
			return;
		}
		Jatekos jatekos = mezo[x][y];
		if (jatekos != null) {
			System.out.println(jatekos.toString() + " eltavolitasa a ("
					+ Integer.toString(x) + ", " + Integer.toString(y)
					+ ") koordinatarol.");
			kivesz(jatekos);
		}
		mezo[x][y] = null;
	}

	public void kivesz(Jatekos szereplo) {
		// elemet nem torlunk a fociklus miatt
		int i = szereplok.indexOf(szereplo);
		szereplok.set(i,  null);
		Hadsereg hadsereg = szereplo.getHadsereg();
		if (hadsereg != null) {
			hadsereg.remove(szereplo);
		}
	}

	public void athelyez(Jatekos szereplo, int x, int y) {
		if (urese(x, y)) {
			System.out.println(szereplo.toString() + " áthelyezése: (" + szereplo.getX() + "," + szereplo.getY() + ") -> (" + x + "," + y + ")");
			mezo[szereplo.getX()][szereplo.getY()] = null;
			mezo[x][y] = szereplo;
			szereplo.setCoordinates(x, y);
		}
	}
	
	public Jatekos harcol(Jatekos jatekos1, Jatekos jatekos2) {
		Jatekos vesztes = null;
		for (HarcInterface harc : harcTipusok) {
			Class jatekosTipus1 = harc.getJatekosTipus1();
			Class jatekosTipus2 = harc.getJatekosTipus2();
			if (jatekosTipus1.isInstance(jatekos1)
					&& jatekosTipus2.isInstance(jatekos2)) {
				vesztes = harc.csataz(jatekos1, jatekos2);
				break;
			} else if (jatekosTipus1.isInstance(jatekos2)
					&& jatekosTipus2.isInstance(jatekos1)) {
				vesztes = harc.csataz(jatekos2, jatekos1);
				break;
			}
		}
		if (vesztes != null) {
			System.out.println("A csatat " + vesztes.toString()
					+ " elveszitette...");
			kivesz(vesztes.getX(), vesztes.getY());
		}
		return vesztes;
	}

	public Jatekos harcol(Jatekos jatekos, int x, int y) {
		return harcol(jatekos, mezo[x][y]);
	}
	
	public void addHarctipus(HarcInterface harcTipus) {
		harcTipusok.add(harcTipus);
	}

	public Hadsereg jatekFuttatasa() {
		while (!hadsereg1.urese() && !hadsereg2.urese()) {
			// iteratorral nem jarhatjuk be, mert kozben a lista modosulhat
			for (int i=0; i<szereplok.size(); i++) {
				Jatekos szereplo = szereplok.get(i);
				if (szereplo != null) {
					szereplo.lep();
				}
			}
		}
		return hadsereg1.urese() ? hadsereg2 : hadsereg1;
	}

	public boolean ellensege(int x, int y, Jatekos szereplo) {
		Jatekos masik = mezo[x][y];
		return masik != null && szereplo.getHadsereg() != masik.getHadsereg();
	}
}
