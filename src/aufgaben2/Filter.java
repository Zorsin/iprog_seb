package aufgaben2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * 
 * @author Sören Wirries
 *
 */
class Filter {

	public static void main(String[] args) {
		String webseite = inputKey("Bitte Webseite angeben:");
		String filter = inputKey("Bitte Filter angeben:");
		ArrayList<String> webData = new ArrayList<String>(); 
		try {
			webData = importWeb(new URL(webseite));
		} catch (MalformedURLException e) {
			System.out.println(e);
		}
		System.out.println("Suche nach Inhalten...");
		
		for(String element : webData){
			if(element.toLowerCase().contains(filter.trim().toLowerCase())){
				System.out.println(element);
			}
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
	
private static ArrayList<String> importWeb(URL url){
		
		ArrayList<String> arrOut = new ArrayList<String>();
		BufferedReader buffReader;
		
		try {
			buffReader = new BufferedReader(new InputStreamReader((FilterInputStream) url.openStream()));
			String line = new String();
			line = buffReader.readLine();
			do{
				arrOut.add(line);
				line = buffReader.readLine();
				
			}while(line != null);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return arrOut;
	}

}
