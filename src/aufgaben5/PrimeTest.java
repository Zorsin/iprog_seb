/**
 * 
 */
package aufgaben5;

/**
 * @author Soeren Wirries
 *
 */
class PrimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {//Main-Methode
		InteractivIO mIO = new InteractivIO();//Initialisieren und Deklarieren der InteractivIO-Klasse
		long zahl = mIO.promtAndReadLong("Bitte Zahl angeben:");//Den User auffordern eine Zahl einzugeben
		boolean isPrime = calcPrime(zahl);//Berechnen/Pruefen ob Primzahl
		
		if(isPrime) {//Wenn ja
			mIO.write(zahl+" ist eine primzahl");
		}else {//sonst
			mIO.write(zahl+" ist keine Primzahl");
		}

	}
	
	private static boolean calcPrime(long prime ){//Berechnung der Primzahl
		boolean out = false;
		
		for(long i = 2; i < prime && i*i <= prime; i++){//solange der Teiler kleiner als die Zahl ist...
			out = ((prime%i) == 0);//Testen ob teilen ohne Rest moeglich ist
			if(out){//Wenn ja ..
				return false;//.. dann keine Primzahl
			}
			//naechster Versuche
		}
		//Wenn kein Ja gefunden worden ist, dann ist es eine Primzahl
		return true;
	}

}
