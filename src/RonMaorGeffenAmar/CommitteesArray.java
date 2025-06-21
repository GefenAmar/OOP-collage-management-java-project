package RonMaorGeffenAmar;

import Exceptions.CommitteeAlreadyExistException;
import java.util.ArrayList;

public class CommitteesArray {
    private final ArrayList<Committee> committees;


    public CommitteesArray() {
        this.committees = new ArrayList<>();
    }

    public void addCommittee(Committee committee) throws CommitteeAlreadyExistException {
        if (isCommitteeExist(committee.getCommitteeName())) {
            throw new CommitteeAlreadyExistException(committee.getCommitteeName());
        }
        committees.add(committee);
    }

    public boolean isCommitteeExist(String committeeName) {
        for (Committee committee : committees) {
            if (committee.getCommitteeName().equals(committeeName)) {
                return true;
            }
        }
        return false;
    }

    public Committee getCommitteeByName(String committeeName) {
        for (Committee committee : committees) {
            if (committee.getCommitteeName().equals(committeeName)) {
                return committee;
            }
        }
        return null;
    }


    public void showCommittees() {
        if (committees.isEmpty()) {
            System.out.println("No core committees to display");
            return;
        }

        System.out.println("Committees:");
        for (int i = 0; i < committees.size() ; i++) {
            System.out.println((i+1) + "." + committees.get(i));
        }
    }

    public int getNumOfCommittees() {
        return committees.size();
    }

    public Committee[] getCommitteesArray() {
        return committees.toArray(new Committee[0]);
    }
}
