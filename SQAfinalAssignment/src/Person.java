import java.util.HashMap;

public class Person {
	
	
	String name;
	HashMap<String,Integer>grades = new HashMap();
	
	
	//Constructors
	public Person() {}

	public Person(String name, HashMap<String, Integer> grades) {
		super();
		this.name = name;
		this.grades = grades;
	}
	//Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Integer> getGrades() {
		return grades;
	}

	public void setGrades(HashMap<String, Integer> grades) {
		this.grades = grades;
	}




}