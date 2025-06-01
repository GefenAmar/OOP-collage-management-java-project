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

    public static String getAllDegrees() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < DegreeDetails.values().length; i++) {
            builder.append(DegreeDetails.values()[i].name());
            if (i < DegreeDetails.values().length - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}