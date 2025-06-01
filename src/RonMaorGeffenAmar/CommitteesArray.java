package RonMaorGeffenAmar;

import Exceptions.CommitteeAlreadyExistException;

public class CommitteesArray {
	private int numOfCommittees;
	private Committee[] committeesArray;
	
	public CommitteesArray() {
		this.numOfCommittees = 0;
		this.committeesArray = new Committee[2];
	}

	public Committee[] getCommitteesArray() {
		return committeesArray;
	}

	public int getNumOfCommittees() {
		return numOfCommittees;
	}
	
	public void addCommittee(Committee committee) throws CommitteeAlreadyExistException {
		if (isCommitteeExist(committee.getCommitteeName())) {
			throw new CommitteeAlreadyExistException(committee.getCommitteeName());
		}

		if (numOfCommittees == committeesArray.length) {
			int arraySize = committeesArray.length;
			if (arraySize == 0) {
				arraySize = 1;
			}
			Committee[] newArray = new Committee[arraySize * 2];
			
			for (int i = 0; i < committeesArray.length; i++) {
				newArray[i] = committeesArray[i];
			}
			
			committeesArray = newArray;
		}
		committeesArray[numOfCommittees] = committee;
		numOfCommittees ++;
	}


	public Committee getCommitteeByName (String committeeName) {
		for (int i=0; i < numOfCommittees; i++) {
			if(committeesArray[i].getCommitteeName().equals(committeeName)) {
				return committeesArray[i];
			}
		}

		return null;
	}

	public void showCommittees() {
		if (numOfCommittees == 0) {
			System.out.println("No core committees to display");
			return;
		}

		System.out.println("Committees:");
		for (int i = 0; i < numOfCommittees ; i++) {
			System.out.println((i+1) + "." + committeesArray[i]);
		}
	}

	private boolean isCommitteeExist(String name) {
		for(int i=0; i < numOfCommittees ; i++) {
			if (committeesArray[i].getCommitteeName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
