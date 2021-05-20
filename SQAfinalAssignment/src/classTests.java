import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class classTests {

	//test to make a new rubric
	@Test 
	void newRubric() {
	   Rubric rubric = new Rubric("Testing",2);
	   assertEquals("Testing", rubric.getCriteria());
	   assertEquals(2, rubric.getGrade());
	}
	

}
