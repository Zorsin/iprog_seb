/**
 * 
 */
package aufgaben5;

/**
 * @author Soeren Wirries
 *
 */
class FifthRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {//Main-Methode
		InteractivIO mIO = new InteractivIO();//Initialisieren und Deklarieren der InteractivIO-Klasse
		
		double doubleToRoot = mIO.promtAndReadDouble("Zahl eingeben fuer 5. Wurzel:");//Den User auffordern eine Zahl einzugeben
		
		double root = doRoot(doubleToRoot);//Berechnen der Wurzel
		
		mIO.write("Die 5. Wurzel von "+doubleToRoot+" ist "+root);//Ausgebe des Ergebnisses
	}
	
	private static double pow(double zahl1, double zahl2){//Berechnen der Potezen da kein Math.pow genutzt werden darf
		/**
		 * Die Zahl1 wird so oft wie Zahl2 angibt mit sich selbst multipliziert
		 * Die Schleife wied nicht durchlaufen wenn Zahl2 = 0 da das Ergebnis immer 1 ist
		 */
		double out = 1;//Ergebnis fuer 0 Durchlaeufe festlegen
		for(double i = zahl2; i > 0;i-- ){//solange durchlaufen bis die Zahl2 (i) 1 (>0) ist. z.B. Wenn Zahl2 = 1 dann einen Durchlauf
			out *= zahl1;//Zahl mit 1 bzw dem ergebnis des vorherigen Durchlaufs multiplizieren
		}
		return out;
	}
	
	public static double doRoot(double zahl){//Berechnung der 5. Wurzel
		int n = 5;//Typ der Wurzel festlegen, bei n=2 waere es die zweite Wurzel
		double p = 1e-12;//Genauigkeit festlegen
		int maxTry = 100000;//Maximale Versuche festlegen
        int currTry = 0;//Aktuelle Versuche
		
		if(zahl == 0){//Wenn die Wurzel aus 0 gezogen werden soll...
        	return 0;
        }
		
        if(zahl < 0) //Wenn es ich um eine negertive Zahl handelt.
        {
        	/**
        	 * Das Berechnen von negertiven Wurzeln ist eigentlich nicht moeglich da es aber das gleiche ist
        	 * wie das Ergebnis der prositiven Wurzel kann die prositive berechnet werden und dann einfach negiert werden
        	 */
        	zahl = zahl * -1;//Umwandeln von Negertiv in Prositiv
        	/**
        	 * Berechnung der Wurzel analog zum Berechnen der 3. Wurzel aus der Vorlesung Seite 26
        	 * xn*xn*xn wurde zu pow(xn,3) bzw hier für 5. Wurzel pow(zahl1,5)
        	 */
        	double zahl1 = 1;
            double zahl2 = zahl1-(pow(zahl1,5)-zahl) / (5 * pow(zahl1,4));//Berechnung der ersten Annaeherung
            
    		while(abs(zahl1-zahl2)> p && currTry < maxTry){//Pruefen ob Annaeherung genaugenug oder maxTry erreicht worden ist 
            	zahl1 = zahl2;//altes Ergebnis zwischen speichern
            	zahl2 = zahl1-(pow(zahl1,5)-zahl) / (5 * pow(zahl1,4));//Berechnung erneuter Annaeherung
            	currTry++;//Versuche um 1 erhoehen
            }
            
            return zahl2*-1;//Prositives Ergebnis wieder negieren
            
        }else{//Berechnung des Ergebnisses wenn Zahl schon prositiv
        	//Beschreibung s.o.
        	double zahl1 = 1;
        	double zahl2 = zahl1-(pow(zahl1,5)-zahl) / (5 * pow(zahl1,4));
            
            while(abs(zahl1-zahl2)> p && currTry < maxTry){
            	zahl1 = zahl2;
            	zahl2 = zahl1-(pow(zahl1,5)-zahl) / (5 * pow(zahl1,4));
            	currTry++;
            }
            return zahl2;
        }
        
    }
	
	private static double abs(double doub){//Berechnen des absoluten Wertes da Math.abs() nicht genutzt werden soll.
		return doub < 0 ? doub * -1 : doub;
	}
	
	/* Berechnung der nten Wurzel aus dem Internet
	private static double rootInet(double x){

        double p = 1e-12;
        int n = 5;
        double zahl1 = x;
        double zahl2 = x / n;
        
        while (abs(zahl1 - zahl2) > p) 
        {
        	zahl1 = zahl2;
        	zahl2 = ((n - 1.0) * zahl2 + x / pow(zahl2, n - 1.0)) / n;
        	
        }
        return zahl2;
		
	}*/
	
	

}

