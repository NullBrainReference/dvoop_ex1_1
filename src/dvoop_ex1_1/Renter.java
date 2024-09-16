package dvoop_ex1_1;

public class Renter {
	private String dni;
	private String name;
	private String surname;
	
	public Renter(String dni, String name, String surname) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", name, surname);
	}
	
	public boolean compareDNI(String dni) {
		return this.dni.equals(dni);
	}
}
