import java.util.ArrayList;

public class Topic {
	
	private String nameOfTopic;
	private ArrayList<Rubric> rubrics;
	
	//constructors 
	public Topic() {}
	
	public Topic(String nameOfTopic, ArrayList<Rubric> rubrics) {
		super();
		this.nameOfTopic = nameOfTopic;
		this.rubrics = rubrics;
	}
	
//getters & setters
	public String getNameOfTopic() {
		return nameOfTopic;
	}

	public void setNameOfTopic(String nameOfTopic) {
		this.nameOfTopic = nameOfTopic;
	}

	public ArrayList<Rubric> getRubrics() {
		return rubrics;
	}

	public void setRubrics(ArrayList<Rubric> rubrics) {
		this.rubrics = rubrics;
	}
	
}
