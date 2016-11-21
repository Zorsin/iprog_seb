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
		 * Speichert diese in Ausgabe und gibt dies Vor dem naechsten Durchlauf aus
		 */
		Matrix ausgabe = testMatrix;
		int n = 1;//Laufvariable
		do{
			System.out.println("Ausgabe "+n+":\n"+ausgabe.toString());
			ausgabe = ausgabe.multiply(testMatrix);
			n++;
		}while(n <= 20);
		
		
		
	}
	
	public Matrix(int m, int n){
		this.m = m;
		this.n = n;
		
		matrix = new double[this.m][this.n];
	}
	
	public Matrix multiply(Matrix mat){
		Matrix out = new Matrix(this.m,this.n);
		
		if(!(this.n == mat.m)){
			return new Matrix(0,0);
		}
		for(int i =1; i <= this.m; i++){
			for(int j = 1; j <= this.n; j++){
				out.setEntry(i, j, this.getEntry(i,j) * mat.getEntry(j, i));
			}
		}
		
		return out;
	}
	
	public Matrix init(double wert){
		Matrix out = new Matrix(this.m,this.n);
		
		for(int i =1; i <= this.m; i++){
			for(int j = 1; j <= this.n; j++){
				out.setEntry(i, j, wert);
			}
		}
		
		return out;
	}
	
	public Matrix add(Matrix mat){
		Matrix out = new Matrix(this.m,this.n);
		if(!(this.n == mat.n) || !(this.m == mat.m)){
			return new Matrix(0,0);
		}
		for(int i = 1; i <= this.m; i++){
			for(int j = 1; j <= this.n; j++){
				out.setEntry(i, j, this.getEntry(i, j) + mat.getEntry(i, j));
			}
		}
		
		return out;
	}
	
	public boolean checkFilled(){
		if(!(this.n == 0) || !(this.m == 0)){
			return true;
		}else{
			return false;
		}
	}
	
	
	public void setEntry(int i, int j, double x){
		this.matrix[i-1][j-1] = x;
	}
	
	public String toString(){
		String out = "";
		try{
			for(double[] element : matrix){
				for(double zahl : element){
					out += " "+zahl;
				}
				out += "\n";
			}
		}catch(Exception ex){
			return "Die Matrix ist leer (null)";
		}
		
		return out;
	}
	
	public double getEntry(int i, int j){
		return matrix[i-1][j-1];
	}

}
