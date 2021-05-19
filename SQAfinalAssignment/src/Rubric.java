import java.util.ArrayList;
//class that represents the rubric
public class Rubric {

	private ArrayList<Criterion> criteria = new ArrayList<>();
	String Student;
	
	//constructors
	public Rubric() {}
	public Rubric(ArrayList<Criterion> criteria, String student) {
		super();
		this.criteria = criteria;
		Student = student;
	}
	
	//getters and setters
	public ArrayList<Criterion> getCriteria() {
		return criteria;
	}
	public void setCriteria(ArrayList<Criterion> criteria) {
		this.criteria = criteria;
	}
	public String getStudent() {
		return Student;
	}
	public void setStudent(String student) {
		Student = student;
	}
	
	
}
