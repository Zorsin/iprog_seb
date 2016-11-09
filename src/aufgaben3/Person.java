package aufgaben3;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 */

/**
 * @author Sören Wirries
 *
 */
public class Person {
	
	public String vorname;
	public String nachname;
	public String beruf;
	public String farbe;
	public String tier;
	public int geburtsjahr;
	public float groesse;
	private DecimalFormat deciFormat = new DecimalFormat("0.00");
	
	InteractivIO interIO;
	
	public Person(String vorname, String nachname, String beruf, String farbe, String tier, int geburtsjahr, float groesse) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.beruf = beruf;
		this.farbe = farbe;
		this.tier = tier;
		this.geburtsjahr = geburtsjahr;
		this.groesse = groesse;
		interIO = new InteractivIO();
	}
	
	public Person() {
		interIO = new InteractivIO();
		
		this.vorname = interIO.promtAndRead("Bitte Vornamen eingeben:");
		this.nachname = interIO.promtAndRead("Bitte Nachname eingeben:");
		this.beruf = interIO.promtAndRead("Bitte Beruf eingeben:");
		this.farbe = interIO.promtAndRead("Bitte Farbe eingeben:");
		this.tier = interIO.promtAndRead("Bitte Tier eingeben:");
		this.geburtsjahr = interIO.promtAndReadInt("Bitte Geburtsjahr eingeben:");
		this.groesse = interIO.promtAndReadFloat("Bitte Körpergröße eingeben:");
	}
	
	public String toString(){
		String out = "";
		out = vorname + ";" + nachname + ";" + beruf + ";" + farbe + ";" + tier + ";" + getAge()  + ";" + assignSize();
		
		return out;
	}
	
	public boolean isFilled(){
		if(vorname.equals("") || nachname.equals("")){
			return false;
		}else{
			return true;
		}
	}
	
	public void show(){
		interIO.write("Vollständiger Name: "+vorname + " " + nachname);
		interIO.write("Beruf: "+beruf);
		interIO.write("Lieblingsfarbe: "+farbe);
		interIO.write("Lieblingstier: "+tier);
	}
	
	public int getAge(){
		Calendar calendar = Calendar.getInstance();
		
		int age = calendar.get(Calendar.YEAR) - geburtsjahr;
		
		return age;
	}
	
	public String assignSize(){
		
		if(groesse < 1.55f){
			return "klein";
		}else if(groesse < 1.80f){
			return "mittel";
		}else{
			return "groß";
		}
		
	}
	
	public String getFullname(){
		return this.vorname + " " + this.nachname;
	}
	
	public void compare(Person other){
		if(this.geburtsjahr == other.geburtsjahr){
			
			interIO.write("Person "+other.getFullname() + " und Person "+this.getFullname()+" sind gleich alt");
			
		}else if(this.geburtsjahr > other.geburtsjahr){
			
			int diff = this.geburtsjahr - other.geburtsjahr;
			interIO.write("Person "+other.getFullname() + " ist "+diff+" Jahr(e) älter");
			
		}else{
			
			int diff = other.geburtsjahr - this.geburtsjahr;
			interIO.write("Person "+this.getFullname() + " ist "+diff+" Jahr(e) älter");
		}
		
		if(this.groesse == other.groesse){
			interIO.write("Person "+other.getFullname() + " und Person "+this.getFullname()+" sind gleich groß");
			
		}else if(this.groesse > other.groesse){
			
			double diff = this.groesse - other.groesse;
			interIO.write("Person "+this.getFullname() + " ist "+deciFormat.format(diff)+" Meter größer");
			
		}else {
			
			float diff = other.groesse - this.groesse;
			interIO.write("Person "+other.getFullname() + " ist "+deciFormat.format(diff)+" Meter größer");
			
		}
		
	}
	

}
