package RonMaorGeffenAmar;

public class College {

	private String collegeName;
	private final LecturersArray lecturersArray;
	private final CommitteesArray committeesArray;
	private final DepartmentsArray departmentsArray;
	int numOfLecturers,numOfCommittees,numOfDepartments;

	public College(String collegeName) {
		this.lecturersArray = new LecturersArray(numOfLecturers);
		this.committeesArray = new CommitteesArray(numOfCommittees);
		this.departmentsArray = new DepartmentsArray(numOfDepartments);

	}

	public LecturersArray getLecturersArray() {
		return lecturersArray;
	}

	public CommitteesArray getCommitteesArray() {
		return committeesArray;

	}

	public DepartmentsArray getDepartmentsArray() {
		return departmentsArray;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void addLecturerToCollege(Lecturer lecturer) {
		lecturersArray.addLecturer(lecturer);
	}

	public Lecturer findLecturerByNameInCollege(String name) {
		return lecturersArray.getLecturerByName(name);
	}
	
	public boolean isLecturerExistInCollege(String name) {
		return lecturersArray.isLecturerExist(name);
	}
	
	public void addCommitteeToCollege(Committee committee) {
		committeesArray.addCommittee(committee);
	}
	
	public boolean isCommitteeExistInCollege(String committee) {
		return committeesArray.isCommitteeExist(committee);
	
	}

	public void addDepartmentToCollege(Department department) {
		departmentsArray.addDepartment(department);
	}
	
	public boolean isDepartmentExistInCollege(String department) {
		return departmentsArray.isDepartmentExist(department);
	
	}
	
	public Lecturer getLecturerByName(String name) {
		return lecturersArray.getLecturerByName(name);
	
	}
	
	public Department getDepartmentByName(String name) {
		return departmentsArray.getDepartmentByName(name);
		
	}
	
	public Committee getCommitteeByName(String name) {
		return committeesArray.getCommitteeByName(name);
	
	}
	
	public void showCommitteesInCollege() {
		committeesArray.showCommittees();
	}
	
	public void showLecturersInCollege() {
		lecturersArray.showLecturers();
	}
	
	public double getTotalAverageWage() {
		return lecturersArray.getLecturerWageAverage();

	}
	
	public double getAverageWageByDepartment(String departmentName) {
		Department department = departmentsArray.getDepartmentByName(departmentName);
		return department.getDepartmentWageAverage();
	}
	
	public boolean addLecturerToCommittee(String lecturerName,String committeeName) {
		Lecturer lecturer = lecturersArray.getLecturerByName(lecturerName);
		Committee committee = committeesArray.getCommitteeByName(committeeName);
		
		if (lecturer != null && committee != null) {
			return committee.addLecturerToCommittee(lecturer);
		}
		return false;
	}
	
	public boolean removeLecturerFromCommittee(String lecturerName,String committeeName) {
		Committee committee = committeesArray.getCommitteeByName(committeeName);
		if (committee != null) {
			return committee.removeLecturerFromCommittee(lecturerName);
		}
		return false;
	}
	
	public boolean NewHeadOfCommittee(String lecturerName,String committeeName) {
		Lecturer lecturer = lecturersArray.getLecturerByName(lecturerName);
		Committee committee = committeesArray.getCommitteeByName(committeeName);
		
		if (lecturer != null && committee != null) {
			return committee.newHeadOfCommittee(lecturer);
		}
		return false;
	}
}





	


	
	