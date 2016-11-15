
package aufgaben5;

import java.math.BigDecimal;

/**
 * @author Soeren Wirries
 *
 */
class Sinus {

	
	public static void main(String[] args) { //Main Methode
		InteractivIO mIO = new InteractivIO(); //Dekalrieren und Initialisieren der InteractivIO-Klasse
		
		double x = mIO.promtAndReadDouble("Bitte x-Wert für sin(x) eingeben:"); //User gibt x fuer Berechnug ein 
		mIO.write("Der sin("+x+") ist "+doSin(x,85L)); //Gibt Sinus von x aus; doSin()-Methode berechnet Sinus
		//mIO.write("Der sin("+x+") ist "+Math.sin(x)); //Zur Kontrolle ob Programm richtig rechnet
		
	}
	
	private static double doSin(double x, long n){ //Berechnet den Sinus anhand der Formel aus der Aufgabe
		/**
		 * Diese Loesung rechnet recursiv mit der Anzahl an n Durchlaeufen
		 * Hier wird mit dem hoechsten n begonnen und diese bis n=0 verringert
		 */
		if(n <= 0){ //Wenn der letzte Durchlauf erreicht ist...
			//gibt in der Regel den Wert für n = 0 zurueck
			//        v- berechnung -1 hoch n
			//                              v- Berechnung x hoch 2 mal k plus 1
			return pow(-1d, n) * (pow(x, 2*n+1)/doFactional(2*n+1));
			//                                      ^-geteilt durch 2 mal k plus 1 fakultaet
			
		}else{
			//        v- berechnung der Formel für n-1 
			return doSin(x, n-1) + (pow(-1d, n) * (pow(x, 2*n+1)/doFactional(2*n+1)));
			//                              ^- Formel s.o. hier wird mit dem aktuellen n gerechnet 
		}
		
	}
	
	private static double doFactional(long i){//Berechnung der Fakultaet
		/**
		 * Die Fakultaet von 5 wird ueber 1*2*3*4*5 berechnet
		 * Dieser Ansatz rechnet recursiv mit 5*4*3*2*1
		 * 5! = 5*4! = 5*4*3!
		 * Per Definition ist 0! = 1
		 */
		// Wenn i = 0 dann return 1 sonst berechne die Fakultaet i * (i-1)!
		return i == 0 ? 1 : i * doFactional(i-1);
	}
	
	private static double pow(double zahl1, long zahl2){//Berechnen der Potezen da kein Math.pow genutzt werden darf
		/**
		 * Die Zahl1 wird so oft wie Zahl2 angibt mit sich selbst multipliziert
		 * Die Schleife wied nicht durchlaufen wenn Zahl2 = 0 da das Ergebnis immer 1 ist
		 */
		double out = 1; //Ergebnis fuer 0 Durchlaeufe festlegen
		for(long i = zahl2; i > 0;i--){//solange durchlaufen bis die Zahl2 (i) 1 (>0) ist. z.B. Wenn Zahl2 = 1 dann einen Durchlauf
			out *= zahl1;//Zahl mit 1 bzw dem ergebnis des vorherigen Durchlaufs multiplizieren
		}
		return out;
	}

}
