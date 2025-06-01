package RonMaorGeffenAmar;

import Exceptions.CommitteeAlreadyExistException;

public class Lecturer {
	private final String lecturerName;
    private final String degreeName;
	private final DegreeDetails degree;
	private final int id;
    private final int wage;
	private Department department;
	private final CommitteesArray committees;


	public Lecturer(String lecturerName, String degree, String degreeName, int id, int wage) {
		this.lecturerName = lecturerName;
		this.degree = DegreeDetails.fromName(degree);
		this.degreeName = degreeName;
		this.department = null;
		this.id = id;
		this.wage = wage;
		this.committees = new CommitteesArray();
	}
	
	public String getLecturerName() {
		return lecturerName;
	}
	
	public String getDegreeName() {
		return degreeName;
	}

	public DegreeDetails getDegree() {
		return degree;
	}

	public int getLecturerId() {
		return id;
	}
	
	public int getLecturerWage() {
		return wage;
	}
	
	public Department getLecturerDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}

	public void addCommitteeToLecturer (Committee committee) throws CommitteeAlreadyExistException {
		committees.addCommittee(committee);
	}

	private String getLecturerCommittees() {
		Committee[] committeesArray = committees.getCommitteesArray();
		StringBuilder committeesString = new StringBuilder();
		int numOfCommittees = committees.getNumOfCommittees();

		for (int i = 0; i < numOfCommittees; i++) {
			committeesString.append(committeesArray[i].getCommitteeName());
			if (i != numOfCommittees - 1) {
				committeesString.append(", ");
			}
		}

		return committeesString.toString();
	}

	public String toString() {
		return "Lecturer Details: "+
		"Name: " + lecturerName + ", " +
		"Degree: " + degree +  ", " +
		"Degree Name: " + degreeName + ", " +
		"Department: " + department +  ", " +
		"Committees: " + getLecturerCommittees() +  ", " +
		"ID: " + id +  ", " +
		"Wage: " + wage + ".";
	 }
	 public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Lecturer other = (Lecturer) obj;
		return lecturerName.equals(other.lecturerName) &&
				degreeName.equals(other.degreeName) &&
				degree == other.degree &&
				id == other.id &&
				wage == other.wage &&
				(department != null ? department.equals(other.department) : other.department == null) &&
				committees.getNumOfCommittees() == other.committees.getNumOfCommittees() ;
	 }
}
