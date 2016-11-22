/**
 * 
 */
package aufgaben6;

/**
 * @author Sören Wirries
 *
 */
class Matrix {

	/**
	 * @param args
	 */
	double[][] matrix ;//= new double[0][0];
	int n = 0;
	int m = 0;
	
	public static void main(String[] args) {
		
		/**
		 * Erstellen der Matrix fuer Aufgabe 3:
		 */
		Matrix testMatrix = new Matrix(4,4);
		testMatrix.setEntry(1,1,0);
		testMatrix.setEntry(1,2,1);
		testMatrix.setEntry(1,3,0);
		testMatrix.setEntry(1,4,0);
		
		testMatrix.setEntry(2,1,0);
		testMatrix.setEntry(2,2,0);
		testMatrix.setEntry(2,3,1);
		testMatrix.setEntry(2,4,0);
		
		testMatrix.setEntry(3,1,0);
		testMatrix.setEntry(3,2,0);
		testMatrix.setEntry(3,3,0);
		testMatrix.setEntry(3,4,1);
		
		testMatrix.setEntry(4,1,1);
		testMatrix.setEntry(4,2,1);
		testMatrix.setEntry(4,3,-1);
		testMatrix.setEntry(4,4,2);
		
		/**
		 * Multipliziert die Matrix mit sich selbst.
		 * Speichert diese in ausgabe und gibt, diese vor dem naechsten Durchlauf aus
		 */
		Matrix ausgabe = testMatrix;
		int n = 1;//Laufvariable
		do{
			System.out.println("Ausgabe "+n+":\n"+ausgabe.toString());
			ausgabe = ausgabe.multiply(testMatrix);
			n++;
		}while(n <= 20);//Bis M^20
		
		
		
	}
	
	public Matrix(int m, int n){//Konstruktor der Klasse Matrix
		this.m = m;//Speichern der uebergabe Parameter in Globalevariablen
		this.n = n;
		
		matrix = new double[this.m][this.n];//erstellt eine neues 2dimensionales double-Array
	}
	
	public Matrix multiply(Matrix mat){//Berechnung fuer die Multiplikation
		Matrix out = new Matrix(this.m,this.n);//Erstellen der Ausgabe Matrix
		
		if(!(this.n == mat.m)){//Da bei der Multiplikation die Zeilen der einen mit den Spalten der anderen gleichsein muessen
			return new Matrix(0,0);//Wenn das nicht der Fall return einer leern Matrix der groesse 0
		}
		for(int i =1; i <= this.m; i++){//For Schreifen fuer jedes Element einer Matrix !! Wichtig Laufvariablen auf getEntry und setEntry anpassen (Zaehlweise)
			for(int j = 1; j <= this.n; j++){
				out.setEntry(i, j, this.getEntry(i,j) * mat.getEntry(j, i));//Speichert die Multiplikaiton in der Matrix out
			}
		}
		
		return out;
	}
	
	public Matrix init(double wert){//Fuellt die Matrix mit einem Wert, wird nicht fuer die Aufgaben benoetigt, war zur Kontrolle aber hilfreich
		Matrix out = new Matrix(this.m,this.n);
		
		for(int i =1; i <= this.m; i++){//For-Schleifen fuer jedes Element !! Wichtig Laufvariablen auf getEntry und setEntry anpassen (Zaehlweise)
			for(int j = 1; j <= this.n; j++){
				out.setEntry(i, j, wert);//Fuellt jede Position mit die Wert wert
			}
		}
		
		return out;
	}
	
	public Matrix add(Matrix mat){//Methode zur Addition einer Matrix
		Matrix out = new Matrix(this.m,this.n);//Erstellt neue Matrix
		
		if(!(this.n == mat.n) || !(this.m == mat.m)){//Bei der Addition muessen die Matrizen gleich gross sein
			return new Matrix(0,0);//Wenn es nicht zutrifft dann leer-Matrix zurueck
		}
		for(int i = 1; i <= this.m; i++){//For-Schleifen fuer jedes Element !! Wichtig Laufvariablen auf getEntry und setEntry anpassen (Zaehlweise)
			for(int j = 1; j <= this.n; j++){
				out.setEntry(i, j, this.getEntry(i, j) + mat.getEntry(i, j));//Addition der Matrizen und Speicherung in out
			}
		}
		
		return out;
	}
	
	public boolean checkFilled(){//Methode zur Pruefung ob Matrix leer, wird nicht in der Aufgabe verlangt, kann man zur Pruefung ob Add oder Multiply erfolgreich nutzen
		if(!(this.n == 0) || !(this.m == 0)){
			return true;
		}else{
			return false;
		}
	}
	
	
	public void setEntry(int i, int j, double x){//Methode zum Setzen eines Eintrages an die Position i,j
		this.matrix[i-1][j-1] = x;//Da eine "normaler" Mensch bei 1 anfaengt zu zaehlen muss die Position um 1 verschoben werden
	}
	
	public String toString(){//Methode fuer String-Rueckgabe
		String out = "";
		//Wenn es nicht moeglich, weil Matrix leer 
		try{
			/**
			 * Hier habe ich foreach Schleifen genutzt, da ich nur eine Matrix habe und ich die Position nicht 
			 * benoetige wie bei der Addition oder Multiplikation. Man kann auch hier die normale for-Schleife nutzen 
			 */
			for(double[] element : matrix){//Foreach-Schleifen fuer jedes Element 
				for(double zahl : element){
					out += " "+zahl;//fuegt die Zahlen einer Zeile durch Leerzeichen getrennt aneinander
				}
				out += "\n";//fuegt nach jeder Zeile einen Zeilenumbruch hinzu
			}
		}catch(Exception ex){
			return "Die Matrix ist leer (null)";
		}
		
		return out;
	}
	
	public double getEntry(int i, int j){//Methode um einen Eintrag an der Position i,j zu erhalten
		return matrix[i-1][j-1];//Da eine "normaler" Mensch bei 1 anfaengt zu zaehlen muss die Position um 1 verschoben werden
	}

}
