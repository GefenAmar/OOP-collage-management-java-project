package Exceptions;

import RonMaorGeffenAmar.DegreeDetails;

public class InvalidDegreeException extends IllegalArgumentException {
    public InvalidDegreeException(DegreeDetails degree, String jobTitle) {
        super("'" + degree.toString() + "' is not valid for: " + jobTitle);
    }
}
