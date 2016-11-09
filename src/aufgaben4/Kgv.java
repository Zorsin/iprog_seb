package aufgaben4;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 */

/**
 * @author Sören Wirries
 *
 */
public class Kgv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		InteractivIO mIO = new InteractivIO();
		
		BigInteger zahl1 = mIO.promtAndReadBigInt("Bitte geben Sie die erste Zahl an:");
		BigInteger zahl2 = mIO.promtAndReadBigInt("Bitte geben Sie die zweite Zahl an:");
		
		BigInteger kgvInt = berechneKGV(zahl1,zahl2);
		
		mIO.write("Der kleinste gemeinsame Vielfache lautet "+kgvInt);
		mIO.write("Der Rest der Devision lautet "+zahl1.remainder(zahl2));

	}
	
	private static BigInteger berechneKGV(BigInteger zahl1, BigInteger zahl2){
		
		BigInteger bigInt = new BigInteger("0");
		
		bigInt = zahl1.multiply(zahl2);
		
		bigInt = bigInt.divide(zahl1.gcd(zahl2));
				
		return bigInt;
		
	}

}
