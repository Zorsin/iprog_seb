package aufgaben3;


/**
 * @author Sören Wirries
 *
 */
public class Ggt {
	static InteractivIO iIO;

	public static void main(String[] args) {
		iIO = new InteractivIO();
		Boolean running = true;
		while(running){
			running = breakGGT();
		}
		
		
	}
	
	private static int berechneGGT(int zahl1, int zahl2){
		if((zahl1%zahl2) == 0){
			return zahl2;
		}else{
			return berechneGGT(zahl2, zahl1%zahl2);
		}
		
	}
	
	private static boolean breakGGT(){
		int zahl1 = iIO.promtAndReadInt("Bitte erste Zahle eingeben:");
		
		int zahl2 = iIO.promtAndReadInt("Bitte zweite Zahle eingeben:");
		if(zahl1 == 0 || zahl2 == 0){
			return false;
		}else{
			iIO.write("Der größte gemeinsame Teiler ist "+berechneGGT(zahl1, zahl2));
			return true;
		}
		
	}
	
	/**
	 * GGT:
	 * TODO: Divisione bis 0, bsp: 45%50 = 0 Rest 45 -> 50 % 45 = 1 R 5 -> 45 % 5 = 9 R 0 <- Ende
	 * PowerTower
	 * TODO: 2^2 -> Math.pow()
	 * 
	 */

}
