/**
 * 
 */
package aufgaben7;

import java.math.BigInteger;

/**
 * @author Sören Wirries
 *
 */
public class PrimeFrac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Rational[] L = {
		new Rational(new BigInteger("17"), new BigInteger("91")),
		new Rational(new BigInteger("78"), new BigInteger("85")),
		new Rational(new BigInteger("19"), new BigInteger("51")),
		new Rational(new BigInteger("23"), new BigInteger("38")),
		new Rational(new BigInteger("29"), new BigInteger("33")),
		new Rational(new BigInteger("77"), new BigInteger("29")),
		new Rational(new BigInteger("95"), new BigInteger("23")),
		new Rational(new BigInteger("77"), new BigInteger("19")),
		new Rational(new BigInteger("1"), new BigInteger("17")),
		new Rational(new BigInteger("11"), new BigInteger("13")),
		new Rational(new BigInteger("13"), new BigInteger("11")),
		new Rational(new BigInteger("15"), new BigInteger("2")),
		new Rational(new BigInteger("1"), new BigInteger("7")),
		new Rational(new BigInteger("55"), new BigInteger("1"))
		
		};
		
		for(int i = 0; i < L.length; i++){
			if(i == 13){
				System.out.println(" "+L[i]);
			}else{
				System.out.print(" "+L[i]+",");
			}
		}
		
		Rational b = new Rational(new BigInteger("2"), new BigInteger("1"));
		
		
		Rational max = b;
		int stelle = 1;
		
		for(int i = 1; i < 36983; i++){
			
			for(Rational r : L){
				Rational z = b.multiply(r);
				
				if(z.isInteger()){
					if(i < 1001 || i == 36982) System.out.println("Die Zahl an der Stelle "+i+" ist " +b.zaehler);
					
					
					if(max.zaehler.compareTo(b.zaehler) < 0){
						max = b;
						stelle = i;
					}
					
					b = z;
					break;
				}
			}
		}
		
		System.out.println("Groesste Zahl ist: "+max.zaehler + " an der Stelle: "+ stelle);
		
	}

}
