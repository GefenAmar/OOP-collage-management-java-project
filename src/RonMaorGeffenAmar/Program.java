package RonMaorGeffenAmar;//Ron Maor and Geffen Amar

import Comparators.CompareDepartmentsByMembers;
import Comparators.CompareDepartmentsByPapers;
import Exceptions.*;

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
			"Show Committees & Details",
			"Compare Doctors and Professors by Number of Research Papers",
			"Copy all the details of the chosen committee to a new committee with the same name (changes are doable afterwards)",
			"Add Lecturer to Department",
			"Remove Lecturer from Department",
			"Compare Departments by number of members",
			"Compare Departments by total number of research papers of Department's members"
	};

	public static void run() {
		s = new Scanner(System.in);
		System.out.println("Enter The Name of The College:");
		String collegeName = s.nextLine();
		College college = new College(collegeName);
		int userChosen;
		do {
			showMenu();
			userChosen = getUserInput(s);
			switch (userChosen) {
				case 0 -> System.out.println("Done... Bye");
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
				case 11 -> compareDoctorsAndProfessorsByResearchPapers(college);
				case 12 -> cloneCommittee(college);
				case 13 -> addLecturerToDepartment(college);
				case 14 -> removeLecturerFromDepartment(college);
				case 15 -> compareDepartments(college, "members");
				case 16 -> compareDepartments(college, "research papers");
				default -> System.out.println("Unexpected value");
			}
		} while (userChosen != 0);
	}

	private static void removeLecturerFromDepartment(College college) {
		System.out.println("Enter Lecturer name: ");
		String lecturerName = s.nextLine();

		System.out.println("Enter Department name: ");
		String departmentName = s.nextLine();
		try {
			college.removeLecturerFromDepartment(lecturerName, departmentName);
			System.out.println("Lecturer has been removed successfully from the department.");
		} catch (LecturerNotFoundException | DepartmentNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addLecturerToDepartment(College college) {
		System.out.println("Enter Lecturer name: ");
		String lecturerName = s.nextLine();

		System.out.println("Enter Department name: ");
		String departmentName = s.nextLine();

		try {
			college.addLecturerToDepartment(lecturerName, departmentName);
			System.out.println("Lecturer has been added successfully to the department.");
		} catch (LecturerNotFoundException | DepartmentNotFoundException | LecturerAlreadyExistException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void cloneCommittee(College college) {
		System.out.println("Enter Committee Name to Clone: ");
		String committeeName = s.nextLine();

        try {
            college.cloneCommittee(committeeName);
			System.out.println("Committee cloned successfully.");
        } catch (CommitteeNotFoundException | CloneNotSupportedException | CommitteeAlreadyExistException e) {
			System.out.println(e.getMessage());
        }
    }

	private static void compareDepartments(College college, String comparisonType) {
		System.out.println("Comparing Departments by " + comparisonType);
		System.out.println("Enter name of first Department: ");
		String firstDepartmentName = s.nextLine();

		System.out.println("Enter name of second Department: ");
		String secondDepartmentName = s.nextLine();

		Department firstDepartment = college.getDepartmentsArray().getDepartmentByName(firstDepartmentName);
		if (firstDepartment == null) {
			System.out.println("Department " + firstDepartmentName + " not found.");
			return;
		}

		Department secondDepartment = college.getDepartmentsArray().getDepartmentByName(secondDepartmentName);
		if (secondDepartment == null) {
			System.out.println("Department " + secondDepartmentName + " not found.");
			return;
		}

		int compareResult;
		switch (comparisonType) {
			case "members":
				compareResult = new CompareDepartmentsByMembers().compare(firstDepartment, secondDepartment);
				break;
			case "research papers":
				compareResult = new CompareDepartmentsByPapers().compare(firstDepartment, secondDepartment);
				break;
			default:
				// should not happen as we passed a valid comparison type from the menu
				System.out.println(comparisonType + " is not a valid comparison type.");
				return;
		}
		if (compareResult > 0) {
			System.out.println(firstDepartmentName + " has more " + comparisonType + " than " + secondDepartmentName);
		} else if (compareResult < 0) {
			System.out.println(secondDepartmentName + " has more  " + comparisonType + "  than " + firstDepartmentName);
		} else {
			System.out.println(firstDepartmentName + " and " + secondDepartmentName + " have the same number of " + comparisonType +".");
		}
	}

	private static void compareDoctorsAndProfessorsByResearchPapers(College college) {
		System.out.println("Comparing Doctors and Professors by Number of Research Papers");
		System.out.println("Enter name of first Doctor/Professor: ");
		String firstName = s.nextLine();
		System.out.println("Enter name of second Doctor/Professor: ");
		String secondName = s.nextLine();

		Lecturer firstLecturer = college.getLecturerByName(firstName);
		if (!(firstLecturer instanceof  Doctor)) {
			System.out.println("Lecturer " + firstName + " not found or is not a Doctor/Professor.");
			return;
		}
		Lecturer secondLecturer = college.getLecturerByName(secondName);
		if (!(secondLecturer instanceof  Doctor)) {
			System.out.println("Lecturer " + secondName + " not found or is not a Doctor/Professor.");
			return;
		}

		int compareResult = college.compareDoctorsAndProfessorsByResearchPapers((Doctor) firstLecturer, (Doctor) secondLecturer);
		if (compareResult > 0) {
			System.out.println(firstName + " has more research papers than " + secondName);
		} else if (compareResult < 0) {
			System.out.println(secondName + " has more research papers than " + firstName);
		} else {
			System.out.println(firstName + " and " + secondName + " have the same number of research papers.");
		}
	}

	private static int getUserInput(Scanner s) {
		int choice = s.nextInt();
		s.nextLine();
		return choice;
	}

	public static void showMenu() {
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
		boolean success = false;
		int numOfStudents = -1;
		while (!success) {
			System.out.println("Enter Department Name: ");
			String departmentName = s.nextLine();

			if (numOfStudents == -1) {
				System.out.println("Enter number of students in this department: ");
				numOfStudents = s.nextInt();
			}

			Department department = new Department(departmentName, numOfStudents);
			try {
				college.addDepartmentToCollege(department);
				System.out.println("Department has been added successfully.");
				success = true;
			} catch (DepartmentAlreadyExistException e) {
				System.out.println(e.getMessage());
			}
		}
    }

	private static void removeCommitteeMember(College college) {
		System.out.println("Enter Lecturer Name: ");
		String lecturerToRemove = s.nextLine();

		System.out.println("Enter Committee Name: ");
		String committeeToRemoveFrom = s.nextLine();

        try {
            college.removeLecturerFromCommittee(lecturerToRemove, committeeToRemoveFrom);
			System.out.println("Lecturer has been removed successfully from the committee.");
        } catch (LecturerNotFoundException | CommitteeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

	private static void addCommitteeHead(College college) {
		System.out.println("Enter committee name: ");
		String committeeNameForHead = s.nextLine();

		System.out.println("Enter lecturer name: ");
		String newHeadOfCommittee = s.nextLine();

        try {
            college.newHeadOfCommittee(newHeadOfCommittee, committeeNameForHead);
        } catch (LecturerNotFoundException | CommitteeNotFoundException e) {
			System.out.println(e.getMessage());
        }
    }

	private static void addCommitteeMember(College college) {
		System.out.println("Enter Lecturer Name: ");
		String lecturerNameForCommittee = s.nextLine();

		System.out.println("Enter Committee Name: ");
		String committeeNameForLecturer = s.nextLine();

		try {
			college.addLecturerToCommittee(lecturerNameForCommittee, committeeNameForLecturer);
			System.out.println("Lecturer has been added successfully.");
		}
		catch (LecturerNotFoundException | CommitteeNotFoundException | LecturerAlreadyExistException |
               CommitteeAlreadyExistException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addCommittee(College college) {
		boolean success = false;
		while (!success) {
			System.out.println("Enter Committee Name: ");
			String committeeName = s.nextLine();
			try {
				college.addCommitteeToCollege(committeeName);
				System.out.println("Committee has been added successfully.");
				success = true;
			} catch (CommitteeAlreadyExistException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void addLecturer(College college) {
		boolean success = false;
		String lecturerDegree = null;
		String lecturerDegreeName = null;
		int lecturerID = -1;
		int lecturerWage = -1;

		while (!success) {
			System.out.println("Enter Lecturer Name: ");
			String lecturerName = s.nextLine();

			if (lecturerName == null) {
				System.out.println("Enter Lecturer Degree: " + DegreeDetails.getAllDegrees());
				lecturerDegree = s.nextLine();
			}

			if (lecturerDegreeName == null) {
				System.out.println("Enter Lecturer Degree Name: ");
				lecturerDegreeName = s.nextLine();
			}

			if (lecturerID == -1) {
				System.out.println("Enter Lecturer ID: ");
				lecturerID = s.nextInt();
				s.nextLine();
			}

			if (lecturerWage == -1) {
				System.out.println("Enter Lecturer Wage: ");
				lecturerWage = s.nextInt();
				s.nextLine();
			}

			Lecturer lecturer = new Lecturer(lecturerName, lecturerDegree, lecturerDegreeName, lecturerID, lecturerWage);
			try {
				college.addLecturerToCollege(lecturer);
				System.out.println("Lecturer has been added successfully to college.");
				success = true;
			} catch (LecturerAlreadyExistException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}