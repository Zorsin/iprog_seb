package aufgaben1;
/**
 * 
 * @author Sören Wirries
 *
 */
class Zip {

	public static void main(String[] args) {
		System.out.println(Zip("Hallo","Java"));

	}
	
	private static String Zip(String textA, String textB){
		return (textA.length() <= 0) || (textB.length() <= 0) ? textA + textB : textA.substring(0, 1) + textB.substring(0, 1) + Zip(textA.substring(1), textB.substring(1));
	}

}
