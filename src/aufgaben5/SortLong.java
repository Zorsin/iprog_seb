
package aufgaben5;

import java.util.ArrayList;

/**
 * @author Soeren Wirries
 *
 */
class SortLong {

	
	public static void main(String[] args) {//Main-Methode
		InteractivIO mIO = new InteractivIO();//Dekalrieren und Initialisieren der InteractivIO-Klasse
		
		mIO.write("Bitte die Zahlen zum Sortieren eingeben (leer Eingabe bricht einlesen ab)");//Ausgabe an die Konsole, Info an den User
		ArrayList<Long> longList = new ArrayList<Long>();//Dekalrieren und Initialisieren einer ArrayList, hat ähnliche Eigenschaften wie ein Array
														//ist aber in der Groesse nicht festgelegt
		boolean running = true;//Erstellt eine Laufvariable
		do{
			String zahl = mIO.promtAndRead("Bitte Zahl(long) eingeben:");//Fordert den User auf eine Zahl anzugeben
			if(zahl.equals("")){//Wenn die Eingabe mit Enter weggedrueckt wird ist der String leer ("") 
				running = false;//Laufvariable wird auf false gesetzt Schleife wird beendet
			}else{
				try{//Versucht aus der String Eingabe eine long zu machen und diese der Liste hinzuzufuegen
					longList.add(Long.parseLong(zahl));
				}catch(Exception ex){//Sollte es dabei zu einem Fehler kommen (Nutzer hat Buchstaben eingegeben
					running = false;// wird die schleife beendet, alternativ koennte auch nichts unternommen werden und der user einfach nach einer
									//neuen Zahl gefragt werden
				}
			}
			
		}while(running);//Schleife wird solange ausgeführt bis running = false; entweder durch leere Eingabe oder bei Fehler
		
		long[] longArray = new long[longList.size()];//Erstellt ein Array mit der Groesse der Liste
		int i = 0;
		for(long element : longList){//Schreibt Liste in Array via foreach
			longArray[i] = element;//schreibt das aktuelle Element der Liste an die Position i im Array 
			i++;//erhöht die Position fuers Array
		}
		long[] sortedArray = sort(longArray);//Ruft die sort()-Methode auf und Speichert diese in ein neues Array
		
		String outTxt = "Zahlen sortiert: ";//Erstellt den ersten Teil der Ausgabe
		for(long element : sortedArray){//fuegt die Sortierten Zahlen der Ausgebe der Reihnfolge nach hinzu
			outTxt += element + " ";
		}
	
		mIO.write(outTxt);//gibt den Ausgebetext aus

	}
	

	private static long[] sort(long[] toSort) {//Sortiert die angegeben Zahlen (Array)
		/**
		 * Nachfolgend werden alle Zahlen der Groesse nach aufsteigend sortiert
		 * Eine Zahl wird solange nach hintenverschoben bis sie nicht mehr die Groesste ist
		 */
		long tempSort;//Temporaerer Zwischenspeicher einer Zahl
		
		for(int i=1; i < toSort.length; i++) {//Wiederholt die Sortiertung bis jede Zeile einmal Sortiert worden ist
			
			for(int k=0; k < toSort.length-i ; k++) {//Sortiert jede Zeile durch das ganze Array
				
				if(toSort[k] > toSort[k+1]) {//Wenn meine aktuelle Zahl groesser als die darauffolgenden ist...
					
					tempSort = toSort[k];//dann speicher sie zwischen
					
					toSort[k] = toSort[k+1];//speicher die kleinere Zahl auf dem aktuellen Platz
					
					toSort[k+1] = tempSort;//speicher die groessere Zahl auf dem Platz danach
				}
				
			}
		}
		return toSort;
	}
	

}
