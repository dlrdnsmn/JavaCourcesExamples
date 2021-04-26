
public class Main {

	public static void main(String[] args) {
		courses cource1 = new courses(" Java&React Kampý", "Engin Demiroð", 0.50);

		courses cource2 = new courses();
		cource2.campName = "C# & Angular";
		cource2.campTeacher = "Engin Demiroð";
		cource2.rate = 0.80;

		courses[] courses = { cource1, cource2 };

		for (courses course : courses) {
			System.out.println("courses name: " + course.campName + "\n" + "Kamp Eðitmeni: " + course.campTeacher + "\n"
					+ "Tamamlanma Oraný: " + course.rate);

		}

	}

}
