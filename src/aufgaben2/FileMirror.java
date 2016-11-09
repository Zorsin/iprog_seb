package aufgaben2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
class FileMirror {

	public static void main(String[] args) {
		
		
		
		//String strInp = inputKey();
		
		File file1 = checkFile("Name für File1:");
		String nameFile2 = inputKey("Name für File2:");
		//File file2 = checkFile("Name für File2:");
		
		ArrayList<String> importedFile1 = importFile(file1);
		//ArrayList<String> importedFile2 = importFile(file2);
		
		ArrayList<String> invFile = new ArrayList<String>();
		
		for(String element: importedFile1){
			invFile.add(invert(element));
		}
		/*
		for(String element: importedFile2){
			invFile.add(invert(element));
		}
		*/
		File newFiel = new File(nameFile2);
		try{
				FileOutputStream outputStream = new FileOutputStream(newFiel);
				PrintStream printStream = new PrintStream(outputStream);
				
				for(String element: invFile){
					printStream.println(element);
				}
				System.out.println("Die Datei wurde unter "+newFiel.getAbsolutePath()+" abgelegt");
				
			}catch(Exception ex){
				System.out.println(ex);
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
	
	private static File checkFile(String text){
			String fileName = inputKey(text);
			File file = new File(fileName);
			if(file.exists()){
				return file;
			}
			//Bei der IDE liegen die .java-Dateien nicht im Ausführungsverzeichnis
			String rootDec = new File("").getAbsolutePath();
			String newDec = rootDec;
			if(rootDec.contains("Google Drive")){
				newDec = rootDec + "\\src\\";
				//System.out.println("Das Verzeichnis wurde von "+rootDec+" auf "+newDec+" geändert!");
				file = new File(newDec+fileName);
				if(file.exists()){
					return file;
				}
			}else{
				return checkFile(text);
			}
			return checkFile(text);
	}
	
	private static ArrayList<String> importFile(File file){
		
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
	
	private static String invert(String text){
		return text.length() <= 1 ? text : invert(text.substring(1))+text.substring(0,1);
	}
	
	

}
