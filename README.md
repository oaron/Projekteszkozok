# Projekteszközök
Elte IK Projekteszközök 2016


## Középkori csata 
 Feladat: Egy középkori csata szimulálása. Szereplői lándzsás, íjász, lovas (nehéz és könnyű). A harcosok egy-egy hadseregbe tartoznak, a cél hogy valamelyik hadsereg legyőzze a másikat. 
A program beépített adatokkal dolgozik. A különböző feladatok könnyen bővíthetőek, így pl. egyszerűen hozzáadható a későbbiekben új résztvevő (pl. gyógyító, mágus, stb). A csatának akkor van vége, ha az egyik hadsereg megsemmisül.

## Megvalósítás 
 
A program vezérléséért a Hadszinter osztály felel. Itt jön létre a játéktábla, és a szimulációhoz elengedhetetlen tagfüggvények is itt kerülnek bevezetésre (pl. személy/harctípus hozzáadása). 
Az egységek pozíciója a játéktáblán, de magában az egyes objektumokban is tárolásra kerül. Egy „mezo” tömbben tárolom a játékosok aktuális pozícióját. A tengerFelett pedig az aktuális pont magasságát tárolja (ez az íjászok lövéseikor fontos). A magasság alapértelmezett adattal kerül feltöltésre, amit a hegycsinal metódussal felül lehet definiálni.

A berak metódus használatával egy harcos felhelyezhető a táblára, a kivesz használatával eltávolítható (pl. egy harcnál veszít). Vannak olyan szereplők akik nem kerülnek fel a táblára (pl. nyíl). Az íjászt megölhetik, de a nyila attól még be fog csapódni.

Az urese() metódus megadja, hogy egy adott mezőn tartózkodik-e valaki. Az ellensege() metódus azt adja meg, hogy az adott pozícióban ellenség található-e. 

A harcol metódussal elindul két katona között a harc. Egy listában tárolom a harc párokat (tehát mi történik ha egy íjász találkozik egy lovassal).

A játék addig fut, amíg az egyik hadsereg nem lesz üres. Egy for ciklussal végigmegyek a még életben lévő harcosokon, akik az aktuális állapotnak megfelelően csinálnak valamit. 

A Hadsereg osztály a hadsereget tartja nyílván. Van egy azonosítója (neve),és számon tartja az ide tartozó katonákat. Lekérdezhető a hadsereg állapota (üres-e vagy sem), és hozzáadható/eltávolítható belőle egy-egy szereplő. 

A harcos csomag tartalmazza a két egység harcának megvalósítását. A szereplo csomag pedig az egyes szereplők megvalósítását. A harcosok alapvető működését és egy általánosított mozgást az AbstractJatekos osztály valósít meg. A mozgásnál tárolom az irányt és a sebességet. A játékos először megpróbál előre lépni sebességnyit, valamint balra kitérni. Ha nem sikerül, akkor csak elfordul véletlenszerűen. 

Agyalogosból (aki az alapértelmezett mozgást végzi) származik le a katona, a lándzsás, és az íjász. A lovas az alapértelmezett mozgást végzi, de a sebességét a lova határozza meg. A hadsereg 
alaptáborát egy Tabor nevű szereplővel implementáltam, melynek a sebessége nulla és nem is végez semmilyen tevékenységet. Ha valaki megtámadja, megsemmisül. 
 
 
## Futtatás, tudnivalók
 
 A projektet elég csak beimportálni az Eclipse-be, futtatás esetén a konzolban megjelenik a csata eredménye szövegesen, lépésekre lebontva.
 
 Parancssori fordításra is van lehetőség, a fordítást a make fájl futtatásával lehet elindítani. A  legenerált csata.jar fájl a bin almappában található.