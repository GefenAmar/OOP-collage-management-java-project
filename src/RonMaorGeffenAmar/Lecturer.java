package RonMaorGeffenAmar;

public class Lecturer {
	private final String lecturerName;
    private final String degreeName;
	private final Degree degree;
	private final int id;
    private final int wage;
	private Department department;
	private Committee[] committees;


	public enum Degree {
		First,
		Second,
		Doctor,
		Professor;

		public static Degree fromName(String name) {
            return switch (name.toLowerCase()) {
                case "first" -> First;
                case "second" -> Second;
                case "doctor" -> Doctor;
                default -> Professor;
            };
		}
	}
	
	public Lecturer(String lecturerName, String degree, String degreeName, Department department, int id, int wage) {
		this.lecturerName = lecturerName;
		this.degree = Degree.fromName(degree);
		this.degreeName = degreeName;
		this.department = department;
		this.id = id;
		this.wage = wage;

		
	}
	
	public String getLecturerName() {
		return lecturerName;
	}
	
	public String getDegreeName() {
		return degreeName;
	}

	public Degree getDegree() {
		return degree;
	}

	public int getLecturerId() {
		return id;
	}
	
	public int getLecturerWage() {
		return wage;
	}
	
	public Department getLecturerDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	
	}
	public String toString() {
		return "RonMaorGeffenAmar.Lecturer Details: "+
		"Name: " + lecturerName + "," + 
		"RonMaorGeffenAmar.Degree: " + degree +  "," +
		"RonMaorGeffenAmar.Degree Name: " + degreeName + "," +
		"RonMaorGeffenAmar.Department: " + department +  "," +
		"ID: " + id +  "," +
		"Wage: " + wage + ".";
	 }
}
