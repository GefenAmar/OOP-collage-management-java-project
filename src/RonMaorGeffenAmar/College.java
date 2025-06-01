package RonMaorGeffenAmar;

import Exceptions.*;

public class College {

	private String collegeName;
	private final LecturersArray lecturersArray;
	private final CommitteesArray committeesArray;
	private final DepartmentsArray departmentsArray;

	public College(String collegeName) {
		this.collegeName = collegeName;
		this.lecturersArray = new LecturersArray();
		this.committeesArray = new CommitteesArray();
		this.departmentsArray = new DepartmentsArray();

	}

	public String getCollageName() {
		return collegeName;
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

	public void addLecturerToCollege(Lecturer lecturer) throws LecturerAlreadyExistException {
		lecturersArray.addLecturer(lecturer);
	}

	public Lecturer findLecturerByNameInCollege(String name) {
		return lecturersArray.getLecturerByName(name);
	}

	public void addCommitteeToCollege(String committeeName) throws CommitteeAlreadyExistException {
		Committee committee = new Committee(committeeName);
		committeesArray.addCommittee(committee);
	}

	public void addDepartmentToCollege (Department department) throws DepartmentAlreadyExistException {
		departmentsArray.addDepartment(department);
	}

	public Lecturer getLecturerByName(String name) {
		return lecturersArray.getLecturerByName(name);

	}

	public Department getDepartmentByName(String name) {
		return departmentsArray.getDepartmentByName(name);

	}

	public Committee getCommitteeByName(String name) throws CommitteeNotFoundException {
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

	public void addLecturerToCommittee(String lecturerName, String committeeName) throws LecturerNotFoundException, CommitteeNotFoundException, LecturerAlreadyExistException, CommitteeAlreadyExistException {
		Lecturer lecturer = lecturersArray.getLecturerByName(lecturerName);
		if (lecturer == null) {
			throw new LecturerNotFoundException(lecturerName);
		}

		Committee committee = committeesArray.getCommitteeByName(committeeName);

		if (committee == null) {
			throw new CommitteeNotFoundException(committeeName);
		}

		committee.addLecturerToCommittee(lecturer);
		lecturer.addCommitteeToLecturer(committee);
	}

	public void removeLecturerFromCommittee(String lecturerName, String committeeName) throws LecturerNotFoundException, CommitteeNotFoundException {
		Committee committee = committeesArray.getCommitteeByName(committeeName);
		if (committee == null) {
			throw new CommitteeNotFoundException(committeeName);
		}

		committee.removeLecturerFromCommittee(lecturerName);
	}

	public void newHeadOfCommittee(String lecturerName, String committeeName) throws LecturerNotFoundException, CommitteeNotFoundException {
		Lecturer lecturer = lecturersArray.getLecturerByName(lecturerName);
		if (lecturer == null) {
			throw new LecturerNotFoundException(lecturerName);
		}

		Committee committee = committeesArray.getCommitteeByName(committeeName);
		if (committee == null) {
			throw new CommitteeNotFoundException(committeeName);
		}
		committee.newHeadOfCommittee(lecturer);
	}

	public int compareDoctorsAndProfessorsByResearchPapers(Doctor firstLecturer, Doctor secondLecturer) {
		return firstLecturer.compareTo(secondLecturer);
	}

	public void addLecturerToDepartment(String lecturerName, String departmentName) throws LecturerNotFoundException, DepartmentNotFoundException {
		Lecturer lecturer = lecturersArray.getLecturerByName(lecturerName);
		if (lecturer == null) {
			throw new LecturerNotFoundException("Lecturer not found: " + lecturerName);
		}

		Department department = departmentsArray.getDepartmentByName(departmentName);
		if (department == null) {
			throw new DepartmentNotFoundException("Department not found: " + departmentName);
		}
	}

	public int compareDepartments(Department firstDepartment, Department secondDepartment) {
		// TODO - Implement comparison logic based on your criteria
		return 0;
	}

	public void cloneCommittee(String committeeName) throws CommitteeNotFoundException, CloneNotSupportedException, CommitteeAlreadyExistException {
		Committee committee = committeesArray.getCommitteeByName(committeeName);
		if (committee == null) {
			throw new CommitteeNotFoundException(committeeName);
		}

		Committee clonedCommittee = committee.clone();
		committeesArray.addCommittee(clonedCommittee);
	}
}





	


	
	