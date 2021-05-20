import java.util.ArrayList;
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


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();
	}

}
