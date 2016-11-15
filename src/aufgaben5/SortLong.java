
package aufgaben5;

import java.util.ArrayList;

/**
 * @author Soeren Wirries
 *
 */
class SortLong {

	
	public static void main(String[] args) {
		InteractivIO mIO = new InteractivIO();
		
		mIO.write("Bitte die Zahlen zum Sortieren eingeben (leer Eingabe bricht einlesen ab)");
		ArrayList<Long> longList = new ArrayList<Long>();
		boolean running = true;
		do{
			String zahl = mIO.promtAndRead("Bitte Zahl(long) eingeben:");
			if(zahl.equals("")){
				running = false;
			}else{
				try{
					longList.add(Long.parseLong(zahl));
				}catch(Exception ex){
					running = false;
				}
			}
			
		}while(running);
		
		long[] longArray = new long[longList.size()];
		int i = 0;
		for(long element : longList){
			longArray[i] = element;
			i++;
		}
		long[] sortedArray = sort(longArray);
		
		String outTxt = "Zahlen sortiert: ";
		for(long element : sortedArray){
			outTxt += element + " ";
		}
	
		mIO.write(outTxt);

	}
	

	private static long[] sort(long[] toSort) {
		long tempSort;
		
		for(int i=1; i < toSort.length; i++) {
			
			for(int k=0; k < toSort.length-i ; k++) {
				
				if(toSort[k] > toSort[k+1]) {
					
					tempSort = toSort[k];
					
					toSort[k] = toSort[k+1];
					
					toSort[k+1] = tempSort;
				}
				
			}
		}
		return toSort;
	}
	

}
