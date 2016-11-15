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
	public static void main(String[] args) {
		InteractivIO mIO = new InteractivIO();
		long zahl = mIO.promtAndReadLong("Bitte Zahl angeben:");
		boolean isPrime = calcPrime(zahl);
		
		if(isPrime) {
			mIO.write(zahl+" ist eine primzahl");
		}else {
			mIO.write(zahl+" ist keine Primzahl");
		}

	}
	
	private static boolean calcPrime(long prime ){
		boolean out = false;
		
		for(long i = 2; i < prime && i*i <= prime; i++){
			out = ((prime%i) == 0);
			if(out){
				return false;
			}
		}
		
		return true;
	}

}
