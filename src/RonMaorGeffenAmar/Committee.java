package RonMaorGeffenAmar;


public class Committee {
	private final String committeeName;
	private Lecturer headOfCommittee;
	private int numOfLecturersInCommittee;
	private Lecturer[] lecturersArray;
	
	public Committee(String committeeName) {
		this.committeeName = committeeName;
		this.headOfCommittee = null;
		this.numOfLecturersInCommittee = 0;
	}
	
	public String getCommitteeName() {
		return committeeName;
	}
	
	public Lecturer getHeadOfCommittee() {
		return headOfCommittee;
	}
	
	public int getNumOfLecturersInCommittee() {
		return numOfLecturersInCommittee;
	}
	
	public boolean newHeadOfCommittee(Lecturer newHead) {
		DegreeDetails degree = newHead.getDegree();
		
		if (!(degree.equals(DegreeDetails.Doctor) || degree.equals(DegreeDetails.Professor))) {
			return false;
		}
		
		this.headOfCommittee = newHead;
		
		for (int i = 0; i < numOfLecturersInCommittee; i++) {
			if (lecturersArray[i].getLecturerName().equals(newHead.getLecturerName())) {
				removeLecturerFromCommittee(newHead.getLecturerName());
				break;
			}
		}
		return true;
	}
	
	public boolean addLecturerToCommittee(Lecturer lecturer) {
		for (int i = 0; i < numOfLecturersInCommittee; i++) {
			if (lecturersArray[i].getLecturerName().equals(lecturer.getLecturerName())) {
				return false;
			}
		}

		if (numOfLecturersInCommittee == lecturersArray.length) {
			int arraySize = lecturersArray.length;
			if (arraySize == 0) {
				arraySize = 1;
			}
			Lecturer[] newArray = new Lecturer[arraySize * 2];
			for (int i = 0; i < numOfLecturersInCommittee; i++) {
				newArray[i] = lecturersArray[i];
			}
			lecturersArray = newArray;
		}

		lecturersArray[numOfLecturersInCommittee] = lecturer;
		numOfLecturersInCommittee++;
		return true;
	}
	
	public boolean removeLecturerFromCommittee(String lecturerName) {
		int index = -1;
		for (int i = 0; i < numOfLecturersInCommittee; i++) {
			if (lecturersArray[i].getLecturerName().equals(lecturerName)) {
				index = i;
				break;
			}
		}
		
		if (index == -1) {
			return false;
		}
		
		Lecturer[] newArray = new Lecturer[numOfLecturersInCommittee - 1];
		for (int i = 0, j = 0; i < numOfLecturersInCommittee; i++) {
			if (i != index) {
				newArray[j++] = lecturersArray[i];
			}
		}
		lecturersArray = newArray;
		numOfLecturersInCommittee--;
		return true;
	}
	
	public Lecturer[] getLecturers() {
		return lecturersArray;
	}
	
	public String toString() {
		return "Committee Details: "+
		"Name: " + committeeName + "," + 
		"Head Of Committee: " + headOfCommittee +  "," +
		"Number Of Lecturers In Committee: " + numOfLecturersInCommittee + ".";
	 }

}
