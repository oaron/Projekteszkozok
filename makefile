all:
	javac -d bin -encoding latin2 src/main/java/csata/jatek/*.java src/main/java/csata/jatek/harc/*.java src/main/java/csata/jatek/szereplo/*.java src/main/java/csata/main/*.java
	cd bin && jar cfve csata.jar csata.main.Szimulal csata/main/Szimulal.class csata/jatek/harc/*.class csata/jatek/szereplo/*.class csata/jatek/*.class
