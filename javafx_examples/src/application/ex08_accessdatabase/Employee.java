package application.ex08_accessdatabase;

public class Employee {
	private int empNo;
	private String firstName;
	private String lastName;
		
	public Employee(int empNo, String firstName, String lastName) {
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getEmpNo() {
		return empNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	
	
}
