package aufgaben3;
/**
 * 
 */

/**
 * @author Sören Wirries
 *
 */
public class PowerTower {

	
	public static void main(String[] args) {
		
		
		InteractivIO iIO = new InteractivIO();
		
		double d = iIO.promtAndReadDouble("Bitte reelle Zahl eingeben:");
		int i = iIO.promtAndReadInt("Bitte ganze Zahl eingeben:");
		
		iIO.write("Die Antwort lautet "+berechnePowerTower(d,i));

	}
	
	private static double berechnePowerTower(double dZahl, int iZahl){
		
		if(iZahl > 0){
			return Math.pow(dZahl, berechnePowerTower(dZahl,iZahl-1));
		}else{
			return Math.pow(dZahl, iZahl);
		}
		
	
	}

}
