package Exceptions;

public class CommitteeNotFoundException extends Exception {
    public CommitteeNotFoundException(String committeeName) {
        super("Committee with name '" + committeeName + "' not found.");
    }
}
