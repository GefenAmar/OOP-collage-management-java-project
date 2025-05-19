package RonMaorGeffenAmar;
import java.util.Arrays;

public class Professor extends Lecturer {
    private int numberOfResearchPapers;
    private String[] researchPapers;
    private String nameOfUniversity;

    public Professor(String lecturerName, String degreeName, int id, int wage, String nameOfUniversity) {
        super(lecturerName, DegreeDetails.Professor.name(), degreeName, id, wage);
        this.nameOfUniversity = nameOfUniversity;
        this.numberOfResearchPapers = 0;
        this.researchPapers = new String[2];
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", nameOfUniversity: " + nameOfUniversity +
                ", researchPapers: [" + Arrays.toString(researchPapers) + "]";
    }
}

