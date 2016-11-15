/**
 * 
 */
package aufgaben5;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Soeren Wirries
 *
 */
class WordLcm {

	/**
	 * @param args
	 */
	static InteractivIO mIO = new InteractivIO();//Dekalrieren und Initialisieren der InteractivIO-Klasse als Globalevariable
	
	public static void main(String[] args) {//Main-Methode
		
		ArrayList<Integer> intList = new ArrayList<Integer>(); //Dekalrieren und Initialisieren eine Liste fuer Zahlen
		
		boolean running = true;//Erstellen eine Laufvariable
		do{
			String wordzahl = mIO.promtAndRead("Zahl als Wort eingeben:");//Den User aufforder eine Zahl als Wort eingeben
			if(wordzahl.equals("")){//Wenn nichts eingegeben wurde...
				running = false;//Laufvariable auf false setzen, bricht die Schleife ab
			}else{
				intList.add(getNumber(wordzahl));//sonst das Wort ueber die getNumber in Zahl (int) umwandeln und in Liste speichern
			}
		}while(running);//Wenn running auf false, wird Schleife beendet, sonst wird neue Zahl angefragt
		
		BigInteger bigInt = new BigInteger(String.valueOf(intList.get(0)));//Erstellt den ersten BigInteger aus dem ersten Element (0ten) der Liste
		
		for(int i = 1;i < intList.size(); i++ ){//fuehr die Berechnung des KGVs fuer jede Zahl aus
			/**
			 * Beim ersten Durchlauf wird der KGV aus der ersten und der zweiten Zahl erstellt
			 * dannach wird der KGV mit dem vorherigen KGV und der naechsten Zahl erstellt
			 * Die Umwandlung in BigInt wurde nur genommen um die Methode aus Aufgaben 4 zu nutzen
			 */
			bigInt = berechneKGV(bigInt, new BigInteger(String.valueOf(intList.get(i))));
		}
		
		mIO.write("Der KGV lautet:"+bigInt);//Ausgabe des KGV
		
	}
	
	private static int getNumber(String wordzahl){//Wandelt Zahltext in Zahlwert um
		
		int zahl = 0;
		/**
		 * Moegliche Eingabetypen von Zahlen:
		 * 200 = zweihundert
		 * 220 = zweihundertzwanzig
		 * 202 = zweihundertzwei
		 * 222 = zweihundertzweiundzwanzig
		 * 20 = zwanzig
		 * 2 = zwei
		 * 
		 */
		if(wordzahl.contains("hundert")){//Wenn im Wort "hundert" enthalten ist
			zahl += splitHundert(wordzahl);//Addiert die Hunderterstelle zur Zahl Bsp bei 202 -> 200
			wordzahl = subHundert(wordzahl);//Gibt den Rest des Wortes nach "hundert" zurueck bsp bei zweihundertzwanzig -> zwanzig
		}
		
		if(wordzahl.contains("und")){//Wenn im Wort "und" enthalten ist...
			zahl += splitZehner(wordzahl);//Addiert den Wert zur bisherigen Zahl Bsp zweiundzwanzig -> 22
		}else{//sonst 
			zahl += word2Int(wordzahl);//Wandelt den Rest des Wortes in Zahl um und addiert diese
		}
		
		return zahl;
	}
	
	
	private static int splitZehner(String zahlTxt){//Wandelt mit "und" verknuepfte Zahlen in Int um
		String[] zehner = zahlTxt.split("und");//Teilt den Text in mehere Teile am "und". 1. Teil enthaelt Wort vor dem "und". 2. Teil enthaelt wort nachdem "und"
		/**
		 * Bei dem Wort zweiundzwanzig (zwei|und|zwanzig) wird in die Bestandteile "zwei" & "zwanzig" geteilt
		 * "zwei" steht im 1.Teil, "zwanzig" im 2. Teil
		 * Im Gegenteil zu "hundert" ist beim "und" der 2. Teil immer gefuellt
		 */
		int zahl1 = word2Int(zehner[0]);//Wandelt den ersten Teil in Zahlenwert um
		int zahl2 = word2Int(zehner[1]);//Wandelt den zweiten Teil in Zahlenwert um
		
		return zahl1 + zahl2; //Addiert beide Teile und gibt sie zurueck
	}
	
	private static int splitHundert(String zahlTxt){//Wandelt mit "hundert" verknuepfte Zahlen in Int um
		
		String[] hunderter = zahlTxt.split("hundert");//Teilt den Text in mehrere Teile am "hundert"
		/**
		 * Bei dem Wort zweihundert (zwei|hundert) erhaellt man nur einen Wert zurueck
		 * Beim Wort zweihundertzeit (zwei|hundert|zwei) erhaellt man zwei Teile
		 */
		int zahl = word2Int(hunderter[0]);//Wandelt den ersten Teil in Zahlenwert um
		
		return zahl * 100;//Der Wert muss vor der Rueckgebe noch mit 100 multipliziert werden. Es wird nur das Wort "zwei" umgewandelt nicht "zweihundert"
		
	}
	
	private static String subHundert(String zahlTxt){//Trennt vom Text den Hunderter Teil ab und gibt den Rest zurueck
		
		String[] hunderter = zahlTxt.split("hundert");//Teilt wie oben am Wort "hundert"
		String out = "";//Erzeugen des Ausgebe Textes
		if(hunderter.length > 1){//Wenn das Array jetzt eine Groesse von 2 hat (also 2 Teile enthaellt)...
			out = hunderter[1];//schreibt den 2.Teil in die Ausgabe
		}
		
		return out;
	}
	
	private static int word2Int(String txt){//Wandelt alle Zahlenwoerter in Zahlenwerte um
		int outZahl = 0;
		/**
		 * Nachfolgen stehen alle Zahlen von 1-20 und dann immer 30,40,50 bis 100
		 * Wichtig ist nur ggf. ein nicht zutreffen des Falls zu beachten (default)
		 * und das Wort "ein" fuer einhundert, da es nicht einshundert heisst.
		 * Die Zehner-Zahlen wurden der eingefuegt um keine Trennung am Wort "zehn" durchfuehren zu muessen
		 * ausserdem muss dann z.b. sech fuer sechzehn hinzugefuegt werden
		 */
		switch(txt){//prueft das Wort auf folgende faelle
			case "ein":
				outZahl = 1;
				break;
			case "eins":
				outZahl = 1;
				break;
			case "zwei":
				outZahl = 2;
				break;
			case "drei":
				outZahl = 3;
				break;
			case "vier":
				outZahl = 4;
				break;
			case "fuenf":
				outZahl = 5;
				break;
			case "sechs":
				outZahl = 6;
				break;
			case "sieben":
				outZahl = 7;
				break;
			case "acht":
				outZahl = 8;
				break;
			case "neun":
				outZahl = 9;
				break;
			case "null":
				outZahl = 0;
				break;
			case "zehn":
				outZahl = 10;
				break;
			case "elf":
				outZahl = 11;
				break;
			case "zwoelf":
				outZahl = 12;
				break;
			case "dreizehn":
				outZahl = 13;
				break;
			case "vierzehn":
				outZahl = 14;
				break;
			case "fuenfzehn":
				outZahl = 15;
				break;
			case "sechszehn":
				outZahl = 16;
				break;
			case "siebzehn":
				outZahl = 17;
				break;
			case "achzehn":
				outZahl = 18;
				break;
			case "neunzehn":
				outZahl = 19;
				break;
			case "zwanzig":
				outZahl = 20;
				break;
			case "dreissig":
				outZahl = 30;
				break;
			case "vierzig":
				outZahl = 40;
				break;
			case "fuenfzig":
				outZahl = 50;
				break;
			case "sechzig":
				outZahl = 60;
				break;
			case "siebzig":
				outZahl = 70;
				break;
			case "achzig":
				outZahl = 80;
				break;
			case "neunzig":
				outZahl = 90;
				break;
			case "hundert":
				outZahl = 100;
				break;
			default:
				outZahl = 0;
				break;
			}
		
		return outZahl;
	}
	
	private static BigInteger berechneKGV(BigInteger zahl1, BigInteger zahl2){//Berechnung des KGV aus den Aufgaben 4
		
		BigInteger bigInt = new BigInteger("0");
		
		bigInt = zahl1.multiply(zahl2);//Schreibweise für Multiplikation von BigInt der Zahlen zahl1 und zahl2
		
		bigInt = bigInt.divide(zahl1.gcd(zahl2));//Division von BigInt durch den GCD der Zahlen
				
		return bigInt;
		
	}

}
