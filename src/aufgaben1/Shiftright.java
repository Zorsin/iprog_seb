package aufgaben1;

/**
 * 
 * @author Sören Wirries
 *
 */
class Shiftright {

	public static void main(String[] args) {
		
		System.out.println(shiftR("Hallo Welt!"));

	}
	
	private static String shiftR(String text){
		String out = "";
		
		out = text.length() <= 1 ? text : text.substring(text.length() -1) + text.substring(0,text.length() -1);
		
		return out;
	}

}
