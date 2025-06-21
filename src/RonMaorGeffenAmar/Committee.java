package RonMaorGeffenAmar;


import Exceptions.InvalidDegreeException;
import Exceptions.LecturerAlreadyExistException;
import Exceptions.LecturerNotFoundException;
import java.io.Serializable;

public class Committee implements Cloneable {
	private String committeeName;
	private Lecturer headOfCommittee;
	private LecturersArray lecturersArray;
	private DegreeDetails committeeDegree;

	public Committee(String committeeName, DegreeDetails committeeDegreeDetails) {
		this.committeeName = committeeName;
		this.headOfCommittee = null;
		this.lecturersArray = new LecturersArray();
		this.committeeDegree = committeeDegreeDetails;
	}
	
	public String getCommitteeName() {
		return committeeName;
	}
	
	public Lecturer getHeadOfCommittee() {
		return headOfCommittee;
	}
	
	public int getNumOfLecturersInCommittee() {
		return lecturersArray.getNumOfLecturers();
	}
	
	public void newHeadOfCommittee(Lecturer newHead) throws InvalidDegreeException {
		DegreeDetails degree = newHead.getDegree();
		
		if (!(degree.equals(DegreeDetails.Doctor) || degree.equals(DegreeDetails.Professor))) {
			throw new InvalidDegreeException(degree, "Head of committee");
		}
		this.headOfCommittee = newHead;
        try {
            removeLecturerFromCommittee(newHead.getLecturerName());
        } catch (LecturerNotFoundException e) {
			// ignore exception, New head of committee was not in the committee
        }
    }
	
	public void addLecturerToCommittee(Lecturer lecturer) throws LecturerAlreadyExistException, InvalidDegreeException {
        if (lecturer == headOfCommittee) {
            lecturersArray.addLecturer(lecturer);
            return;
        }

        if (!committeeDegree.equals(lecturer.getDegree())) {
            throw new InvalidDegreeException(lecturer.getDegree(), "committee member");
        }

        lecturersArray.addLecturer(lecturer);
    }

	public void removeLecturerFromCommittee(String lecturerName) throws LecturerNotFoundException {
		lecturersArray.removeLecturer(lecturerName);
		if (getNumOfLecturersInCommittee() == 0) {
			committeeDegree = null;
		}
	}

	@Override
	protected Committee clone() throws CloneNotSupportedException {
		Committee clonedCommittee = (Committee) super.clone();
		clonedCommittee.headOfCommittee = this.headOfCommittee;
		clonedCommittee.committeeName = this.committeeName + "-new";
		clonedCommittee.lecturersArray = (LecturersArray) this.lecturersArray.clone();
		return clonedCommittee;
	}


    public DegreeDetails getCommitteeDegree() {
        return committeeDegree;
    }

	public String toString() {
		return "Committee Details: "+
		"Name: " + committeeName + "," + 
		"Head Of Committee: " + headOfCommittee +  "," +
		"Number Of Lecturers In Committee: " + lecturersArray.getNumOfLecturers() + ".";
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Committee other = (Committee) obj;
		return committeeName.equals(other.committeeName) &&
				(headOfCommittee != null ? headOfCommittee.equals(other.headOfCommittee) : other.headOfCommittee == null) &&
				lecturersArray.getNumOfLecturers() == other.lecturersArray.getNumOfLecturers();
	}
}
