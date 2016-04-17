package csata.main;

import csata.jatek.Hadsereg;
import csata.jatek.Hadszinter;
import csata.jatek.harc.BarmiBarmi;
import csata.jatek.harc.GyalogosGyalogos;
import csata.jatek.harc.GyalogosLandzsas;
import csata.jatek.harc.LandzsaLandzsa;
import csata.jatek.harc.LovasGyalogos;
import csata.jatek.harc.TaborBarmi;
import csata.jatek.szereplo.Ijasz;
import csata.jatek.szereplo.Katona;
import csata.jatek.szereplo.KonnyuCsatalo;
import csata.jatek.szereplo.Landzsas;
import csata.jatek.szereplo.Lovas;
import csata.jatek.szereplo.NehezCsatalo;
import csata.jatek.szereplo.Tabor;

public class Szimulal {

	public static void main(String[] args) {
		Hadsereg a = new Hadsereg("Fekete hadsereg");
		Hadsereg b = new Hadsereg("Voros hadsereg");
		Hadszinter hadszinter = new Hadszinter(10, 10, a, b);

		hadszinter.addHarctipus(new LovasGyalogos());
		hadszinter.addHarctipus(new LandzsaLandzsa());
		hadszinter.addHarctipus(new GyalogosLandzsas());
		hadszinter.addHarctipus(new GyalogosGyalogos());
		hadszinter.addHarctipus(new TaborBarmi());
		hadszinter.addHarctipus(new BarmiBarmi());
		
		

		// Fekete hadsereg
		
		Tabor tabor1 = new Tabor("Fekete Hadsereg alaptabora");
		hadszinter.berak(tabor1, 0, 3);
		
		Landzsas bela = new Landzsas("Bela");
		a.add(bela);
		hadszinter.berak(bela, 1, 1);
		bela.jobbra();

		Ijasz ijasz1 = new Ijasz("Ijasz 1", 5);
		a.add(ijasz1);
		hadszinter.berak(ijasz1, 1, 2);
		ijasz1.jobbra();

		Ijasz ijasz2 = new Ijasz("Ijasz 2", 5);
		a.add(ijasz2);
		hadszinter.berak(ijasz2, 1, 3);
		ijasz2.jobbra();

		Katona katona1 = new Katona("Józsi");
		a.add(katona1);
		hadszinter.berak(katona1, 2, 4);
		katona1.jobbra();
		
		Landzsas armand = new Landzsas("Armand");
		a.add(armand);
		hadszinter.berak(armand, 2, 5);
		armand.jobbra();
		
		
		// Voros hadsereg
		Tabor tabor2 = new Tabor("Voros Hadsereg alaptabora");
		hadszinter.berak(tabor2, 9, 4);
		
		Lovas sirArthur = new Lovas("Sir Galahad", new KonnyuCsatalo());
		b.add(sirArthur);
		hadszinter.berak(sirArthur, 8, 1);
		sirArthur.balra();
		
		Ijasz ijasz3 = new Ijasz("Ijasz 3", 20);
		b.add(ijasz3);
		hadszinter.berak(ijasz3, 8, 2);
		ijasz3.balra();

		Ijasz ijasz4 = new Ijasz("Ijasz 4", 20);
		b.add(ijasz4);
		hadszinter.berak(ijasz4, 8, 3);
		ijasz4.balra();

		Ijasz ijasz5 = new Ijasz("Ijasz 5", 20);
		b.add(ijasz5);
		hadszinter.berak(ijasz5, 8, 4);
		ijasz5.balra();
		
		Lovas sirGalahad = new Lovas("Sir Galahad", new NehezCsatalo());
		b.add(sirGalahad);
		hadszinter.berak(sirGalahad, 8, 5);
		sirGalahad.balra();
		

		Hadsereg gyoztes = hadszinter.jatekFuttatasa();
		System.out.println("A " + gyoztes.getNev() + " hadsereg nyert!");
	}
}
