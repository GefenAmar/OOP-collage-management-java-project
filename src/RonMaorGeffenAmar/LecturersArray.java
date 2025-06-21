package RonMaorGeffenAmar;

import Exceptions.LecturerAlreadyExistException;
import Exceptions.LecturerNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class LecturersArray implements Cloneable {
    private List<Lecturer> lecturers;

    public LecturersArray() {
        this.lecturers = new ArrayList<>();
    }

    public void addLecturer(Lecturer lecturer) throws LecturerAlreadyExistException {
        if (isLecturerExist(lecturer.getLecturerName())) {
            throw new LecturerAlreadyExistException(lecturer.getLecturerName());
        }
        lecturers.add(lecturer);
    }

    public boolean isLecturerExist(String lecturerName) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getLecturerName().equals(lecturerName)) {
                return true;
            }
        }
        return false;
    }

    public Lecturer getLecturer(String lecturerName) throws LecturerNotFoundException {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getLecturerName().equals(lecturerName)) {
                return lecturer;
            }
        }
        throw new LecturerNotFoundException(lecturerName);
    }

    public int getNumOfLecturers() {
        return lecturers.size();
    }

    public double getLecturerWageAverage() {
        if (lecturers.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Lecturer lecturer : lecturers) {
            sum += lecturer.getWage();
        }
        return sum / lecturers.size();
    }

    public Lecturer getLecturerByName(String name) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getLecturerName().equals(name)) {
                return lecturer;
            }
        }
        return null;
    }

    public void removeLecturer(String lecturerName) throws LecturerNotFoundException {
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getLecturerName().equals(lecturerName)) {
                lecturers.remove(i);
                return;
            }
        }
        throw new LecturerNotFoundException(lecturerName);
    }

    public void showLecturers() {
        if (lecturers.isEmpty()) {
            System.out.println("No lecturers found.");
            return;
        }
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LecturersArray cloned = (LecturersArray) super.clone();
        cloned.lecturers = new ArrayList<>(this.lecturers);
        return cloned;
    }

    public int getLecturersNumOfResearchPapers() {
        int totalPapers = 0;
		for (Lecturer lecturer : lecturers) {
			if (lecturer instanceof Doctor) {
				totalPapers += ((Doctor) lecturer).getNumOfResearchPapers();
			}
		}
		return totalPapers;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }
}
