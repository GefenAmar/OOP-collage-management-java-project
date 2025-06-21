package RonMaorGeffenAmar;

import Exceptions.*;




public class College {

	private String collegeName;
	private LecturersArray lecturersArray;
	private final CommitteesArray committeesArray;
	private final DepartmentsArray departmentsArray;

	public College(String collegeName) {
		this.collegeName = collegeName;
		this.lecturersArray = new LecturersArray();
		this.committeesArray = new CommitteesArray();
		this.departmentsArray = new DepartmentsArray();

	}


	public DepartmentsArray getDepartmentsArray() {
		return departmentsArray;
	}


	public void addLecturerToCollege(Lecturer lecturer) throws LecturerAlreadyExistException {
		lecturersArray.addLecturer(lecturer);
	}


	public void addCommitteeToCollege(String committeeName, DegreeDetails committeeDegreeDetails) throws CommitteeAlreadyExistException {
		Committee committee = new Committee(committeeName, committeeDegreeDetails), c;
		committeesArray.addCommittee(committee);
	}

	public void addDepartmentToCollege (Department department) throws DepartmentAlreadyExistException {
		departmentsArray.addDepartment(department);
	}

	public Lecturer getLecturerByName(String name) {
		return lecturersArray.getLecturerByName(name);

	}


	public Committee getCommitteeByName(String name)  {
		return committeesArray.getCommitteeByName(name);
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

	public void addLecturerToCommittee(String lecturerName, String committeeName) throws LecturerNotFoundException,
			CommitteeNotFoundException, LecturerAlreadyExistException, CommitteeAlreadyExistException, InvalidDegreeException {
		Lecturer lecturer = getLecturerByName(lecturerName);
		if (lecturer == null) {
			throw new LecturerNotFoundException(lecturerName);
		}

		Committee committee = getCommitteeByName(committeeName);
		if (committee == null) {
			throw new CommitteeNotFoundException(committeeName);
		}

		committee.addLecturerToCommittee(lecturer);
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

	public void addLecturerToDepartment(String lecturerName, String departmentName) throws LecturerNotFoundException, DepartmentNotFoundException, LecturerAlreadyExistException {
		Lecturer lecturer = lecturersArray.getLecturerByName(lecturerName);
		if (lecturer == null) {
			throw new LecturerNotFoundException(lecturerName);
		}

		Department department = departmentsArray.getDepartmentByName(departmentName);
		if (department == null) {
			throw new DepartmentNotFoundException(departmentName);
		}

		department.addLecturerToDepartment(lecturer);
	}

	public void cloneCommittee(String committeeName) throws CommitteeNotFoundException, CloneNotSupportedException, CommitteeAlreadyExistException {
		Committee committee = committeesArray.getCommitteeByName(committeeName);
		if (committee == null) {
			throw new CommitteeNotFoundException(committeeName);
		}

		Committee clonedCommittee = committee.clone();
		committeesArray.addCommittee(clonedCommittee);
	}

	public void removeLecturerFromDepartment(String lecturerName, String departmentName) throws LecturerNotFoundException, DepartmentNotFoundException {
		Department department = departmentsArray.getDepartmentByName(departmentName);
		if (department == null) {
			throw new DepartmentNotFoundException(departmentName);
		}
		department.removeLecturerFromDepartment(lecturerName);

		Lecturer lecturer = lecturersArray.getLecturerByName(lecturerName);
		if (lecturer == null) {
			throw new LecturerNotFoundException(lecturerName);
		}
		lecturer.setDepartment(null);
	}

	public void showCommitteesInCollege() {
		committeesArray.showCommittees();


	}
}
