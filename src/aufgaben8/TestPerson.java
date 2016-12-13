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
				new Person("Hans", "Hansen", "beruf", "farbe", "tier",  1990, 2.1f),
				new Person("Peter", "Petersen", "beruf", "farbe", "tier",  1990, 2.1f),
				new Person("Juergen", "Juegensen", "beruf", "farbe", "tier",  1990, 2.1f),
				new Person("Olaf", "Olafsen", "beruf", "farbe", "tier",  1990, 2.1f)
		};
		/**
		 * Testen der Vererbung von Kindeskindern
		 * Die Die Personen werden untereinander als Kinder hinzugefügt
		 * und zum Schluss wird der Name eines Kindes ersetzt, jetzt sollte nur eines der Kinder
		 * aus der Stammbaum einen anderen Namen haben und nicht 2.
		 * Wenn 2 den geaenderten Namen haben, hat das Clonen nicht funktioniert
		 */
		/*
		Person p2 = liste[1];
		p2.addChild(liste[0]);
		
		Person p3 = liste[2];
		p3.addChild(p2);
		p3.addChild(liste[3]);
		p3.addChild(p2.clone());
		p2.nachname = "Cloned";
		Person.print(p3,"-");
		*/
		/**
		 * Testen der Sortierung nach Nachname mit BubbleSort
		 */
		/*Person[] sorted = (Person[]) bubbleSort(liste);//Sortieren der Personen aus derm Array mit BubbleSort und abspeichern als Personen Array
		
		for(Person p : sorted){ //Alle Personen sortiert ausgeben
			System.out.println("Name: "+p.nachname);
		}*/
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
