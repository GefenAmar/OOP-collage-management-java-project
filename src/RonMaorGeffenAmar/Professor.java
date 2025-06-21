package RonMaorGeffenAmar;

public class Professor extends Doctor {
    private String nameOfUniversity;

    public Professor(String lecturerName, String degreeName, int id, int wage, String[] researchPapers, String nameOfUniversity) {
        super(lecturerName, degreeName, id, wage, researchPapers);
        this.nameOfUniversity = nameOfUniversity;
        this.degree = DegreeDetails.Professor;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Name of University: " + nameOfUniversity;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) &&
                obj instanceof Professor professor &&
                this.nameOfUniversity.equals(professor.nameOfUniversity);
    }
}
