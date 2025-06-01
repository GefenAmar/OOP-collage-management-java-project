package Comparators;

import RonMaorGeffenAmar.Department;

import java.util.Comparator;

public class CompareDepartmentsByPapers implements Comparator<Department> {
    @Override
    public int compare(Department department1, Department department2) {
        if (department1 == null && department2 == null) {
            return 0; // Both are null, considered equal
        }
        if (department1 == null) {
            return -1; // Null is considered less than any non-null object
        }
        if (department2 == null) {
            return 1; // Non-null object is considered greater than null
        }

        return Integer.compare(department1.getDepartmentNumOfResearchPapers(), department2.getDepartmentNumOfResearchPapers());
    }
}
