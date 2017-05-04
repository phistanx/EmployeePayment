/**
 * child of faculty
 * @author Tristan Vu 40028927<br>
 * COMP 249<br>
 * Assignment 4<br>
 * Due Date: 10th April
 */
public class part_time extends Faculty{
	private double hourlyRate;
	private int numHrs;
	private int numStudents;
	public part_time(){
		super();
		hourlyRate=0;
		numHrs=0;
		numStudents=0;
	}
	public part_time(long id, String firstName, String familyName, String cityOfResidence, int hireYear, double hourlyRate, int numHrs, int numStudents) {
		super(id, firstName, familyName, cityOfResidence, hireYear);
		this.hourlyRate=hourlyRate;
		this.numHrs=numHrs;
		this.numStudents=numStudents;
	}
	public String toString(){
		return super.toString() + " " + hourlyRate
				+" " + numHrs + " "+ numStudents;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public int getNumHrs() {
		return numHrs;
	}
	public void setNumHrs(int numHrs) {
		this.numHrs = numHrs;
	}
	public int getNumStudents() {
		return numStudents;
	}
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	public double getSalary(){
		if(numStudents>40 && numStudents<60){
			return 500 + hourlyRate*numHrs;
		}
		else if(numStudents>60){
			return 1000 + hourlyRate*numHrs;
		}
		else
		return hourlyRate*numHrs;
	}
}
