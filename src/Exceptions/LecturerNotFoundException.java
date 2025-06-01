package Exceptions;

public class LecturerNotFoundException extends Exception {
    public LecturerNotFoundException(String lecturerName) {
        super("Lecturer with name '" + lecturerName + "' not found.");
    }

}
