javac -d bin src\main\java\csata\jatek\*java src\main\java\csata\jatek\harc\*.java src\main\java\csata
\jatek\szereplo\*.java src\main\java\csata\main\Szimulal.java


jar cfve bin\csata.jar bin\csata\main\Szimulal.class bin\csata\jatek\harc\*.class bin\csata\jatek\szereplo\*.class bin\csata\jatek\*.class