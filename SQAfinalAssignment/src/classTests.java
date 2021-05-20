import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

			for(int i=0;i<11;i++) {
				criteria.add(new String("example "+i));
			}
	
			Rubric rubric = c.newRubric("SQA", null, criteria);
			assertEquals(null, rubric);
		}
	

}
