package RonMaorGeffenAmar;

public class Lecturer {
	private final String lecturerName;
    private final String degreeName;
	private final DegreeDetails degree;
	private final int id;
    private final int wage;
	private Department department;
	private Committee[] committees;
	private int numOfCommitteesLecturerIsIn;


	public Lecturer(String lecturerName, String degree, String degreeName, int id, int wage) {
		this.lecturerName = lecturerName;
		this.degree = DegreeDetails.fromName(degree);
		this.degreeName = degreeName;
		this.department = null;
		this.id = id;
		this.wage = wage;
		this.committees = new  Committee[2];
		this.numOfCommitteesLecturerIsIn = 0;
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

	public boolean addLecturerToCommittee(Committee committee) {
		if (numOfCommitteesLecturerIsIn == committees.length) {
			int arraySize = committees.length;
			if (arraySize == 0) {
				arraySize = 1;
			}
			Committee[] newArray = new Committee[arraySize * 2];

			for (int i = 0; i < committees.length; i++) {
				newArray[i] = committees[i];
			}

			committees = newArray;
		}

		committees[numOfCommitteesLecturerIsIn] = committee;
		numOfCommitteesLecturerIsIn++;
		return true;
	}

	private String getLecturerCommittees() {
		StringBuilder committeesString = new StringBuilder();
		for (int i = 0; i < numOfCommitteesLecturerIsIn; i++) {
			committeesString.append(committees[i].getCommitteeName());
			if (i != numOfCommitteesLecturerIsIn - 1) {
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
}
