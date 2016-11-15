
package aufgaben5;

import java.math.BigDecimal;

/**
 * @author Soeren Wirries
 *
 */
class Sinus {

	
	public static void main(String[] args) {
		InteractivIO mIO = new InteractivIO();
		
		double x = mIO.promtAndReadDouble("Bitte x-Wert für sin(x) eingeben:");
		mIO.write("Der sin("+x+") ist "+doSin(x,85L));
		mIO.write("Der sin("+x+") ist "+Math.sin(x));
		
	}
	
	private static double doSin(double x, long n){
		
		if(n <= 0){
			
			return Math.pow(-1d, n) * (Math.pow(x, 2*n+1)/doFactional(2*n+1));
			
		}else{
			return doSin(x, n-1) + (pow(-1d, n) * (pow(x, 2*n+1)/doFactional(2*n+1)));
		}
		
	}
	
	private static double doFactional(long i){
		return i == 0 ? 1 : i * doFactional(i-1);
	}
	
	private static double pow(double zahl1, long zahl2){
		double out = 1;
		for(long i = zahl2; i > 0;i--){
			out *= zahl1;
		}
		return out;
	}

}
