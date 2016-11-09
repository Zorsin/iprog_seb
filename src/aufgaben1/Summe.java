package aufgaben1;
/**
 * 
 * @author Sören Wirries
 *
 */
class Summe {

	public static void main(String[] args) {
		System.out.println(summe(21980));

	}
	
	private static int summe(int zahl){
		return zahl <= 1 ? zahl : summe(zahl -1) + zahl;
	}

}
