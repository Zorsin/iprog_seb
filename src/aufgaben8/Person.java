package aufgaben8;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 */

/**
 * @author Soeren Wirries
 *
 */
public class Person implements Comparable<Person> , Cloneable , SimpleTreeNode{
	/**
	 * alte Personen-Klasse aus den Aufgaben4 um weitere Funktionen ergänzt
	 */
	public String vorname;
	public String nachname;
	public String beruf;
	public String farbe;
	public String tier;
	public int geburtsjahr;
	public float groesse;
	private DecimalFormat deciFormat = new DecimalFormat("0.00");
	
	InteractivIO interIO;
	/*
	 *Neue Variablen
	 *die Funktion der Variablen wurd aus den Folien übernommen 
	 */
	private int CAPACITY;
	private SimpleTreeNode[] childs;
	private int childcnt;
	/*
	 * Bei mir gab es diesen Konstruktor schon in Aufgaben4 aber vorallem hier wird zum Clonen benoetigt
	 * Er es auch hilfreich zum erstellen des Array bzw. Testen der neuen Funktionen
	 */
	public Person(String vorname, String nachname, String beruf, String farbe, String tier, int geburtsjahr, float groesse) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.beruf = beruf;
		this.farbe = farbe;
		this.tier = tier;
		this.geburtsjahr = geburtsjahr;
		this.groesse = groesse;
		interIO = new InteractivIO();
		/*
		 * Die neuen Variablen werden inizialiesiert
		 */
		CAPACITY = 1;
		childs = new SimpleTreeNode [CAPACITY];
		childcnt = 0;
	}
	/*
	 * alter Konstruktor um neue Variablen ergaenzt
	 */
	public Person() {
		interIO = new InteractivIO();
		
		this.vorname = interIO.promtAndRead("Bitte Vornamen eingeben:");
		this.nachname = interIO.promtAndRead("Bitte Nachname eingeben:");
		this.beruf = interIO.promtAndRead("Bitte Beruf eingeben:");
		this.farbe = interIO.promtAndRead("Bitte Farbe eingeben:");
		this.tier = interIO.promtAndRead("Bitte Tier eingeben:");
		this.geburtsjahr = interIO.promtAndReadInt("Bitte Geburtsjahr eingeben:");
		this.groesse = interIO.promtAndReadFloat("Bitte Körpergröße eingeben:");
		/*
		 * Die neuen Variablen werden inizialiesiert
		 */
		CAPACITY = 1;
		childs = new SimpleTreeNode [CAPACITY];
		childcnt = 0;
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
	/**
	 * Neue Methoden die aufgrund der Inferfaces hinzugefügt werden müssen
	 */

	@Override
	public int compareTo(Person arg0) {
		/**
		 * Vergleicht die Nachnamen beider Personen
		 * Wenn count bekommt eine prositive Zahle wenn das Argument (arg0) eine Namen vor this hat
		 * Nur bei exact gleichem namen wird count 0
		 * Wenn count negertiv dann ist this im Alphabet vor dem Argument
		 */
		int count = this.nachname.compareTo(arg0.nachname);
		if(count < 0){
			return -1;
		}else if(count > 0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	public Person clone(){ // erzeugt identische Kopie
		/**
		 * erzeugt eine Identische Kopie mit allen Kindern der Person
		 */
		Person newPerson = new Person(vorname, nachname, beruf, farbe, tier,  geburtsjahr, groesse);
		
		if(childs.length > 1){
			for(SimpleTreeNode stn : childs){
			
				Person child = (Person) stn;
				newPerson.addChild(child.clone());
			}
		}
		
		return newPerson;
	}


	@Override
	public void addChild(SimpleTreeNode child) {
		/**
		 * Fügt der Person weiter Kinder hinzu
		 */
		if (childcnt >= CAPACITY) {
			CAPACITY *= 2; // Kapazitaets-Verdopplung
			SimpleTreeNode[] newchilds = new SimpleTreeNode [CAPACITY];
			for (int i = 0; i < childcnt; i++) {
				newchilds[i] = childs[i]; // alte Kinder eintragen
			}
			childs = newchilds;
		}
		childs[childcnt++] = child; // neues Kind einfuegen
		
	}

	@Override
	public int getChildCnt() {
		return childcnt;
	}

	@Override
	public SimpleTreeNode getChild(int pos) {
		return childs[pos];

	}
	
	public static void print (Person person, String indent){
		/**
		 * Gibt den Stambaum einer Person mit allen Kinder aus
		 */
		System.out.println (indent+person);
		for (int i=0; i<person.getChildCnt(); i++){
			print ((Person)person.getChild(i), indent+" ");
		}
	}

	

}
/**
 * 
 * Interface für SimpleTreeNode
 *
 */
interface SimpleTreeNode {
	public void addChild (SimpleTreeNode child);
	public int getChildCnt();
	public SimpleTreeNode getChild (int pos);
}
