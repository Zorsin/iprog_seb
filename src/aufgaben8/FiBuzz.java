/**
 * 
 */
package aufgaben8;

import java.util.ArrayList;

/**
 * @author Soeren Wirries
 *
 */
class FiBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractivIO mIO = new InteractivIO();
		/**
		 * Nutzer wird aufgefordert eine Zahl einzugeben, solange bis die Zahl groesser als 0 ist
		 */
		int zahl = mIO.promtAndReadInt("Bitte prositive Zahl eingeben:");
		while(zahl < 0){
			zahl = mIO.promtAndReadInt("Bitte prositive Zahl erneut eingeben:");
		}
		
		ArrayList<String> list = new ArrayList<String>(); //Erstellen eines ArrayLists zum Speichern der Zahlen bzw Texte
		
		for(int i = 1; i <= zahl; i++){
			if(i%3 == 0 && i%5 == 0){//Wenn Zahl durch 5 und 3 teilbar ist
				list.add("FiBuzz ");
			}else if(i%3 == 0){//Wenn Zahl durch 3 teilbar ist
				list.add("Fizz ");
			}else if(i%5 == 0){//Wenn Zahl durch 5 teilbar ist
				list.add("Buzz ");
			}else{
				list.add(i + " ");
			}
		}
		
		
		for(String element : list){//Ausgabe der Liste
			System.out.print(element);
		}

	}

}
