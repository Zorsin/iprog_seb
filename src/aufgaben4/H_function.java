package aufgaben4;
import java.math.BigInteger;

/**
 * 
 */

/**
 * @author Sören Wirries
 *
 */
public class H_function {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractivIO mIO = new InteractivIO();
		
		int zahl1 = mIO.promtAndReadInt("Bitte erste Zahl eingeben:");
		int zahl2 = mIO.promtAndReadInt("Bitte zweite Zahl angeben:");
		while(zahl1 >= zahl2){
			
			zahl2 = mIO.promtAndReadInt("Die zweite Zahl muss größer als "+zahl1+" sein\nBitte erneut angeben angeben:");
		}
		
		BigInteger bigInt = doMath(zahl1,zahl2);
		mIO.write("Die Zahl lautet: "+bigInt);

	}
	
	public static BigInteger doMath(int zahl1, int zahl2){
		
		if(zahl1 == zahl2){
			return new BigInteger(""+zahl1);
		}else{
			BigInteger bigInt =  berechneKGV(doMath(zahl1,zahl2-1), new BigInteger(""+zahl2));
			bigInt = bigInt.divide(new BigInteger(""+berechneGGT(zahl1,zahl2)));
			return bigInt;
		}
		
	}
	
	private static BigInteger berechneKGV(BigInteger zahl1, BigInteger zahl2){
		
		BigInteger bigInt = new BigInteger("0");
		
		bigInt = zahl1.multiply(zahl2);
		
		bigInt = bigInt.divide(zahl1.gcd(zahl2));
				
		return bigInt;
		
	}
	
	private static int berechneGGT(int zahl1, int zahl2){
		if((zahl1%zahl2) == 0){
			return zahl2;
		}else{
			return berechneGGT(zahl2, zahl1%zahl2);
		}
		
	}

}
