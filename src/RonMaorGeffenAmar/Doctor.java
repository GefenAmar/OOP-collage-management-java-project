package RonMaorGeffenAmar;

import java.util.Arrays;

public class Doctor extends Lecturer implements Comparable {
    private int numberOfResearchPapers;
    protected String[] researchPapers;

    public Doctor(String name, String lecturerName, String degreeName, int id, int wage) {
        super(lecturerName, DegreeDetails.Doctor.name(), degreeName, id, wage);
        this.numberOfResearchPapers = 0;
        this.researchPapers = new String[2];
    }

    public int getNumberOfResearchPapers() {
        return numberOfResearchPapers;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", Research Papers: [" + Arrays.toString(researchPapers) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) &&
                obj instanceof Doctor doctor &&
                this.numberOfResearchPapers == doctor.numberOfResearchPapers &&
                Arrays.equals(this.researchPapers, doctor.researchPapers);
    }

    @Override
    public int compareTo(Object other) {
        if (other == null) {
            return 1; // null is considered less than any object
        }
        if (!(other instanceof Doctor)) {
            return -1; // non-Doctor objects are considered less than Doctor objects
        }
        Doctor otherDoctor = (Doctor) other;
        return Integer.compare(this.numberOfResearchPapers, otherDoctor.numberOfResearchPapers);
    }
}

