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

		//get list of all rubrics
		 public ArrayList<String> AllRubrics() {
			 ArrayList<String> names = new ArrayList<String>();
			 for (Rubric rubric : rubrics) {
		            names.add(rubric.getName());
		        }
			return names; 
		    }
		 
		// Get Grades in a Specific Rubric
			public List<Person>allGradesBySpecificRubric(String name){
				
				List<Person>allGrades= new ArrayList<Person>();
				
				for(Rubric r : rubrics) {
					if(r.getName().equalsIgnoreCase(name)) {
						for(Person aGrade: r.getGrades()) {
							allGrades.add(aGrade);
						}
					}
				}
				return allGrades;
			}
			
			//get average score of all student grades in a rubric
			public double AverageGradesInRubric(Rubric rubric) {
				
				int totalGrade =0;
				for(Person grade :rubric.getGrades()) {
					for (int f : grade.getGrades().values()) {
						totalGrade += f;
					}
				}
				double average = Math.round(totalGrade/rubric.getGrades().size());
				return average;
			}
			
			//find standard deviation of all student grades in a rubric
			public double stdevOfGradesInRubric(Rubric rubric) {
				double total=0;
				
				double mean = AverageGradesInRubric(rubric);
				for(Person grade :rubric.getGrades()) {
					for (int f : grade.getGrades().values()) {
						total += Math.pow(f - mean, 2);
					}
				}
				
				return Math.sqrt(total/rubric.getGrades().size());
				
			}
			
			//find max score of all student grades in a rubric
			public int maxOfGradesInRubric(Rubric rubric) {
				int max=0;
				for(Person grade:rubric.getGrades()) {
					for (int f : grade.getGrades().values()) {
						if(f>max) {
							max=f;
						}
					}
				}
				
				return max;
				
			}
			
			//find min score of all student grades in a rubric
			public int minOfGradesInRubric(Rubric rubric) {
				int min=6;
				for(Person grade:rubric.getGrades()) {
					for (int f : grade.getGrades().values()) {
						if(f<min) {
							min=f;
						}
					}
				}
				
				return min;
				
			}
			
			//get average score of all student grades in a criterion
			public double AverageGradesInCriterion(Rubric rubric, String criterion) {
				double avg=0;
				for(Person grade:rubric.getGrades()) {
					avg+=grade.getGrades().get(criterion);
				}
				
				avg = avg/rubric.getGrades().size();
				return avg;
			}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();
	}

}
