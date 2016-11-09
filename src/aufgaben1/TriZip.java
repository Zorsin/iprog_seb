package aufgaben1;

public class TriZip {

	public static void main(String[] args) {
		System.out.println(trizip("AAA","BBB","CCCCCC"));

	}
	
	private static String trizip(String textA, String textB, String textC){
		String ausgabe = "";
		
		if((textA.length() >= 1) && (textB.length() >= 1) && (textC.length() >= 1)){
			ausgabe = textA.substring(0, 1) + textB.substring(0, 1) + textC.substring(0, 1) + 
					trizip(textA.substring(1), textB.substring(1), textC.substring(1));
			
		}else if((textA.length() >= 0) && (textB.length() >= 0)&& (textC.length() == 0) ){
			ausgabe += zip(textA, textB);
			
		}else if((textA.length() >= 0) && (textB.length() == 0)&& (textC.length() >= 0) ){
			ausgabe += zip(textA, textC);
			
		}else if((textA.length() == 0) && (textB.length() >= 0)&& (textC.length() >= 0) ){
			ausgabe += zip(textB, textC);
		}else{
			System.out.println("A:"+textA.length()+" B:"+textB.length()+" C:"+textC.length());
		}
		
		
		return ausgabe;
	}
	
	private static String zip(String textA, String textB){
		return (textA.length() <= 0) || (textB.length() <= 0) ? textA + textB : textA.substring(0, 1) + textB.substring(0, 1) + zip(textA.substring(1), textB.substring(1));
	}

}
