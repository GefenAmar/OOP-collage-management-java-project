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
			"Exit Program",
			"Add Lecturer",
			"Add Committee",
			"Book a Lecturer to a Committee",
			"New Head of Committee",
			"Remove Lecturer from a Committee",
			"Add Department",
			"Show Lecturers Total Average Wage",
			"Show Lecturers Average Wage Per Department",
			"Show Lecturers & Details",
			"Show Committees & Details"
			// Add more options
	};

	public static void run() {
		s = new Scanner(System.in);
		System.out.println("Enter The Name of The College:");
		String collegeName = s.nextLine();
		College college = new College(collegeName);
		int userChosen;
		do {
			showMenu(s);
			userChosen = getUserInput(s);
			switch (userChosen) {
				case 0 ->System.out.println("Done... Bye");
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

	private static int getUserInput(Scanner s) {
		int choice = s.nextInt();
		s.nextLine();
		return choice;
	}

	public static void showMenu(Scanner s) {
		System.out.println("\n====== Menu =======");
		for (int i = 0; i < MENU.length; i++) {
			System.out.println(i + ". " + MENU[i]);
		}
	}

	private static void showTotalAverageWage(College college) {
		double totalAverageWage = college.getTotalAverageWage();
		System.out.println("Total Average Wage: " + totalAverageWage);
	}

	private static void showDepartmentAverageWage(College college) {
		System.out.println("Choose a department");
		String name = s.nextLine();

		double averageWageByDepartment = college.getAverageWageByDepartment(name);
		System.out.println("Department Wage Average: " + averageWageByDepartment);
	}

	private static void addDepartment(College college) {
		System.out.println("Enter Department Name: ");
		String departmentName = s.nextLine();
		while (college.isDepartmentExistInCollege(departmentName)) {
			System.out.print("Department name already exist. Try again: ");
			departmentName = s.nextLine();
		}
		System.out.println("Enter number of students in this department: ");
		int numOfStudents = s.nextInt();

		Department department = new Department(departmentName,numOfStudents);
		college.addDepartmentToCollege(department);
	}

	private static void removeCommitteeMember(College college) {
		System.out.println("Enter Lecturer Name: ");
		String lecturerToRemove = s.nextLine();

		System.out.println("Enter Committee Name: ");
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
		System.out.println("Enter Lecturer Name: ");
		String lecturerNameForCommittee = s.nextLine();

		System.out.println("Enter Committee Name: ");
		String committeeNameForLecturer = s.nextLine();

		boolean addLecturerToCommitteeSuccess = college.addLecturerToCommittee(lecturerNameForCommittee, committeeNameForLecturer);

		if (!addLecturerToCommitteeSuccess) {
			System.out.println("Failed to add Lecturer to the committee.");
		}

		System.out.println("Lecturer has been added successfully.");
	}

	private static void addCommittee(College college) {
		System.out.println("Enter Committee Name: ");
		String committeeName = s.nextLine();

		while (college.isCommitteeExistInCollege(committeeName)) {
			System.out.print("Committee name already exist. Try again: ");
			committeeName = s.nextLine();
		}

		Committee committee = new Committee(committeeName);
		college.addCommitteeToCollege(committee);
	}

	private static void addLecturer(College college) {
		System.out.println("Enter Lecturer Name: ");
		String lecturerName = s.nextLine();
		while (college.isLecturerExistInCollege(lecturerName)) {
			System.out.print("Lecturer name already exist. Try again: ");
			lecturerName = s.nextLine();
		}
		System.out.println("Enter Lecturer Degree: First/Second/Doctor/Professor ");
		String lecturerDegree = s.nextLine();

		System.out.println("Enter Lecturer Degree Name: ");
		String lecturerDegreeName = s.nextLine();

		System.out.println("Enter Lecturer Department: ");
		String lecturerDepartment = s.nextLine();
		Department departmentLinkedTo = college.getDepartmentByName(lecturerDepartment);

		System.out.println("Enter Lecturer ID: ");
		int lecturerID = s.nextInt();
		s.nextLine();

		System.out.println("Enter Lecturer Wage: ");
		int lecturerWage = s.nextInt();
		s.nextLine();

		Lecturer lecturer = new Lecturer(lecturerName, lecturerDegree, lecturerDegreeName, lecturerID, lecturerWage);
		college.addLecturerToCollege(lecturer);
		System.out.println("Lecturer has been added successfully to college.");
		boolean addedToDepartment = departmentLinkedTo.addLecturerToDepartment(lecturer);
		if (addedToDepartment) {
			lecturer.setDepartment(departmentLinkedTo);
			System.out.println("Lecturer has been added successfully to department.");
		} else {
			System.out.println("Failed to add lecturer to department.");
		}
	}
}
