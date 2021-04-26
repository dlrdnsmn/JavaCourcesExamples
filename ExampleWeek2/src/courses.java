
public class courses {
	public courses() {
		System.out.println("Default Constructor");
	}

	public courses(String campName, String campTeacher, double rate) {

		this();// default constructor
		this.campName = campName;
		this.campTeacher = campTeacher;
		this.rate = rate;

		System.out.println("Constructor with parameters");

	}

	String campName;
	String campTeacher;
	double rate;
}
