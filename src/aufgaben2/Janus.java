package aufgaben2;
import java.io.*;
import java.util.ArrayList;

/**
 * 
 * @author Sören Wirries
 *
 */
class Janus {

	public static void main(String[] args) {
		
		
		File file = new File("Janus.java");
		if(file.exists()){
			
			printFile(file);
			
		}else{
			//Bei der IDE liegen die .java-Dateien nicht im Ausführungsverzeichnis
			String rootDec = new File("").getAbsolutePath();
			String newDec = rootDec;
			if(rootDec.contains("Google Drive")){
				newDec = rootDec + "\\src\\";
				System.out.println("Das Verzeichnis wurde von "+rootDec+" auf "+newDec+" geändert!");
			}
			
			file = new File(newDec+"Janus.java");
			
			printFile(file);
			
		}
		
	}
	
	private static void printFile(File file){
		if(file.exists()){
			ArrayList<String> arrList = new ArrayList<String>();
			arrList = inputFile(file);
			
			System.out.println("Start der Ausgabe:");
			
			for(String element : arrList){
				System.out.println(element);
			}
			
			System.out.println("Ende der Ausgabe");
		}
	}
	
	private static ArrayList<String> inputFile(File file){
		ArrayList<String> arrOut = new ArrayList<String>();
		String input;
		BufferedReader buffReader;
		
		try {
			buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
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
