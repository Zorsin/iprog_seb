/**
 * 
 */
package aufgaben6;

/**
 * @author Soeren Wirries
 *
 */
class Snail {

	int textpos = 0;
	char[] charArray;
	
	public static void main(String[] args) {//Main-Methode
		InteractivIO mIO = new InteractivIO();
		String name = "Mona_Lisa_";//mIO.promtAndRead("Bitte Text eingeben:");
		int n = 0;
		/**
		 * Laut Aufgabenstellung soll die Groesse via Parameter mit gegeben werden.
		 * um keinen Fehler via IDE oder beim Vergessen zu bekommen wird geprueft ob Parameter 
		 * mitgegeben worden sind
		 */
		if(args.length > 0){//pruefen ob Parameter da
			try{
				n = Integer.parseInt(args[0]);//String-Parameter in int parsen
			}catch(Exception ex){//Wenn Fehler auftritt
				mIO.write("Fehler beim Lesen der Variable");
				n = mIO.promtAndReadInt("Bitte Schneckengroesse angeben:(int)");
			}
		}else{//Wenn kein Parameter mitgegeben worden ist
			n = mIO.promtAndReadInt("Bitte Schneckengroesse angeben:(int)");
		}
		while(n < 0){//Wenn der Parameter kleiner 0 also -1,-2 usw, dann erneut fragen, sonst keine Initialisierung des Array moeglich
			mIO.write("Die Variable muss groesser als 0 sein!");
			n = mIO.promtAndReadInt("Bitte Schneckengroesse angeben:(int)");
		}
		
		/**
		 * Ich habe lasse die Schnecke in einer eigenen Methode (Konstruktor) erstellen
		 * Es ist nicht zwingend notwendig, ich fand es aber übersichtlicher
		 */
		new Snail(name, n);//Aufrufen der Snail-Methode
	}
	
	public Snail(String text, int n){//Konstruktor der Klasse Snail
		
		charArray = text.toCharArray();//Wandelt Text(String) in Buchstaben-Array um (char[]) 
		String[][] output = createEmpty(n);//Erzeugt eine mit Leerzeichen gefuelltes 2-dimensionales Array
		
		
		/**
		 * Durchlauf fue n=10. Anhand diese Beispiels habe ich die Laufvariablen ermittelt
		 */
		/*//////////////////////////////////////////
		1. Durchlauf 
		 
		output = createTop(output,0,n-0,0); //1. l = 0, k=0; 2. l=0; k=2; 3. l=2 k=4;
		
		output = createDown(output,1,n-0,n-1);
		
		output = createBottom(output,n-2,0,n-1);
		
		output = createUp(output,n-2,2,0);
		/////////////////////////////////////
		2. Durchlauf
		
		output = createTop(output,0,n-2,2);
		
		output = createDown(output,3,n-2,n-3);
		
		output = createBottom(output,n-4,2,n-3);
		
		output = createUp(output,n-4,4,2);
		///////////////////////////////////////
		3. Durchlauf
		
		output = createTop(output,2,n-4,4);
		
		output = createDown(output,5,n-4,n-5);
		-> Abbruch da, der Letzte moegliche Punkt erreicht ist
		//////////////////////////////////////*/
		
		int k = 0;//Laufvariablen
		int l = 0;
		int j = 1;
		int m = 2;
		boolean run = true;
		
		//Schleife fuer den automatischen Durchlauf 
		do{
			if(n-k < (n/2)) break;//Wenn man sich "in der Mitte" befindet abbrechen
			//1. l = 0, k=0; 2. l=0; k=2; 3. l=2 k=4;
			output = createTop(output,l,n-k,k);//fuellt Zeile von links nach rechts
			
			if(n-j < (n/2)) break;//Wenn man sich in der Mitte befindet abbrechen
			// j=1 ; j=3; j=5
			output = createDown(output,j,n-k,n-j);//fuellt spalte von oben nach unten
			
			if(n-m < (n/2)) break;//Wenn man sich in der Mitte befindet abbrechen
			//m=2 ; m=4
			output = createBottom(output,n-m,k,n-j);//fuellt zeile von recht nach links
			
			if(m > (n/2)) break;//Wenn man sich in der Mitte befindet abbrechen
			output = createUp(output,n-m,m,k);//fuellt Spalte von unten nach oben 
			
			
			if(k > 0) l +=2;//l darf sich erst im 2ten Schritt mit erhoehen. siehe Test oben
			k +=2;//Erhoehung der Laufvariablen, da pro duchlauf ein Zeichen und der Leere Rand hinzukommen
			j += 2;
			m += 2;
			
			}while(run);
		
		String out = "";//Erstellen des Ausgabe Textes
		for(String[]elements : output){//Aufteilen des Arrays in 1-dimensioanle Arrays
			for(String element : elements){//Jeder Buchstabe ist ein String, daher die Strings aneinanderreihen
				out += element;//Zeichen der Ausgabe hinzufuegen
			}
			out += "\n";//Zeilen umbruch hinzufuegen
		}
		System.out.println(out);//Test ausgeben
	}
	
	private String[][] createEmpty(int n){//Erstellt mit Leerzeichen grfuelltes Array
		String[][] array = new String[n][n];
		/**
		 * Das array ist akuell nur mit NULL gefuellt
		 * deshalb muss es jetzt noch mit Leerzeichen gefuellt werden
		 */
		for(int i = 0; i < n; i++){
			for(int k = 0; k < n; k++){
				array[i][k] = " ";//fuellt das Array an der Stelle i,k mit " "
			}
		}
		return array;
	}
	
	
	private String[][] createTop(String[][] array, int start, int end, int row){//Fuellt Array mit Zeichen von links nach rechts
		/**
		 * array gibt das aktuelle zufuellende Array an, je nach Durchlauf ist es gefuellt oder leer
		 * start gibt den Startspalte im array an
		 * end gibt den Endspalte im array an
		 * row gibt die Zeile an
		 * Das array wird in der Zeile row von Spalte start bis Spalte end gefuellt 
		 */
		for(int i = start; i < end; i++, textpos++){//erhoeht pro durchlauf die Spalte und nimmt das naechste Zeichen aus den char-Array
			if(textpos >= charArray.length){//Wenn das Ende des Array erreicht ist muss wieder von vorne gestartet werden
				textpos = 0;
			}
			array[row][i] = ""+charArray[textpos];//setzt an die Stelle row,i den Buchstaben zum Index textpos des Textes
		}
		return array;//gibt das gefuellt array zurueck
	}
	
	private String[][] createDown( String[][] array, int start, int end, int column){//Fuellt das Array mit Zeichen von oben nach unten
		/**
		 * array gibt das aktuelle zufuellende Array an, je nach Durchlauf ist es gefuellt oder leer
		 * start gibt den Startzeile im array an
		 * end gibt den Endzeile im array an
		 * column gibt die Spalte an
		 * Das array wird in der Spalte row von Zeile start bis Zeile end gefuellt 
		 */
		for(int i = start; i < end; i++, textpos++){//erhoeht pro durchlauf die Zeile und nimmt das naechste Zeichen aus den char-Array
			if(textpos >= charArray.length){//Wenn das Ende des Array erreicht ist muss wieder von vorne gestartet werden
				textpos = 0;
			}
			array[i][column] = ""+charArray[textpos];//setzt an die Stelle i,column den Buchstaben zum Index textpos des Textes
		}
		
		return array;
	}
	
	private String[][] createBottom(String[][] array, int start, int end, int row){//Fuellt Array mit Zeichen von rechts nach links
		/**
		 * array gibt das aktuelle zufuellende Array an, je nach Durchlauf ist es gefuellt oder leer
		 * start gibt den Startspalte im array an
		 * end gibt den Endspalte im array an
		 * row gibt die Zeile an
		 * Das array wird in der Zeile row von Spalte start bis Spalte end gefuellt 
		 */
		for(int i = start; i >= end; i--, textpos++){//Hier wird von rechts nach links geschrieben deshalb wird die Spaltezahl verringert
			if(textpos >= charArray.length){
				textpos = 0;
			}
			array[row][i] = ""+charArray[textpos];
		}
		return array;
	}
	
	private String[][] createUp(String[][] array, int start, int end, int column){//Fuellt das Array mit Zeichen von unten nach oben
		/**
		 * array gibt das aktuelle zufuellende Array an, je nach Durchlauf ist es gefuellt oder leer
		 * start gibt den Startzeile im array an
		 * end gibt den Endzeile im array an
		 * column gibt die Spalte an
		 * Das array wird in der Spalte row von Zeile start bis Zeile end gefuellt 
		 */
		for(int i = start; i > end; i--, textpos++){//Hier wird von unten nach oben geschrieben deshalb wird die Zeilenzahl verringert
			if(textpos >= charArray.length){
				textpos = 0;
			}
			array[i][column] = ""+charArray[textpos];
		}
		
		return array;
	}
	
	
	

}
