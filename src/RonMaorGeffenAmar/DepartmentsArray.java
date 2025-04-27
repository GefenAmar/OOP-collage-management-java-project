package RonMaorGeffenAmar;

public class DepartmentsArray {
	private int numOfDepartments;
	private Department[] departmentsArray;
	
	public DepartmentsArray(int numOfDepartments,Department[] departmentsArray) {
		this.numOfDepartments = 0;
		this.departmentsArray = departmentsArray;
	}
	
	public DepartmentsArray(int numOfDepartments) {
		departmentsArray = new Department[numOfDepartments];
	}
	
	public void addDepartment(Department department) {
		if (numOfDepartments == departmentsArray.length) {
			if (numOfDepartments == 0) {
				numOfDepartments = 1;
			}
			Department[] newArray = new Department[numOfDepartments * 2];
			
			for (int i = 0; i < departmentsArray.length; i++) {
				newArray[i] = departmentsArray[i];
			}
			
			departmentsArray = newArray;
		}
		departmentsArray[numOfDepartments] = department;
		numOfDepartments ++;
	}
	 
	public boolean isDepartmentExist(String name) {
		for(int i=0; i < numOfDepartments ; i++) {
			if (departmentsArray[i].getDepartmentName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	public Department getDepartmentByName(String departmentName) {
		for (int i=0; i < numOfDepartments; i++) {
			if(departmentsArray[i].getDepartmentName().equals(departmentName)) {
				return departmentsArray[i];
			}
		}
		return null;
	}
	
		

 }
