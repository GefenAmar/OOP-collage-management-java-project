package RonMaorGeffenAmar;//Ron Maor and Geffen Amar
import java.util.Scanner;

public class Program {
	public static Scanner s;
	public static void main(String[] args) {
		s = new Scanner(System.in);
		run();
		s.close();
	}

	private static final String[] MENU = {
			"Exit RonMaorGeffenAmar.Program",
			"Add RonMaorGeffenAmar.Lecturer",
			"Add RonMaorGeffenAmar.Committee",
			"Book a RonMaorGeffenAmar.Lecturer to a RonMaorGeffenAmar.Committee",
			"New Head of RonMaorGeffenAmar.Committee",
			"Remove RonMaorGeffenAmar.Lecturer from a RonMaorGeffenAmar.Committee",
			"Add RonMaorGeffenAmar.Department",
			"Show Lecturers Total Average Wage",
			"Show Lecturers Average Wage Per RonMaorGeffenAmar.Department",
			"Show Lecturers & Details",
			"Show Committees & Details"
			// Add more options
	};

	public static void run() {
		s = new Scanner(System.in);
		System.out.println("Enter The Name of The RonMaorGeffenAmar.College:");
		String collegeName = s.nextLine();
		College college = new College(collegeName);
		int userChosen;
		do {
			userChosen = showMenu(s);
			switch (userChosen) {
				case 0 ->
						System.out.println("Done... Bye");

				case 1 -> addLecturer(college);
				case 2 -> addCommittee(college);
				case 3 -> addCommitteeMember(college);
				case 4 -> addCommitteeHead(college);
				case 5 -> removeCommitteeMember(college);
				case 6 -> addDepartment(college);
				case 7 -> showTotalAverageWage(college);
				case 8 -> showDepartmentAverageWage(college);
				case 9 -> college.showLecturersInCollege();
				case 10 -> college.showCommitteesInCollege();

				default -> System.out.println("Unexpected value");
			}
		} while (userChosen != 0);
	}

	public static int showMenu(Scanner s) {
		System.out.println("\n====== Menu =======");
		for (int i = 0; i < MENU.length; i++) {
			System.out.println(i + ". " + MENU[i]);
		}
		System.out.println("Please enter your choice : ");
		return s.nextInt();
	}

	private static void showTotalAverageWage(College college) {
		double totalAverageWage = college.getTotalAverageWage();
		System.out.println("Total Average Wage: " + totalAverageWage);
	}

	private static void showDepartmentAverageWage(College college) {
		System.out.println("Choose a department");
		String name = s.nextLine();

		double averageWageByDepartment = college.getAverageWageByDepartment(name);
		System.out.println("RonMaorGeffenAmar.Department Wage Average: " + averageWageByDepartment);
	}

	private static void addDepartment(College college) {
		System.out.println("Enter RonMaorGeffenAmar.Department Name: ");
		String departmentName = s.nextLine();
		while (college.isDepartmentExistInCollege(departmentName)) {
			System.out.print("RonMaorGeffenAmar.Department name already exist. Try again: ");
			departmentName = s.nextLine();
		}
		System.out.println("Enter number of students in this department: ");
		int numOfStudents = s.nextInt();

		Department department = new Department(departmentName,numOfStudents);
		college.addDepartmentToCollege(department);
	}

	private static void removeCommitteeMember(College college) {
		System.out.println("Enter RonMaorGeffenAmar.Lecturer Name: ");
		String lecturerToRemove = s.nextLine();

		System.out.println("Enter RonMaorGeffenAmar.Committee Name: ");
		String committeeToRemoveFrom = s.nextLine();

		college.removeLecturerFromCommittee(lecturerToRemove, committeeToRemoveFrom);
	}

	private static void addCommitteeHead(College college) {
		System.out.println("Enter committee name: ");
		String committeeNameForHead = s.nextLine();

		System.out.println("Enter lecturer name: ");
		String newHeadOfCommittee = s.nextLine();

		college.NewHeadOfCommittee(newHeadOfCommittee, committeeNameForHead);
	}

	private static void addCommitteeMember(College college) {
		System.out.println("Enter RonMaorGeffenAmar.Lecturer Name: ");
		String lecturerNameForCommittee = s.nextLine();

		System.out.println("Enter RonMaorGeffenAmar.Committee Name: ");
		String committeeNameForLecturer = s.nextLine();

		boolean addLecturerToCommitteeSuccess = college.addLecturerToCommittee(lecturerNameForCommittee, committeeNameForLecturer);

		if (!addLecturerToCommitteeSuccess) {
			System.out.println("Failed to add RonMaorGeffenAmar.Lecturer to the committee.");
		}

		System.out.println("RonMaorGeffenAmar.Lecturer has been added successfully.");
	}

	private static void addCommittee(College college) {
		System.out.println("Enter RonMaorGeffenAmar.Committee Name: ");
		String committeeName = s.nextLine();

		while (college.isCommitteeExistInCollege(committeeName)) {
			System.out.print("RonMaorGeffenAmar.Committee name already exist. Try again: ");
			committeeName = s.nextLine();
		}

		Committee committee = new Committee(committeeName);
		college.addCommitteeToCollege(committee);
	}

	private static void addLecturer(College college) {
		System.out.println("Enter RonMaorGeffenAmar.Lecturer Name: ");
		String lecturerName = s.nextLine();
		while (college.isLecturerExistInCollege(lecturerName)) {
			System.out.print("RonMaorGeffenAmar.Lecturer name already exist. Try again: ");
			lecturerName = s.nextLine();
		}
		s.nextLine();
		System.out.println("Enter RonMaorGeffenAmar.Lecturer RonMaorGeffenAmar.Degree: First/Second/Doctor/Professor ");
		String lecturerDegree = s.nextLine();

		System.out.println("Enter RonMaorGeffenAmar.Lecturer RonMaorGeffenAmar.Degree Name: ");
		String lecturerDegreeName = s.nextLine();

		System.out.println("Enter RonMaorGeffenAmar.Lecturer RonMaorGeffenAmar.Department: ");
		String lecturerDepartment = s.nextLine();
		Department departmentLinkedTo = college.getDepartmentByName(lecturerDepartment);


		System.out.println("Enter RonMaorGeffenAmar.Lecturer ID: ");
		int lecturerID = s.nextInt();
		s.nextLine();

		System.out.println("Enter RonMaorGeffenAmar.Lecturer Wage: ");
		int lecturerWage = s.nextInt();
		s.nextLine();

		Lecturer lecturer = new Lecturer(
				lecturerName,
				lecturerDegree,
				lecturerDegreeName,
				departmentLinkedTo,
				lecturerID,
				lecturerWage
		);

		college.addLecturerToCollege(lecturer);
	}
}
