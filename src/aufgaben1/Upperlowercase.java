package aufgaben1;
/**
 * 
 * @author Sören Wirries
 *
 */
class Upperlowercase {

	public static void main(String[] args) {
		
		System.out.println(UpperLower("Hallo Welt!"));

	}
	
	private static String UpperLower(String text){
		String ausgabe = "";
		if (text.length() <= 1){
			ausgabe += text;
		}else{
			ausgabe = (text.length() % 2) == 1 ? text.substring(0, 1).toUpperCase() + UpperLower(text.substring(1)) : text.substring(0, 1).toLowerCase() + UpperLower(text.substring(1));
		}
		return ausgabe;
	}

}
