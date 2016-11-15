/**
 * 
 */
package aufgaben5;

/**
 * @author Soeren Wirries
 *
 */
class BorderRect {

	/**
	 * @param args
	 */
	public static void main(String[] args) { //Main Methode
		InteractivIO mIO = new InteractivIO(); //Dekalrieren und Initialisieren der InteractivIO-Klasse
		int n = mIO.promtAndReadInt("Bitte n angeben:");//User gibt Hoehe des Rechtecks an
		int m = mIO.promtAndReadInt("Bitte m angeben:");//User gibt Breite des des Rechtecks an
		int d = mIO.promtAndReadInt("Bitte d angeben:");//User gibt Randstaerke an
		
		genRect(n,m,d);//Erstellen des Rechtecks mit den Daten des Users

	}
	
	private static void genRect(int n, int m, int d){ //Erstellt das Rechteck
		/**
		 * Das gesammte Rechteck hat eine Höhe von 4*d +n und eine Breite von 4*d +m; Das Rechecke selber nur n*m
		 * Von Oben nach unten: d[f] + d[e] + n + d[e] + d[f] ; e= nur Rand links&rechts der Staerke d; f= Rand oben/unten der Staerke d
		 * Von links nach rechts: d + d + m + d + d
		 */
		genFill(m,n,d); //Erstellt gefuellten Rand oben
		genEmpty(m,n,d);//Erstellt gefuellten Rand rechts&links und ueber dem Rechtecke leere Felder
		genBody(m,n,d);// Erstellt den gefuellten Rand, den leeren Rand, das Rechteck, den leeren Rand und den gefuelllten Rand
		genEmpty(m,n,d);//Erstellt gefuellten Rand rechts&links und ueber dem Rechtecke leere Felder
		genFill(m,n,d); //Erstellt gefuellten Rand unten
	
	}

	private static void genFill(int m, int n, int d){// erzeugt gefuellten Rand
		for(int i = 0; i < d; i++){ //Erzeugt eine Anzahl von d Zeilen (Randstaerke horizontal)
			
			String zeile = "";//Jede Zeile muss leer am anfang leer sein
			
			for(int k = 0; k < (m+4*d);k++){//Erzeugt die m+4*d Spalten pro Zeile
				zeile += "*"; //Fügt pro Spalte ein * hinzu; alternativ zeile = zeile + "*";
			}
			System.out.println(zeile); //Gibt fertige Zeile aus
		}
	}
	
	private static void genEmpty(int m, int n, int d){//Erzeugt gefuellten Rand links, leeren Rand ueber Rechteck und  gefuellten Rand rechts
		for(int i = 0; i < d; i++){ //Erzeugt eine Anzahl von d Zeilen (Randstaerke horizontal)
			
			String zeile = "";//Jede Zeile muss leer am anfang leer sein
			
			for(int k = 0; k < d; k++){//Erzeugt eine Anzahl von d Splaten (Randstaerke vertikal)
				zeile += "*";//Fügt pro Spalte ein * hinzu; alternativ zeile = zeile + "*";
			}
			
			for(int k = 0; k < d; k++){//Erzeugt eine Anzahl von d Spalten (Randstaerke horizontal)
				zeile += " ";//Fügt pro Spalte ein " "(leer) hinzu; alternativ zeile = zeile + " ";
			}
			
			for(int k = 0; k < m; k++){//Erzeugt leeren Rand ueber laenge des Rechtecks (Randstaerke horizontal)
				zeile += " ";
			}
			
			for(int k = 0; k < d; k++){//Erzeugt eine Anzahl von d Spalten (Randstaerke horizontal)
				zeile += " ";
			}
			
			for(int k = 0; k < d; k++){//Erzeugt eine Anzahl von d Splaten (Randstaerke vertikal)
				zeile += "*";
			}
			
			System.out.println(zeile);//Gibt fertig Zeile aus
		}
	}
	
	private static void genBody(int m, int n, int d){//Erzeugt gefuellten Rand, leeren Rand, Rechteck, leeren Rand und wieder gefuellten Rand
		for(int i = 0; i < n; i++){ //Erzeugt das Rechteck mit der Hoehe n
		
			String zeile = "";//Jede Zeile muss leer am anfang leer sein
			
			for(int k = 0; k < d; k++){ //Erzeugt eine Anzahl von d Splaten gefuellt (Randstaerke vertikal)
				zeile += "*";
			}
		
			for(int k = 0; k < d; k++){ //Erzeugt eine Anzahl von d Splaten leer (Randstaerke vertikal)
				zeile += " ";
			}
			
			for(int k = 0; k < m; k++){ //Erzeugt das Recheck
				zeile += "*";
			}
			
			for(int k = 0; k < d; k++){ //Erzeugt eine Anzahl von d Splaten leer (Randstaerke vertikal)
				zeile += " ";
			}
			
			for(int k = 0; k < d; k++){//Erzeugt eine Anzahl von d Splaten gefuellt (Randstaerke vertikal)
				zeile += "*";
			}
			
			System.out.println(zeile); //gibt Zeile aus
		}
	}
}

