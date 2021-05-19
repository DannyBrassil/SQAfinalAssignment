
//class that represents criteria in a rubric
public class Criterion {
	private String title;
	private int score;
	
	
	//Constructors
	
	public Criterion() {}
	
	public Criterion(String title, int score) {
		this.title = title;
		this.score = score;
	}


	//getter & setters
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	

}
