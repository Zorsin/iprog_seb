package aufgaben6;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
/**
 * @author Soeren Wirries
 *
 */
class InteractivIO {
	
	private BufferedReader buffRead;
	
	public InteractivIO(){
		
		buffRead = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public void write(String string){
		this.writeAndFlush(string);
		
	}
	
	public String promtAndRead(String text){
		this.writeAndFlush(text);
		String output = "";
		try {
			output = buffRead.readLine();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		return output;
	}
	
	private void writeAndFlush(String string){
		System.out.println(string);
		System.out.flush();
	}
	
	public int promtAndReadInt(String text){
		
		this.writeAndFlush(text);
		int output = 0;
		String line = "";
		try {
			line = buffRead.readLine();
			output = Integer.parseInt(line);
		}catch(Exception ex){
			//System.out.println(ex.toString());
			
			if(line.equals("")){
				System.out.println("Die Eingabe war leer. Das Programm wird beendet!");
				return 0;
			}else{
				System.out.println("Dies war keine ganzzahlige Zahl!");
				return this.promtAndReadInt(text);
			}
			
		}
		return output;
		
	}
	
	public long promtAndReadLong(String text){
		
		this.writeAndFlush(text);
		long output = 0;
		String line = "";
		try {
			line = buffRead.readLine();
			output = Long.parseLong(line);
		}catch(Exception ex){
			//System.out.println(ex.toString());
			
			if(line.equals("")){
				System.out.println("Die Eingabe war leer. Das Programm wird beendet!");
				return 0;
			}else{
				System.out.println("Dies war keine ganzzahlige Zahl!");
				return this.promtAndReadLong(text);
			}
			
		}
		return output;
		
	}
	
	public double promtAndReadDouble(String text){
		
		this.writeAndFlush(text);
		double output = 0;
		String line = "";
		try {
			line = buffRead.readLine();
			output = Double.parseDouble(line);
		}catch(Exception ex){
			//System.out.println(ex.toString());
			
			if(line.equals("")){
				System.out.println("Die Eingabe war leer. Das Programm wird beendet!");
				return 0;
			}else{
				System.out.println("Dies war keine Zahl!");
				return this.promtAndReadDouble(text);
			}
			
		}
		return output;
		
	}
	
	public float promtAndReadFloat(String text){
		
		this.writeAndFlush(text);
		float output = 0;
		String line = "";
		try {
			line = buffRead.readLine();
			output = Float.parseFloat(line);
		}catch(Exception ex){
			//System.out.println(ex.toString());
			
			if(line.equals("")){
				System.out.println("Die Eingabe war leer. Das Programm wird beendet!");
				return 0;
			}else{
				System.out.println("Dies war keine Zahl!");
				return this.promtAndReadFloat(text);
			}
			
		}
		return output;
		
	}
	
	public BigInteger promtAndReadBigInt(String text){
		
		this.writeAndFlush(text);
		BigInteger output = new BigInteger("0");
		String line = "";
		try {
			line = buffRead.readLine();
			output = new BigInteger(line);
		}catch(Exception ex){
			//System.out.println(ex.toString());
			
			if(line.equals("")){
				System.out.println("Die Eingabe war leer. Das Programm wird beendet!");
				return output;
			}else{
				System.out.println("Dies war keine Zahl!");
				return this.promtAndReadBigInt(text);
			}
			
		}
		return output;
		
	}
	
	public BigDecimal promtAndReadBigDeciaml(String text){
		
		this.writeAndFlush(text);
		BigDecimal output = new BigDecimal("0");
		String line = "";
		try {
			line = buffRead.readLine();
			output = new BigDecimal(line);
		}catch(Exception ex){
			//System.out.println(ex.toString());
			
			if(line.equals("")){
				System.out.println("Die Eingabe war leer. Das Programm wird beendet!");
				return output;
			}else{
				System.out.println("Dies war keine Zahl!");
				return this.promtAndReadBigDeciaml(text);
			}
			
		}
		return output;
		
	}
	
	

}
