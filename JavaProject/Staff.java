/**
 * child of employees
 * @author Tristan Vu 40028927<br>
 * COMP 249<br>
 * Assignment 4<br>
 * Due Date: 10th April
 */
public class Staff extends Employees{
	private double salary;
	private char perfCode;
	public Staff(long id, String firstName, String familyName, String cityOfResidence, int hireYear, double salary,char perfCode) {
		super(id, firstName, familyName, cityOfResidence, hireYear);
		this.perfCode=perfCode;
		this.salary=salary;
	}
	public Staff(){
		super();
		salary=0;
		perfCode='0';
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public char getPerfCode() {
		return perfCode;
	}
	public void setPerfCode(char perfCode) {
		this.perfCode = perfCode;
	}
	public String toString(){
		return super.toString() + " " + salary + " " + perfCode;
	}
}
