package aufgaben1;

/**
 * 
 * @author Sören Wirries
 *
 */

class Dopple {

	public static void main(String[] args) {
		System.out.println(dopple("Hello World!"));
	}
	
	private static String dopple(String text){
		String output = "";
		output =  text.length() <= 1 ? text :  text.substring(0, 1) + text.substring(0, 1) + dopple(text.substring(1));
		
		return output;
	}

}
