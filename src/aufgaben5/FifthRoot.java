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
	public static void main(String[] args) {
		InteractivIO mIO = new InteractivIO();
		
		double doubleToRoot = mIO.promtAndReadDouble("Zahl eingeben fuer 5. Wurzel:");
		
		double root = doRoot(doubleToRoot);
		
		mIO.write("Die 5. Wurzel von "+doubleToRoot+" ist "+root);
	}
	
	private static double pow(double zahl1, double zahl2){
		double out = 1;
		for(double i = zahl2; i > 0;i-- ){
			out *= zahl1;
		}
		return out;
	}
	
	public static double doRoot(double zahl) 
    {
		int n = 5;
		double p = .0001d;
		
		if(zahl == 0){
        	return 0;
        }
		
        if(zahl < 0) 
        {
        	zahl = zahl * -1;
        	double zahl1 = zahl;
            double zahl2 = zahl / n;
            
            while (abs(zahl1 - zahl2) > p) 
            {
                zahl1 = zahl2;
                zahl2 = ((n - 1.0) * zahl2 + zahl / pow(zahl2, n - 1.0)) / n;
            }
            
            return zahl2*-1;
            
        }else{
        	double zahl1 = zahl;
            double zahl2 = zahl / n;
            
            while (abs(zahl1 - zahl2) > p) 
            {
            	zahl1 = zahl2;
            	zahl2 = ((n - 1.0) * zahl2 + zahl / pow(zahl2, n - 1.0)) / n;
            }
            return zahl2;
        }
        
    }
	
	private static double abs(double doub){
		return doub < 0 ? doub * -1 : doub;
	}

}
