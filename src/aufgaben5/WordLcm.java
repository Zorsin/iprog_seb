/**
 * 
 */
package aufgaben5;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Soeren Wirries
 *
 */
class WordLcm {

	/**
	 * @param args
	 */
	static InteractivIO mIO = new InteractivIO();
	
	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<Integer>(); 
		
		boolean running = true;
		do{
			String wordzahl = mIO.promtAndRead("Zahl eingeben als Wort");
			if(wordzahl.equals("")){
				running = false;
			}else{
				intList.add(getNummber(wordzahl));
			}
		}while(running);
		
		BigInteger bigInt = new BigInteger(String.valueOf(intList.get(0)));
		
		for(int i = 1;i < intList.size(); i++ ){
			bigInt = berechneKGV(bigInt, new BigInteger(String.valueOf(intList.get(i))));
		}
		
		mIO.write("Der KGV lautet:"+bigInt);
		
	}
	
	private static int getNummber(String wordzahl){
		
		int zahl = 0;
		if(wordzahl.contains("hundert")){
			zahl += splitHundert(wordzahl);
			wordzahl = subHundert(wordzahl);
		}
		
		if(wordzahl.contains("und")){
			zahl += splitZehner(wordzahl);
		}else{
			zahl += word2Int(wordzahl);
		}
		
		return zahl;
	}
	
	
	private static int splitZehner(String zahlTxt){
		String[] zehner = zahlTxt.split("und");
		
		int zahl1 = word2Int(zehner[0]);
		int zahl2 = word2Int(zehner[1]);
		
		return zahl1 + zahl2;
	}
	
	private static int splitHundert(String zahlTxt){
		
		String[] hunderter = zahlTxt.split("hundert");
		
		int zahl = word2Int(hunderter[0]);
		
		return zahl * 100;
		
	}
	
	private static String subHundert(String zahlTxt){
		
		String[] hunderter = zahlTxt.split("hundert");
		String out = "";
		if(hunderter.length > 1){
			out = hunderter[1];
		}
		
		return out;
	}
	
	private static int word2Int(String txt){
		int outZahl = 0;
		
		switch(txt){
			case "ein":
				outZahl = 1;
				break;
			case "eins":
				outZahl = 1;
				break;
			case "zwei":
				outZahl = 2;
				break;
			case "drei":
				outZahl = 3;
				break;
			case "vier":
				outZahl = 4;
				break;
			case "fuenf":
				outZahl = 5;
				break;
			case "sechs":
				outZahl = 6;
				break;
			case "sieben":
				outZahl = 7;
				break;
			case "acht":
				outZahl = 8;
				break;
			case "neun":
				outZahl = 9;
				break;
			case "null":
				outZahl = 0;
				break;
			case "zehn":
				outZahl = 10;
				break;
			case "elf":
				outZahl = 11;
				break;
			case "zwoelf":
				outZahl = 12;
				break;
			case "dreizehn":
				outZahl = 13;
				break;
			case "vierzehn":
				outZahl = 14;
				break;
			case "fuenfzehn":
				outZahl = 15;
				break;
			case "sechszehn":
				outZahl = 16;
				break;
			case "siebzehn":
				outZahl = 17;
				break;
			case "achzehn":
				outZahl = 18;
				break;
			case "neunzehn":
				outZahl = 19;
				break;
			case "zwanzig":
				outZahl = 20;
				break;
			case "dreissig":
				outZahl = 30;
				break;
			case "vierzig":
				outZahl = 40;
				break;
			case "fuenfzig":
				outZahl = 50;
				break;
			case "sechzig":
				outZahl = 60;
				break;
			case "siebzig":
				outZahl = 70;
				break;
			case "achzig":
				outZahl = 80;
				break;
			case "neunzig":
				outZahl = 90;
				break;
			case "hundert":
				outZahl = 100;
				break;
			default:
				outZahl = 0;
				break;
			}
		
		return outZahl;
	}
	
	private static BigInteger berechneKGV(BigInteger zahl1, BigInteger zahl2){
		
		BigInteger bigInt = new BigInteger("0");
		
		bigInt = zahl1.multiply(zahl2);
		
		bigInt = bigInt.divide(zahl1.gcd(zahl2));
				
		return bigInt;
		
	}

}
