package aufgaben4;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Sören Wirries
 *
 */
public class Gleiter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int lengh = new InteractivIO().promtAndReadInt("Größe angeben:");
		genHead(lengh);
		genTail(lengh);
		
	}
	
	private static void genHead(int zahl){
		
		String ship= new String();
		int leer = zahl;
		int stern = 0;
		
		while(zahl > 0){
			ship = nextRowLeerFill(leer,stern);
			ship += "*";
			ship += nextRowFillLeer(leer,stern);
			System.out.println(ship);
			zahl--;
			leer--;
			stern++;
			
		}
		
	}
	
	private static void genTail(int zahl){
		String ship= new String();
		int leer = 0;
		int stern = zahl;
		
		while(zahl > 0){
			ship = nextRowFillLeer(leer,stern);
			ship += " ";
			ship += nextRowLeerFill(leer,stern);
			System.out.println(ship);
			zahl--;
			leer++;
			stern--;
			
		}
	}
	
	private static String nextRowLeerFill(int leer, int stern){
		String body = new String();
		while(leer > 0){
			body += " ";
			leer--;
		}
		while(stern > 0){
			body += "*";
			stern--;
		}
		
		return body;
	}
	private static String nextRowFillLeer(int leer, int stern){
		String body = new String();
		while(stern > 0){
			body += "*";
			stern--;
		}
		
		while(leer > 0){
			body += " ";
			leer--;
		}
		
		return body;
	}
	
	private static String invert(String text){
		return text.length() <= 1 ? text : invert(text.substring(1))+text.substring(0,1);
	}

}
