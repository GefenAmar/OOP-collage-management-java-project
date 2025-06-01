package Exceptions;

public class LecturerAlreadyExistException extends Exception {
    public LecturerAlreadyExistException(String lecturerName) {
        super("Lecturer with name '" + lecturerName + "' already exists.");
    }
}
