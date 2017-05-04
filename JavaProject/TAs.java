/**
 * child of employees
 * @author Tristan Vu 40028927<br>
 * COMP 249<br>
 * Assignment 4<br>
 * Due Date: 10th April
 */
public class TAs extends Employees{
	private String classification;
	private int numClasses;
	private int numWorkHrs;
	public TAs(long id, String firstName, String familyName, String cityOfResidence, int hireYear, String classification, int numClasses,int numWorkHrs) {
		super(id, firstName, familyName, cityOfResidence, hireYear);
		this.classification=classification;
		this.numClasses=numClasses;
		this.numWorkHrs=numWorkHrs;
	}
	public TAs(){
		super();
		classification=null;
		}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String toString(){
		return super.toString() + " " + classification + " " + numClasses;
	}
	public int getNumClasses() {
		return numClasses;
	}
	public void setNumClasses(int numClasses) {
		this.numClasses = numClasses;
	}
	public int getNumWorkHrs() {
		return numWorkHrs;
	}
	public void setNumWorkHrs(int numWorkHrs) {
		this.numWorkHrs = numWorkHrs;
	}
	public double getSalary(){
		if(classification.equals("UGrad")){
			return 18.25*numWorkHrs;
		}
		else if(classification.equals("Grad")){
			return 18.25*1.2*numWorkHrs;
		}
		else return 0;
	}
}
