package RonMaorGeffenAmar;

import Exceptions.LecturerAlreadyExistException;
import Exceptions.LecturerNotFoundException;

public class LecturersArray implements Cloneable {
	private int numOfLecturers;
	private Lecturer[] lecturersArray;
	
	public LecturersArray() {
		this.numOfLecturers = 0;
		this.lecturersArray = new Lecturer[2];
	}

	public Lecturer[] getLecturersArray() {
		return lecturersArray;
	}

	public int getNumOfLecturers() {
		return numOfLecturers;
	}

	public void addLecturer (Lecturer lecturer) throws LecturerAlreadyExistException {
		if (isLecturerExist(lecturer.getLecturerName())) {
			throw new LecturerAlreadyExistException(lecturer.getLecturerName());
		}

		if (numOfLecturers == lecturersArray.length) {
			int arraySize = lecturersArray.length;
			if (arraySize == 0) {
				arraySize = 1;
			}
			Lecturer[] newArray = new Lecturer[arraySize * 2];
			
			for (int i = 0; i < lecturersArray.length; i++) {
				newArray[i] = lecturersArray[i];
			}
			
			lecturersArray = newArray;
		}
		lecturersArray[numOfLecturers] = lecturer;
		numOfLecturers ++;
	}

	public void removeLecturer (String lecturerName) throws LecturerNotFoundException {
		int index = -1;
		for (int i = 0; i < numOfLecturers; i++) {
			if (lecturersArray[i].getLecturerName().equals(lecturerName)) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			throw new LecturerNotFoundException(lecturerName);
		}

		for (int i = index; i < numOfLecturers - 1; i++) {
			lecturersArray[i] = lecturersArray[i + 1];
		}

		numOfLecturers--;
		lecturersArray[numOfLecturers] = null; // Clear the last element
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
			System.out.println((i+1) + ". " + lecturersArray[i]);
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

	@Override
	protected LecturersArray clone() throws CloneNotSupportedException {
		LecturersArray clonedArray = (LecturersArray) super.clone();
		clonedArray.lecturersArray = new Lecturer[lecturersArray.length];
		for (int i = 0; i < numOfLecturers; i++) {
			clonedArray.lecturersArray[i] = lecturersArray[i];
		}
		return clonedArray;
	}

	private boolean isLecturerExist(String name) {
		for(int i=0; i < numOfLecturers ; i++) {
			if (lecturersArray[i].getLecturerName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
	
	
	
	
	 
	 
	     

		
	
	
	
	
	
	
	
	
	
	 

