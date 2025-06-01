package RonMaorGeffenAmar;

import java.util.Arrays;

public class Department {
	private String departmentName;
	private int departmentNumOfStudents,departmentNumOfLecturers;
	private Lecturer[] lecturersArray;
	
	public Department(String departmentName,int departmentNumOfStudents) {
		this.departmentName = departmentName;
		this.departmentNumOfStudents = departmentNumOfStudents;
		this.lecturersArray = new Lecturer[departmentNumOfLecturers];
		this.departmentNumOfLecturers = 0;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public int getDepartmentNumOfStudents() {
		return departmentNumOfStudents;
	}
	
	public int getDepartmentNumOfLecturers() {
		return departmentNumOfLecturers;
		
	}
	
	public double getDepartmentWageAverage() {
		if (departmentNumOfLecturers == 0) return 0;
		
		int totalWage = 0;
		for (int i=0; i < departmentNumOfLecturers; i++) {
			totalWage += lecturersArray[i].getLecturerWage();
		}
		return (double) totalWage / departmentNumOfLecturers;
	}


	public boolean addLecturerToDepartment(Lecturer lecturer) {
		if (lecturer.getLecturerDepartment() != null) {
			System.out.println("Lecturer" + lecturer.getLecturerName() + "is already assigned to a department.");
			return false;
		}
		
		if (departmentNumOfLecturers == lecturersArray.length) {
			int arraySize = lecturersArray.length;
			if (arraySize == 0) {
				arraySize = 1;
			}
			lecturersArray = Arrays.copyOf(lecturersArray, arraySize * 2);
		}
		
		lecturersArray[departmentNumOfLecturers] = lecturer;
		departmentNumOfLecturers++;
		return true;
	}

	public boolean removeLecturerFromDepartment(Lecturer lecturer) {
		for (int i = 0; i < departmentNumOfLecturers; i++) {
			if (lecturersArray[i] != null && lecturersArray[i].equals(lecturer)) {
				// Shift remaining elements to fill the gap
				for (int j = i; j < departmentNumOfLecturers - 1; j++) {
					lecturersArray[j] = lecturersArray[j + 1];
				}
				lecturersArray[departmentNumOfLecturers - 1] = null;
				departmentNumOfLecturers--;
				return true;
			}
		}
		return false;
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
				departmentNumOfLecturers == that.departmentNumOfLecturers &&
				departmentName.equals(that.departmentName);
	}
}











