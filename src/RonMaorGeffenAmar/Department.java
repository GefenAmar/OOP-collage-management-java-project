package RonMaorGeffenAmar;

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
			System.out.println("RonMaorGeffenAmar.Lecturer" + lecturer.getLecturerName() + "is already assigned to a department.");
			return false;
		}
		
		if (departmentNumOfLecturers == lecturersArray.length) {
			Lecturer[] newArray = new Lecturer[lecturersArray.length + 1];
			for (int i = 0; i < lecturersArray.length; i++) {
				newArray[i] = lecturersArray[i];
			}
			lecturersArray = newArray;
		}
		
		lecturersArray[departmentNumOfLecturers++] = lecturer;
		lecturer.setDepartment(this);
		return true;
	}
	
			
		
}











