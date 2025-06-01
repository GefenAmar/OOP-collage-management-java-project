package Exceptions;

public class DepartmentNotFoundException extends Exception {
    public DepartmentNotFoundException(String departmentName) {
        super("Department with name '" + departmentName + "' not found.");
    }
}
