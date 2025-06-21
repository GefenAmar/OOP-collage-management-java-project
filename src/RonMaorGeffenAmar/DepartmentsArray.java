package RonMaorGeffenAmar;

import Exceptions.DepartmentAlreadyExistException;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsArray {
    private final List<Department> departments;

    public DepartmentsArray() {
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) throws DepartmentAlreadyExistException {
        if (isDepartmentExist(department.getDepartmentName())) {
            throw new DepartmentAlreadyExistException(department.getDepartmentName());
        }
        departments.add(department);
    }

    public boolean isDepartmentExist(String departmentName) {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                return true;
            }
        }
        return false;
    }


    public Department getDepartmentByName(String departmentName) {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                return department;
            }
        }
        return null;

    }

}