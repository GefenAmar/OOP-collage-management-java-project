package RonMaorGeffenAmar;

public class LecturersArray {
	private int numOfLecturers;
	private Lecturer[] lecturersArray;
	
	public LecturersArray(int numOfLecturers) {
		lecturersArray = new Lecturer[numOfLecturers];
	}
	
	public void addLecturer(Lecturer lecturer) {
		if (numOfLecturers == lecturersArray.length) {
			if (numOfLecturers == 0) {
				numOfLecturers = 1;
			}
			Lecturer[] newArray = new Lecturer[numOfLecturers * 2];
			
			for (int i = 0; i < lecturersArray.length; i++) {
				newArray[i] = lecturersArray[i];
			}
			
			lecturersArray = newArray;
		}
		lecturersArray[numOfLecturers] = lecturer;
		numOfLecturers ++;
	}
	 
	public boolean isLecturerExist(String name) {
		for(int i=0; i < numOfLecturers ; i++) {
			if (lecturersArray[i].getLecturerName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public Lecturer getLecturerByName(String lecturerName) {
		for (int i=0; i < numOfLecturers; i++) {
			if(lecturersArray[i].getLecturerName().equals(lecturerName)) {
				return lecturersArray[i];
			}
		}
		return null;
	}
	
	public void showLecturers() {
		if (numOfLecturers == 0) {
			System.out.println("No lecturers to display.");
			return;
		}
		
		System.out.println("Lecturers:");
		for (int i = 0; i < numOfLecturers ; i++) {
			System.out.println((i+1) + "." + lecturersArray[i]);
		}
	}
	
	public double getLecturerWageAverage() {
		if (numOfLecturers == 0) return 0;
		
		int totalWage = 0;
		for (int i=0; i < numOfLecturers; i++) {
			totalWage += lecturersArray[i].getLecturerWage();
		}
		return (double) totalWage / numOfLecturers;
	}
}
	
	
	
	
	 
	 
	     

		
	
	
	
	
	
	
	
	
	
	 

