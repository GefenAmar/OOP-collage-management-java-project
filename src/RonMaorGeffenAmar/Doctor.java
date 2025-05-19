package RonMaorGeffenAmar;

import java.util.Arrays;

public class Doctor extends Lecturer {
    private int numberOfResearchPapers;
    private String[] researchPapers;

    public Doctor(String lecturerName, String degreeName, int id, int wage) {
        super(lecturerName, DegreeDetails.Doctor.name(), degreeName, id, wage);
        this.numberOfResearchPapers = 0;
        this.researchPapers = new String[2];
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", researchPapers: [" + Arrays.toString(researchPapers) + "]";
    }
}

