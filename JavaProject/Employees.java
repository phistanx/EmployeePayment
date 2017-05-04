/**
 * Parent of all other types of employees
 * @author Tristan Vu 40028927<br>
 * COMP 249<br>
 * Assignment 4<br>
 * Due Date: 10th April
 */
public class Employees implements Ordered {
	private long id; 
	private String firstName; 
	private String familyName;
	private String cityOfResidence; 
	private int hireYear;
	
	public Employees(long id, String firstName, String familyName, String cityOfResidence, int hireYear){
			this.id=id;
			this.firstName=firstName;
			this.familyName=familyName;
			this.cityOfResidence=cityOfResidence;
			this.hireYear=hireYear;
	}
	public Employees(){
		id=0;
		firstName=null;
		familyName=null;
		cityOfResidence=null;
		hireYear=0;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getCityOfResidence() {
		return cityOfResidence;
	}

	public void setCityOfResidence(String cityOfResidence) {
		this.cityOfResidence = cityOfResidence;
	}

	public int getHireYear() {
		return hireYear;
	}

	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
	}
	
	public String toString(){
		return id + " " + firstName
			+ " " + familyName + " " + cityOfResidence
			+ " " + hireYear;
	}
	@Override
	public boolean precedes(Employees e) {
		if(hireYear<e.getHireYear())
			return true;
		else
			return false;
	}
	@Override
	public boolean Follows(Employees e) {
		if(hireYear>e.getHireYear())
			return true;
		else
			return false;
	}
	}
