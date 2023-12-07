import java.io.*;
import java.util.*;

public class Student implements Serializable, Comparable, Cloneable{
	private double GPA;
	private String name;

	public Student(String n, double gpa) {
		name = n;
		GPA = gpa;
	}

	public Student(Student other) {
		this.name = other.name;
		this.GPA = other.GPA;
	}

	public static void main(String[] args) {
		try {
			writeObjectToFile();
			List<Student> students = readAllObjectsFromFile();

			for (Student student : students) {
				System.out.println(student.toString());
			}

			QuizTracker originalTracker = new QuizTracker();
			originalTracker.add(new QuizScore(80));
			originalTracker.add(new QuizScore(90));
			QuizTracker clonedTracker = originalTracker.clone();
			originalTracker.add(new QuizScore(95));

			System.out.println("Original Tracker: " + originalTracker.getScores());
			System.out.println("Cloned Tracker: " + clonedTracker.getScores());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static Student readObjectFromFile() throws IOException, ClassNotFoundException {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.obj"))) {
			return (Student) is.readObject();
		}
	}

	private static List<Student> readAllObjectsFromFile() throws IOException, ClassNotFoundException {
		List<Student> students = new ArrayList<>();
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.obj"))) {
			while (true) {
				Student student = (Student) is.readObject();
				students.add(student);
			}
		} catch (EOFException ignored) {
			// Ignore the end of file exception, indicating the end of the file.
		}
		return students;
	}

	private static void writeObjectToFile() throws IOException {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.obj"))) {

			Student[] studentsArray = {
					new Student("Nguyen", 3.5),
					new Student("Joe", 2.4),
					new Student("Bob", 4.0),
					new Student("Dave", 3.2),
					new Student("Tom", 1.5),
					new Student("Harry", 2.9),
					new Student("Peter", 3.7),
					new Student("Gabe", 3.2),
					new Student("Cody", 2.0),
					new Student("Ryan", 2.3),
					new Student("Walter", 3.9)
			};

			for (Student student : studentsArray) {
				os.writeObject(student);
			}
		}
	}

	@Override
	public String toString() {
		return "Student Name: \t" + name + "\nGPA:\t\t\t" + GPA;
	}

	@Override
	public int compareTo(Object obj) {
		Student b = (Student) obj;
		return Double.compare(this.GPA, b.GPA);
	}

	@Override
	public Student clone() {
		return new Student(this);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public String getName() {
		return name;
	}

	public double getGPA() {
		return GPA;
	}
}
