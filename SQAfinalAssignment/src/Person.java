
public class Person {
	
	private String name;
	private Topic topic;
	
	//constructors
	public Person() {}
	
	public Person(String name, Topic topic) {
		super();
		this.name = name;
		this.topic = topic;
	}
	//getters & setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
	
	

}
