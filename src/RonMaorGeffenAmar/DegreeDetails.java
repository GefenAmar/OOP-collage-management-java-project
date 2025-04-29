package RonMaorGeffenAmar;

public enum DegreeDetails {
    First,
    Second,
    Doctor,
    Professor;


    public static DegreeDetails fromName(String name) {
        return switch (name.toLowerCase()) {
            case "first" -> DegreeDetails.First;
            case "second" -> DegreeDetails.Second;
            case "doctor" -> DegreeDetails.Doctor;
            default -> DegreeDetails.Professor;

        };
    }
}