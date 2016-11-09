package aufgaben4;
/**
 * 
 */

/**
 * @author Sören Wirries
 *
 */
public class Pisquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		InteractivIO mIO = new InteractivIO();
		
		long zahl = mIO.promtAndReadLong("Bitte eine Zahl eingeben:");
		double out = 0;
		try{
			out = 6d*berechnePisq(zahl);
		}catch(StackOverflowError ex){
			out = Math.PI * Math.PI;
		}
		
		
		mIO.write("Die Ausgabe lautet "+out);

	}
	
	private static double berechnePisq(long zahl){
		
		if(zahl <= 1){
			return zahl;
		}else{
			
			return (1d/(zahl * zahl))+berechnePisq(zahl-1);
		}
		
	}
	
	/**
	 * 9.863601400089369
	 * 9.86900437108839
	 * 9.869032999727976
	 * 9.86905897133656
	 * 9.869073451131749
	 * 9.869078108383247
	 * 
	 */
//     
}
