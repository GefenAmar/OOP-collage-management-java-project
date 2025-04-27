package RonMaorGeffenAmar;

public class CommitteesArray {
	private int numOfCommittees;
	private Committee[] committeesArray;
	
	public CommitteesArray(int numOfCommittees,Committee[] committeesArray) {
		this.numOfCommittees = 0;
		this.committeesArray = committeesArray;
	}
	
	public CommitteesArray(int numOfCommittees) {
		committeesArray = new Committee[numOfCommittees];
	}
	
	public void addCommittee(Committee committee) {
		if (numOfCommittees == committeesArray.length) {
			if (numOfCommittees == 0) {
				numOfCommittees = 1;
			}
			Committee[] newArray = new Committee[numOfCommittees * 2];
			
			for (int i = 0; i < committeesArray.length; i++) {
				newArray[i] = committeesArray[i];
			}
			
			committeesArray = newArray;
		}
		committeesArray[numOfCommittees] = committee;
		numOfCommittees ++;
	}
	 
	public boolean isCommitteeExist(String name) {
		for(int i=0; i < numOfCommittees ; i++) {
			if (committeesArray[i].getCommitteeName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public Committee getCommitteeByName(String committeeName) {
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
}
	
	

		
	 