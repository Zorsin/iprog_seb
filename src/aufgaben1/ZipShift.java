package aufgaben1;
/**
 * 
 * @author Sören Wirries
 *
 */
class ZipShift {

	public static void main(String[] args) {
		
		String mText = "HierKoennteIhreWerbungStehen";
		System.out.println(mText);
		
		String mTextSh = shiftR(mText);
		System.out.println(mTextSh);
		
		System.out.println(Zip(mText,mTextSh));

	}
	
	private static String Zip(String textA, String textB){
		return (textA.length() <= 0) || (textB.length() <= 0) ? textA + textB : textA.substring(0, 1) + textB.substring(0, 1) + Zip(textA.substring(1), textB.substring(1));
	}
	
	private static String shiftR(String text){
		String out = "";
		
		out = text.length() <= 1 ? text : text.substring(text.length() -1) + text.substring(0,text.length() -1);
		
		return out;
	}

}
