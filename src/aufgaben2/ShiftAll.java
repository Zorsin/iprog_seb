package aufgaben2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Sören Wirries
 *
 */
class ShiftAll {

	public static void main(String[] args) {
		
		String input = inputKey();
		System.out.println(input);
		
		String winput = input;
		
		int i = input.length() ;
		while (i > 0 ){
			
			winput = shiftR(winput);
			System.out.println(winput);
			i--;
		}

	}
	
	private static String inputKey(){
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String strInp = "";
		try {
			System.out.println("Text eingeben:");
			strInp = keyboard.readLine();
		} catch (IOException e) {
			
			System.out.println(e);
		}
		
		return strInp;
	}
	
	private static String shiftR(String text){
		String out = "";
		
		out = text.length() <= 1 ? text : text.substring(text.length() -1) + text.substring(0,text.length() -1);
		
		return out;
	}

}
