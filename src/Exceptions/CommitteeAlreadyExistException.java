package Exceptions;

public class CommitteeAlreadyExistException extends Exception {
    public CommitteeAlreadyExistException(String committeeName) {
        super("Committee with name '" + committeeName + "' already exists.");
    }
}
