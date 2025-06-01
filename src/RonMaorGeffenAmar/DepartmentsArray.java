package RonMaorGeffenAmar;

import Exceptions.DepartmentAlreadyExistException;

public class DepartmentsArray {
	private int numOfDepartments;
	private Department[] departmentsArray;
	
	public DepartmentsArray() {
		this.numOfDepartments = 0;
		this.departmentsArray = new Department[2];
	}

	public void addDepartment(Department department) throws DepartmentAlreadyExistException {
		if (isDepartmentExist(department.getDepartmentName())) {
			throw new DepartmentAlreadyExistException(department.getDepartmentName());
		}

		if (numOfDepartments == departmentsArray.length) {
			int arraySize = departmentsArray.length;
			if (arraySize == 0) {
				arraySize = 1;
			}
			Department[] newArray = new Department[arraySize * 2];
			
			for (int i = 0; i < departmentsArray.length; i++) {
				newArray[i] = departmentsArray[i];
			}
			
			departmentsArray = newArray;
		}
		departmentsArray[numOfDepartments] = department;
		numOfDepartments ++;
	}
	 
	public Department getDepartmentByName(String departmentName) {
		for (int i=0; i < numOfDepartments; i++) {
			if(departmentsArray[i].getDepartmentName().equals(departmentName)) {
				return departmentsArray[i];
			}
		}
		return null;
	}

	private boolean isDepartmentExist(String name) {
		for(int i=0; i < numOfDepartments ; i++) {
			if (departmentsArray[i].getDepartmentName().equals(name)) {
				return true;
			}
		}
		return false;
	}
 }
