import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//class to control operations for application
public class Controller {
	
	 private final ArrayList<Person> students = new ArrayList<>();
	 private final ArrayList<Rubric> rubrics = new ArrayList<>();
	 
	
	
	public Controller() {
		
		
		
	}
	
	//Create New Rubric
		public Rubric newRubric(String name, List<Person>studentsGrades, List<String> criteria) {
			Rubric rubric = null;
				if (criteria.size() > 10) {
					
				}else {
					rubric = new Rubric(name, studentsGrades, criteria);
					rubrics.add(rubric);
				}
				return rubric;
		}
		
	//create a new person 
		public Person newPerson(String name, HashMap<String, Integer> grades) {
			Person person=null;
			boolean wrongGrade=false;;
					
			for (Integer i : grades.values()) {
				if (i > 5 || i < 1) {
					wrongGrade=true;
						}
					}
			
			if(wrongGrade==true) {
				
			}else {
				person= new Person(name, grades);
			}
			
			return person;
		}
		
	// Get a specific Rubric by name
		public Rubric getSpecificRubric(String name) {
			Rubric r=null;
			for (Rubric rubric : rubrics) {
				if (rubric.getName().equals(name)) {
					r= rubric;
				}
			}
			return r;
		}
		
	
		//add a criteria to a rubric
		public Rubric addCriteria(String criteria, Rubric r) {

			List list = new ArrayList<String>();
			list.addAll(r.getCriteria());

			if (list.size() < 10) {
				list.add(criteria);
			}
			r.setCriteria(list);
			return r;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();
	}

}
