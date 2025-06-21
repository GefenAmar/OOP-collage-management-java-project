package RonMaorGeffenAmar;

import Exceptions.LecturerAlreadyExistException;
import Exceptions.LecturerNotFoundException;
import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {
	private String departmentName;
	private int departmentNumOfStudents;
	private LecturersArray lecturersArray;
	
	public Department(String departmentName,int departmentNumOfStudents) {
		this.departmentName = departmentName;
		this.departmentNumOfStudents = departmentNumOfStudents;
		this.lecturersArray = new LecturersArray();
	}
	public String getDepartmentName() {
		return departmentName;
	}
	
	public int getDepartmentNumOfStudents() {
		return departmentNumOfStudents;
	}

	public int getDepartmentNumOfLecturers() {
		return lecturersArray.getNumOfLecturers();
	}

	public double getDepartmentWageAverage() {
		int departmentNumOfLecturers = getDepartmentNumOfLecturers();
		if (departmentNumOfLecturers == 0) {
			return 0;
		}

		List<Lecturer> lecturers = lecturersArray.getLecturers();

		int totalWage = 0;
		for (Lecturer lecturer : lecturers) {
			totalWage += lecturer.getWage();
		}
		return (double) totalWage / departmentNumOfLecturers;
	}

	public void addLecturerToDepartment(Lecturer lecturer) throws LecturerAlreadyExistException, LecturerNotFoundException {
		if (lecturer.getLecturerDepartment() != null) {
			System.out.println("Lecturer" + lecturer.getLecturerName() + "is already assigned to a department, removing");
			lecturer.getLecturerDepartment().removeLecturerFromDepartment(lecturer.getLecturerName());
		}
		lecturersArray.addLecturer(lecturer);
		lecturer.setDepartment(this);
	}

	public void removeLecturerFromDepartment(String lecturer) throws LecturerNotFoundException {
		lecturersArray.removeLecturer(lecturer);
	}

	@Override
	public String toString() {
		return departmentName;
	}
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Department that = (Department) object;
		return departmentNumOfStudents == that.departmentNumOfStudents &&
				lecturersArray.equals(that.lecturersArray) &&
				departmentName.equals(that.departmentName);
	}

	public int getDepartmentNumOfResearchPapers() {
		return lecturersArray.getLecturersNumOfResearchPapers();
	}
}
