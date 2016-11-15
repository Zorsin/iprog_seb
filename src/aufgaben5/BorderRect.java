/**
 * 
 */
package aufgaben5;

/**
 * @author Soeren Wirries
 *
 */
class BorderRect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractivIO mIO = new InteractivIO();
		int n = mIO.promtAndReadInt("Bitte n angeben:");
		int m = mIO.promtAndReadInt("Bitte m angeben:");
		int d = mIO.promtAndReadInt("Bitte d angeben:");
		
		genRect(n,m,d);

	}
	
	private static void genRect(int n, int m, int d){
		
		genFill(m,n,d);
		genEmpty(m,n,d);
		genBody(m,n,d);
		genEmpty(m,n,d);
		genFill(m,n,d);
	
	}

	private static void genFill(int m, int n, int d){
		for(int i = 0; i < d; i++){
			
			String zeile = "";
			for(int k = 0; k < (m+4*d);k++){
				zeile += "*";
			}
			System.out.println(zeile);
		}
	}
	
	private static void genEmpty(int m, int n, int d){
		for(int i = 0; i < d; i++){
			
			String zeile = "";
			
			for(int k = 0; k < d; k++){
				zeile += "*";
			}
			
			for(int k = 0; k < d; k++){
				zeile += " ";
			}
			
			for(int k = 0; k < m; k++){
				zeile += " ";
			}
			
			for(int k = 0; k < d; k++){
				zeile += " ";
			}
			
			for(int k = 0; k < d; k++){
				zeile += "*";
			}
			
			System.out.println(zeile);
		}
	}
	
	private static void genBody(int m, int n, int d){
		for(int i = 0; i < n; i++){
		
			String zeile = "";
			
			for(int k = 0; k < d; k++){
				zeile += "*";
			}
		
			for(int k = 0; k < d; k++){
				zeile += " ";
			}
			
			for(int k = 0; k < m; k++){
				zeile += "*";
			}
			
			for(int k = 0; k < d; k++){
				zeile += " ";
			}
			
			for(int k = 0; k < d; k++){
				zeile += "*";
			}
			
			System.out.println(zeile);
		}
	}
}

