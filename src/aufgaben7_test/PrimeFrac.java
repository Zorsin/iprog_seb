/**
 * 
 */
package aufgaben7_test;

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
		// TODO Auto-generated method stub
		
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
		/**
		 * Alternaiv:
		Rational[] K = new Rational[14];
		K[0] = new Rational(new BigInteger("17"), new BigInteger("91"));
		K[1] = new Rational(new BigInteger("78"), new BigInteger("85"));
		.
		.
		.
		*/
		/*
		for(Rational zahl : L){
			System.out.print(" " +zahl+",");
		}
		*/
		
		for(int i = 0; i < 14; i++){
			if(i == 13){
				System.out.println(" " +L[i]);
			}else{
				System.out.print(" " +L[i]+",");
			}
			
		}
		
		Rational b = new Rational(new BigInteger("2"), new BigInteger("1"));
		
		BigInteger zahl36982 = null;
		BigInteger max = b.zaehler;
		int stelle = 1;
		/**
		 * 
		 */
		for(int i = 1; i < 36983; i++){
			
			for(Rational zahl : L){
				Rational z = zahl.multiply(b);
				if(z.isInteger()){
					if(i < 1001 || i == 36982)
					{
						System.out.println("Ausgabe b: " + b);
						zahl36982 = b.zaehler;
					}
					if(max.compareTo(b.zaehler) < 0){
						max = b.zaehler;
						stelle = i;
					}
					b = z;
					break;
				}
			}
		}
		
		
		System.out.println("Zahl 36982: " +zahl36982);
		System.out.println("Max von 1 bis 36982: " +max);
		System.out.println("Stelle von Max 1 bis 36982: " +stelle);
	}
	

}
