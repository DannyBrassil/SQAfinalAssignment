import java.util.ArrayList;
//class that represents the rubric
public class Rubric {

	private String criteria;
	private int grade;
	
	
	//constructors
	public Rubric() {
		
	}
	public Rubric(String criteria, int grade) {
		super();
		this.criteria = criteria;
		this.grade = grade;
	}
	
	//getters/setters
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
	
	
	
	
}
