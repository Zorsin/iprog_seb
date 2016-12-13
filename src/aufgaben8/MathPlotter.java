/**
 * 
 */
package aufgaben8;

/**
 * @author Soeren Wirries
 *
 */
class MathPlotter {

	/**
	 * @param args
	 */
	static double start = 0;
	static double end = 0;
	static double sprung = 0;
	
	public static void main(String[] args) {
		
		InteractivIO mIO = new InteractivIO();
		while(true){
			
			String func = mIO.promtAndRead("Bitte Namen einer Funktion angeben. Folgende stehen zur Verfuegung: sin, cos, exp, log, sqrt, tan, square, cube, quad");
			if(func.equals("stop")){
				mIO.write("Funktion wird beendet");
				break;
			}
			
			start = mIO.promtAndReadDouble("Bitte Start-Wert eingeben: ");
			do{
				end = mIO.promtAndReadDouble("Bitte End-Wert eingeben (muss groesser als Start sein):");
			}while(end < start);
			
			do{
				sprung = mIO.promtAndReadDouble("Bitte Schrittweite eingeben (muss groesser als 0 sein):");
			}while(sprung < 0d);
			
			
			switch(func){
				case "sin":
					plot(new Method(){
						public double compute(double value){
							return Math.sin(value);
						}
					});
					break;
				case "cos":
					plot(new Method(){
						public double compute(double value){
							return Math.cos(value);
						}
					});
					break;
				case "tan":
					plot(new Method(){
						public double compute(double value){
							return Math.tan(value);
						}
					});
					break;
				case "sqrt":
					plot(new Method(){
						public double compute(double value){
							return Math.sqrt(value);
						}
					});
					break;
				case "exp":
					plot(new Method(){
						public double compute(double value){
							return Math.exp(value);
						}
					});
					break;
				case "log":
					plot(new Method(){
						public double compute(double value){
							return Math.log(value);
						}
					});
					break;
				case "square":
					plot(new Method(){
						public double compute(double value){
							return value*value;
						}
					});
					break;
				case "cube":
					plot(new Method(){
						public double compute(double value){
							return value * value * value;
						}
					});
					break;
				case "quad":
					plot(new Method(){
						public double compute(double value){
							return value * value * value *value;
						}
					});
					break;
				case "quint":
					plot(new Method(){
						public double compute(double value){
							return value * value * value * value * value;
						}
					});
					break;
				default:
					mIO.write("Funktionsname ungültig! Funktion startet erneut.");
			}
		}

	}
	public static void plot(Method meth){
		for(double i = start; i <= end; i += sprung){
			System.out.println(meth.compute(i));
		}
	}
	
	
}

interface Method {
	public double compute (double value);
}
