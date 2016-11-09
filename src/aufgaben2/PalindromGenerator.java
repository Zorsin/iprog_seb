package aufgaben2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * 
 * @author Sören Wirries
 *
 */
class PalindromGenerator {

	public static void main(String[] args) {
		String inTxt1 = inputKey("Bitte erstes Wort eingeben:");
		String inTxt2 = inputKey("Bitte zweites Wort eingeben:");
		
		ArrayList<String> palindrome = new ArrayList<String>();
		//1. 1 i2 2 1
		palindrome.add(inTxt1 + invert(inTxt2) + inTxt2 + invert(inTxt1));
		//2. i1 2 2 1
		palindrome.add(invert(inTxt1) + inTxt2 + invert(inTxt2) + inTxt1);
		//3. 1 2 i2 i1
		palindrome.add(inTxt1 + inTxt2 + invert(inTxt2) + invert(inTxt1));
		//4. 2 1 i1 i2
		palindrome.add(inTxt2 + inTxt1 + invert(inTxt1) + invert(inTxt2));
		//5. 2i 1 i1 2
		palindrome.add(invert(inTxt2) + inTxt1 + invert(inTxt1) + inTxt2);
		
		System.out.println("Ausgabe der Palindrome:");
		for(String element : palindrome){
			System.out.println(element);
		}
		
		exportFile("palindrom.txt", palindrome);

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
	
	private static void exportFile(String fileName, ArrayList<String> data){
		File newFiel = new File(fileName);
		try{
				FileOutputStream outputStream = new FileOutputStream(newFiel);
				PrintStream printStream = new PrintStream(outputStream);
				
				for(String element: data){
					printStream.println(element);
				}
				System.out.println("Die Datei wurde unter "+newFiel.getAbsolutePath()+" abgelegt");
				
			}catch(Exception ex){
				System.out.println(ex);
			}
	}

}
