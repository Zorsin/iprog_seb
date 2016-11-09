package aufgaben1;
/**
 * 
 * @author Sören Wirries
 *
 */
class ZipInvert {

	public static void main(String[] args) {
		
		String mText = "Hallo_Java";
		System.out.println(mText);
		
		String mTextInv = invert(mText);
		System.out.println(mTextInv);
		
		System.out.println(Zip(mText, mTextInv));
		
		System.out.println(zipinvert(mText, mText));
	}
	
	private static String Zip(String textA, String textB){
		return (textA.length() <= 0) || (textB.length() <= 0) ? textA + textB : textA.substring(0, 1) + textB.substring(0, 1) + Zip(textA.substring(1), textB.substring(1));
	}
	
	private static String invert(String text){
		return text.length() <= 1 ? text : invert(text.substring(1))+text.substring(0,1);
	}
	
	private static String zipinvert(String textA, String textB){
		return (textA.length() <= 0) || (textB.length() <= 0) ? textA + textB : textA.substring(0, 1) + textB.substring(textB.length()-1, textB.length()) + 
				zipinvert(textA.substring(1), textB.substring(0,textB.length()-1)
						);
	}

}
