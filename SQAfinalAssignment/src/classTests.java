import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class classTests {

	//test to make a new rubric
	@Test 
	void newRubric() {
	   Rubric rubric = new Rubric("Testing",2);
	   assertEquals("Testing", rubric.getCriteria());
	   assertEquals(2, rubric.getGrade());
	}
	
	//test to make a new Topic
		@Test 
		void newTopic() {
		   Rubric rubric1 = new Rubric("Design",5);
		   Rubric rubric2 = new Rubric("Implementation",4);
		   Rubric rubric3 = new Rubric("Testing",4);
		   Rubric rubric4 = new Rubric("Documentation",2);
		   
		   ArrayList<Rubric> rubrics = new ArrayList<>();
	        rubrics.add(rubric1);
	        rubrics.add(rubric2);
	        rubrics.add(rubric3);
	        rubrics.add(rubric4);
	        
	        Topic topic = new Topic("SQA", rubrics);
	        
	        assertEquals(5, topic.getRubrics().get(0).getGrade());
	        assertEquals(4, topic.getRubrics().get(1).getGrade());
	        assertEquals(4, topic.getRubrics().get(2).getGrade());
	        assertEquals(2, topic.getRubrics().get(3).getGrade());
	        assertEquals("Design", topic.getRubrics().get(0).getCriteria());
	        assertEquals("Implementation", topic.getRubrics().get(1).getCriteria());
	        assertEquals("Testing", topic.getRubrics().get(2).getCriteria());
	        assertEquals("Documentation", topic.getRubrics().get(3).getCriteria());
		}
	

}
