/**
 * 
 */
package aufgaben8;

import java.util.ArrayList;

/**
 * @author Soeren Wirries
 *
 */
class FiBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractivIO mIO = new InteractivIO();
		
		int zahl = mIO.promtAndReadInt("Bitte prositive Zahl eingeben:");
		while(zahl < 0){
			zahl = mIO.promtAndReadInt("Bitte prositive Zahl erneut eingeben:");
		}
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 1; i <= zahl; i++){
			if(i%3 == 0 && i%5 == 0){
				list.add("FiBuzz ");
			}else if(i%3 == 0){
				list.add("Fizz ");
			}else if(i%5 == 0){
				list.add("Buzz ");
			}else{
				list.add(i + " ");
			}
		}
		
		
		for(String element : list){
			System.out.print(element);
		}

	}

}
