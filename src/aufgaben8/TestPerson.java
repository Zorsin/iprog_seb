/**
 * 
 */
package aufgaben8;

/**
 * @author Sören Wirries
 *
 */
public class TestPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Anlage von Personen als Array zum Testen der CompareTo Methode
		 * 
		 */
		Person[] liste = {
				new Person("Caeser", "Caeser", "beruf", "farbe", "tier",  1990, 2.1f),    	//0
				new Person("Alpha", "Alpha", "beruf", "farbe", "tier",  1990, 2.1f),		//1
				new Person("Heinrich", "Heinrich", "beruf", "farbe", "tier",  1990, 2.1f),	//2
				new Person("Paula", "Paula", "beruf", "farbe", "tier",  1990, 2.1f),		//3
				new Person("Charlie", "Charlie", "beruf", "farbe", "tier",  1990, 2.1f),	//4
				new Person("Berta", "Berta", "beruf", "farbe", "tier",  1990, 2.1f),		//5
				new Person("Zeppelin", "Zeppelin", "beruf", "farbe", "tier",  1990, 2.1f),	//6
				new Person("Julius", "Julius", "beruf", "farbe", "tier",  1990, 2.1f),		//7
				new Person("Otto", "Otto", "beruf", "farbe", "tier",  1990, 2.1f),			//8
				new Person("Anton", "Anton", "beruf", "farbe", "tier",  1990, 2.1f),		//9
				new Person("Bravo", "Bravo", "beruf", "farbe", "tier",  1990, 2.1f),		//10	
				
		};
		Person start = new Person("Alphabet", "Alphabet", "beruf", "farbe", "tier",  1990, 2.1f);
		/**
		 * Testen der Vererbung von Kindeskindern
		 * Die Die Personen werden untereinander als Kinder hinzugefügt
		 * und zum Schluss wird der Name eines Kindes ersetzt, jetzt sollte nur eines der Kinder
		 * aus der Stammbaum einen anderen Namen haben und nicht 2.
		 * Wenn 2 den geaenderten Namen haben, hat das Clonen nicht funktioniert
		 */
		liste[10].addChild(liste[4]);
		liste[1].addChild(liste[10]);
		start.addChild(liste[1]);
		
		//liste[5].addChild(liste[0]);
		//liste[9].addChild(liste[5]);
		
		//start.addChild(liste[9]);
		Person p5 = liste[5];
		Person p0 = liste[0];
		Person p9 = liste[9];
		p5.addChild(p0);
		p9.addChild(p5);
		
		Person cloned = p9.clone();
		p9.vorname = "cloned Anton";
        start.addChild(cloned);
		start.addChild(p9);
		
		System.out.println("Ausgabe des Stammbaums:");
		Person.print(start,"-");
		
		/**
		 * Testen der Sortierung nach Nachname mit BubbleSort
		 */
		Person[] sorted = (Person[]) bubbleSort(liste);//Sortieren der Personen aus derm Array mit BubbleSort und abspeichern als Personen Array
		System.out.println("\nAusgabe der sortierten Namen:");
		for(Person p : sorted){ //Alle Personen sortiert ausgeben
			System.out.println("Name: "+p.nachname);
		}
	}
	/**
	 * BubbleSort Methode aus den Vorlesungsfolien
	 * 
	 */
	public static Comparable[] bubbleSort (Comparable[] comps){
		boolean sorted;
		do {sorted = true;
			for (int i=0; i < comps.length-1; i++) {
				if (comps[i].compareTo(comps[i+1]) > 0){ // steht falsch?
				Comparable tmp = comps[i]; // tauschen
				comps[i] = comps[i+1]; // .. in 3 ..
				comps[i+1] = tmp; // Schritten
				sorted = false; // und noch nicht fertig
				}
			}
		} while (!sorted);
		return comps;
	}

}
