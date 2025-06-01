package Exceptions;

public class DepartmentAlreadyExistException extends Exception {
    public DepartmentAlreadyExistException(String departmentName) {
        super("Department with name '" + departmentName + "' already exists.");
    }
}
