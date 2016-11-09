package aufgaben2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Sören Wirries
 *
 */
class PalindromTest {

	public static void main(String[] args) {
		String input = inputKey("Bitte Palindrom eingeben:");
		
		if(input.trim().toLowerCase().contains(invert(input.trim().toLowerCase()))){
			System.out.println("Richtig. Das Wort ist ein Palindrom!");
		}else{
			System.out.println("Falsch. Das Wort ist kein Palindrom!");
		}

	}
	
	private static String inputKey(String text){
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String strInp = "";
		try {
			System.out.println(text);
			strInp = keyboard.readLine();
		} catch (IOException e) {
			
			System.out.println(e);
		}
		
		return strInp;
		
	}
	
	private static String invert(String text){
		return text.length() <= 1 ? text : invert(text.substring(1))+text.substring(0,1);
	}

}
