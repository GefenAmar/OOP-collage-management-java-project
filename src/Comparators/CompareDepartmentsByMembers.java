package Comparators;

import RonMaorGeffenAmar.Department;

import java.util.Comparator;

public class CompareDepartmentsByMembers implements Comparator<Department> {
    @Override
    public int compare(Department department1, Department department2) {
        if (department1 == null && department2 == null) {
            return 0;
        }
        if (department1 == null) {
            return -1;
        }
        if (department2 == null) {
            return 1;
        }

        return Integer.compare(department1.getDepartmentNumOfLecturers(), department2.getDepartmentNumOfLecturers());
    }
}
