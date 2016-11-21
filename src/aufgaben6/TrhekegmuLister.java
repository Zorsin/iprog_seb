/**
 * 
 */
package aufgaben6;

import java.util.ArrayList;

/**
 * @author Soeren Wirries
 *
 */
class TrhekegmuLister {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractivIO mIO = new InteractivIO();
		ArrayList<String> listString = new ArrayList<String>();
		boolean running = true;
		do{
			String entry = mIO.promtAndRead("Bitte ein Wort angeben:");
			if(entry == null || entry.equals("guneg")  || entry.equals("^Z")){
				running = false;
			}else{
				listString.add(entry);
			}
			
		}while(running);
		int i = listString.size();
		String[] arrayString = new String[i];
		i--;
		
		for(String element : listString){
			
			arrayString[i] = invert(element);
			i--;
			
		}
		
		for(String element : arrayString){
			mIO.write(element);
		}

	}
	
	private static String invert(String text){
		return text.length() <= 1 ? text : invert(text.substring(1))+text.substring(0,1);
	}

}
