/**
 * 
 */
package aufgaben6;

import java.util.ArrayList;

/**
 * @author Soeren Wirries
 *
 */
class TrhekegmuLister {

	/**
	 * @param args
	 */
	public static void main(String[] args) {//Main-Methode
		InteractivIO mIO = new InteractivIO();//Initialisieren und Deklarieren der InteractivIO-Klasse
		
		ArrayList<String> listString = new ArrayList<String>();//Erzeugen einer ArrayList zum Abspeichern der Strings
		boolean running = true;//Laufvariable fuer Schleife
		/**
		 * Die Schleife wird solange ausgefuehrt bis eine Abbruchbedinung zu trifft
		 */
		do{
			String entry = mIO.promtAndRead("Bitte ein Wort angeben:");//Einlesen des Strings
			if(entry == null || entry.equals("guneg")  || entry.equals("^Z")){//Wenn das eingelesene Wort einer Abbruchbedinung gleich ist
				running = false;//Schleife beenden
			}else{
				listString.add(entry);//Wort der Liste hinzufuegen
			}
		}while(running);
		
		int i = listString.size();//Groesse der Liste als Laufvariable speichern
		String[] arrayString = new String[i];//Array der Groesse i erzeugen
		i--;//Variable verringern, da Array bei 0 anfaengt zu zaehlen
		
		for(String element : listString){//foreach Schleife fuer Umwandlung Liste in Array
			
			arrayString[i] = invert(element);//Speichert das Eingelesene Wort invertiert. Das Array wird von hinten nach vorne gefuellt
			i--;
		}
		
		for(String element : arrayString){//Foreach Schleife zur Ausgabe des Arrays
			mIO.write(element);
		}

	}
	
	private static String invert(String text){//Invert-Methode aus den Aufgaben 1 (zipinvert)
		return text.length() <= 1 ? text : invert(text.substring(1))+text.substring(0,1);
	}

}
