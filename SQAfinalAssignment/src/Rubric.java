
import java.util.ArrayList;
import java.util.List;

//class to represent a rubric with a name , students and their grades and criteria in the rubric
public class Rubric {
	
	String name;
	List<Person>grades = new ArrayList<>();
	List<String> criteria = new ArrayList<String>();
	
	
	//Constructors
	public Rubric() {}

	public Rubric(String name, List<Person> grades, List<String> criteria) {
		super();
		this.name = name;
		this.grades = grades;
		this.criteria = criteria;
	}

	//Getters & Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getGrades() {
		return grades;
	}

	public void setGrades(List<Person> grades) {
		this.grades = grades;
	}

	public List<String> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<String> criteria) {
		this.criteria = criteria;
	}

	
	

}