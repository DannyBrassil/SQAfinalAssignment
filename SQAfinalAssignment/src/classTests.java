import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

class classTests {

	
	//test to make a new rubric
	@Test 
	void newRubric() {
		Controller c = new Controller();
		
		List<String> criteria= new ArrayList<>();

		criteria.add(new String("Design"));
		criteria.add(new String("Implementation"));
		criteria.add(new String("Testing"));
		criteria.add(new String("Documentation"));

		Rubric rubric = c.newRubric("SQA", null, criteria);
		
		assertEquals("SQA", rubric.getName());
		assertEquals(null, rubric.getGrades());
		assertEquals("Design", rubric.getCriteria().get(0));
		assertEquals("Implementation", rubric.getCriteria().get(1));
		assertEquals("Testing", rubric.getCriteria().get(2));
		assertEquals("Documentation", rubric.getCriteria().get(3));
	}

	//test to make a new rubric with more than 10 criteria
		@Test 
		void newRubricMoreThanTenCriteria() {
			Controller c = new Controller();
			
			List<String> criteria= new ArrayList<>();

			//more than 10 criteria
			for(int i=0;i<11;i++) {
				criteria.add(new String("example "+i));
			}
	
			Rubric rubric = c.newRubric("SQA", null, criteria);
			assertEquals(null, rubric);
		}
		
	//test to create a person and give them grades
		@Test 
		void newPerson() {
			Controller c = new Controller();
			
			HashMap<String, Integer> personsGrades = new HashMap<String, Integer>();
			personsGrades.put("Design", 3);
			personsGrades.put("Implementation", 2);
			personsGrades.put("Testing", 2);
			personsGrades.put("Documentation", 4);

			Person person = c.newPerson("Alan Brown", personsGrades);

			assertEquals("Alan Brown", person.getName());
			assertEquals(personsGrades, person.getGrades());

		}
		
		//test to create a person and give them grades but with wrong grade (under 1 or over 5)
				@Test 
				void newPersonWrongGrade() {
					Controller c = new Controller();
					
					HashMap<String, Integer> personsGrades = new HashMap<String, Integer>();
					personsGrades.put("Design", 7);//wrong grade 
					personsGrades.put("Implementation", 2);
					personsGrades.put("Testing", 2);
					personsGrades.put("Documentation", 4);

					Person person = c.newPerson("Alan Brown", personsGrades);
					assertEquals(null, person);

				}
		
		//Get a specific rubric by name
				@Test
				public void GetRubricByName() {

					Controller c = new Controller();
					
					List<String> criteria= new ArrayList<>();

					//sample criteria
					for(int i=0;i<8;i++) {
						criteria.add(new String("example "+i));
					}
					
					Rubric r1 = c.newRubric("Test grades", null, criteria);
					Rubric rubric = c.getSpecificRubric("Test grades");

					assertEquals(r1, rubric);

				}
				
			//Add criteria to a rubric
				@Test
				public void addCriteriaToRubric() {

					Controller c = new Controller();

					ArrayList<String> criteria = new ArrayList<>();

					criteria.add(new String("Design"));
					criteria.add(new String("Implementation"));
					criteria.add(new String("Testing"));
					criteria.add(new String("Documentation"));

					Rubric rubric = c.newRubric("Example", null, criteria);

					rubric = c.addCriteria("Review", rubric);

					assertEquals("Review", rubric.getCriteria().get(4));
				}
				
			//get a list of all rubrics
				@Test
				public void listAllRubrics() {

					Controller c = new Controller();
					ArrayList<String> criteria = new ArrayList<>();

					criteria.add(new String("Design"));
					criteria.add(new String("Implementation"));
					criteria.add(new String("Testing"));
					criteria.add(new String("Documentation"));

					Rubric rubric1 = c.newRubric("rubric1", null, criteria);
					Rubric rubric2 = c.newRubric("rubric2", null, criteria);

					assertEquals("[rubric1, rubric2]", c.AllRubrics().toString());
				}
				
				//get all student grades by specific rubric
				@Test
				public void getGradesBySpecificRubric() {

					Controller c = new Controller();
					ArrayList<String> criteria = new ArrayList<>();

					criteria.add(new String("Design"));
					criteria.add(new String("Implementation"));
					criteria.add(new String("Testing"));
					criteria.add(new String("Documentation"));

					HashMap<String, Integer> gradesPerson1 = new HashMap();	
					gradesPerson1.put(criteria.get(0), 3);
					gradesPerson1.put(criteria.get(1), 2);
					gradesPerson1.put(criteria.get(2), 2);
					gradesPerson1.put(criteria.get(3), 4);
					Person person1 = c.newPerson("Alan Brown", gradesPerson1);
					
					
					HashMap<String, Integer> gradesPerson2 = new HashMap();
					gradesPerson2.put(criteria.get(0), 2);
					gradesPerson2.put(criteria.get(1), 2);
					gradesPerson2.put(criteria.get(2), 1);
					gradesPerson2.put(criteria.get(3), 3);
					Person person2 = c.newPerson("Catherine Dunne", gradesPerson2);

					List<Person> grades = new ArrayList<Person>();
					grades.add(person1);
					grades.add(person2);

					c.newRubric("Ruberic1", grades, criteria);

					List<Person> allGrades = c.allGradesBySpecificRubric("Ruberic1");

					assertEquals("{Design=3, Documentation=4, Implementation=2, Testing=2}", allGrades.get(0).getGrades().toString());
					assertEquals("{Design=2, Documentation=3, Implementation=2, Testing=1}", allGrades.get(1).getGrades().toString());
					assertEquals(grades, allGrades);

				}
				
				//get average of student grades in a rubric
				@Test
				public void getAverageGradesInRubric() {

					Controller c = new Controller();
					createRubric(c);
					double average = c.AverageGradesInRubric(c.getSpecificRubric("Ruberic1"));
					
					assertEquals(16, average);

				}
				
				//get std dev of student grades in a rubric
				@Test
				public void getStdDevofGradesInRubric() {
					Controller c = new Controller();
					createRubric(c);

					double stdev = c.stdevOfGradesInRubric(c.getSpecificRubric("Ruberic1"));
					
					assertEquals(24.08318915758459, stdev);

				}
				
				//get minimum of student grades in a rubric
				@Test
				public void getMinOfGradesInRubric() {
					Controller c = new Controller();
					createRubric(c);

					int min = c.minOfGradesInRubric(c.getSpecificRubric("Ruberic1"));
					
					assertEquals(3, min);

				}

				//get maximum of student grades in a rubric
				@Test
				public void getMaxOfGradesInRubric() {
					Controller c = new Controller();
					createRubric(c);

					int max = c.maxOfGradesInRubric(c.getSpecificRubric("Ruberic1"));
					
					assertEquals(5, max);

				}
				
				//get average of student grades in a criteria
				@Test
				public void getAverageGradesInCriteria() {

					Controller c = new Controller();
					createRubric(c);
					double average = c.AverageGradesInCriterion(c.getSpecificRubric("Ruberic1"),"Design");
					
					assertEquals(4, average);

				}
				
				//get std dev of student grades in a rubrics criterion
				@Test
				public void getStdDevofGradesInCriteria() {
					Controller c = new Controller();
					createRubric(c);

					double stdev = c.stdevOfGradesInCriterion(c.getSpecificRubric("Ruberic1"),"Design");
					
					assertEquals(1, stdev);

				}
				
				
				//get minimum of student grades in a rubrics criterion
				@Test
				public void getMinOfGradesInCriterion() {
					Controller c = new Controller();
					createRubric(c);

					int min = c.minOfGradesInCriterion(c.getSpecificRubric("Ruberic1"),"Design");
					
					assertEquals(3, min);

				}

				//get maximum of student grades in a rubrics criterion
				@Test
				public void getMaxOfGradesInCriterion() {
					Controller c = new Controller();
					createRubric(c);

					int max = c.maxOfGradesInCriterion(c.getSpecificRubric("Ruberic1"),"Design");
					
					assertEquals(5, max);

				}
				
				
				
				private void createRubric(Controller c) {
					// TODO Auto-generated method stub
					
					ArrayList<String> criteria = new ArrayList<>();

					criteria.add(new String("Design"));
					criteria.add(new String("Implementation"));
					criteria.add(new String("Testing"));
					criteria.add(new String("Documentation"));

					HashMap<String, Integer> gradesPerson1 = new HashMap();	
					gradesPerson1.put(criteria.get(0), 5);
					gradesPerson1.put(criteria.get(1), 5);
					gradesPerson1.put(criteria.get(2), 5);
					gradesPerson1.put(criteria.get(3), 5);
					Person person1 = c.newPerson("Alan Brown", gradesPerson1);
					
					
					HashMap<String, Integer> gradesPerson2 = new HashMap();
					gradesPerson2.put(criteria.get(0), 3);
					gradesPerson2.put(criteria.get(1), 3);
					gradesPerson2.put(criteria.get(2), 3);
					gradesPerson2.put(criteria.get(3), 3);
					Person person2 = c.newPerson("Catherine Dunne", gradesPerson2);

					List<Person> grades = new ArrayList<Person>();
					grades.add(person1);
					grades.add(person2);

					c.newRubric("Ruberic1", grades, criteria);
					
				}

}
