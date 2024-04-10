package model;

public class Patient implements Comparable<Patient> {
	private String name;
	private String surname;
	private String personCode;
	private int illnessLevel;
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getPersonCode() {
		return personCode;
	}
	
	public int getIllnessLevel() {
		return illnessLevel;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	
	public void setIllnessLevel(int illnessLevel) {
		this.illnessLevel = illnessLevel;
	}
	
	public Patient() {
		
	}
	
	public Patient(String name, String surname, String personCode, int illnessLevel) {
		setName(name);
		setSurname(surname);
		setPersonCode(personCode);
		setIllnessLevel(illnessLevel);;
	}
	
	public String toString() {
		return name + " " + surname + " [" + personCode + "] " + "IL: " + illnessLevel;
	}

	@Override
	public int compareTo(Patient o) {
		if (illnessLevel > o.illnessLevel)
			return 1;
		else if (illnessLevel < o.illnessLevel)
			return -1;
		else 
			return 0;
	}
}
