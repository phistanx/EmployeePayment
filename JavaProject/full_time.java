/**
 * child of faculty
 * @author Tristan Vu 40028927<br>
 * COMP 249<br>
 * Assignment 4<br>
 * Due Date: 10th April
 */
public class full_time extends Faculty{
	private long salary;
	public full_time(long id, String firstName, String familyName, String cityOfResidence, int hireYear,long salary) {
		super(id, firstName, familyName, cityOfResidence, hireYear);
		this.salary=salary;
	}
	public full_time(){
		super();
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String toString(){
		return super.toString() + " " + salary;
	}
	
}
