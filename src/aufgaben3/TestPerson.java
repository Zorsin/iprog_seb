package aufgaben3;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Sören Wirries
 *
 */
public class TestPerson {
	
	
	public static void main(String[] args) {
		InteractivIO interIO = new InteractivIO();
		/*
		boolean running = true;
		ArrayList<Person> listPerson = new ArrayList<Person>();
		
		while(running){
			Person person = new Person();
			if(person.isFilled()){
				listPerson.add(person);
			}else{
				running = false;
			}
		}
		
		for(Person element : listPerson){
			interIO.write("\r\nPerson als String:"+element.toString());
		}
		
		int num = interIO.promtAndReadInt("Zahl angeben(beginnt mit Null!):");
		
		interIO.write("Person Nr."+num+" als String:"+listPerson.get(num).toString());
		*/
		
		Person p1 = new Person();
		Person p2 = new Person();
		interIO.write("Person 1 als String:" + p1.toString());
		interIO.write("Person 2 als String:" + p2.toString());
		p1.compare(p2);
		
		
	}

}
