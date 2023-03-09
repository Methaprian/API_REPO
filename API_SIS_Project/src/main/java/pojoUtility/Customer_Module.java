package pojoUtility;

public class Customer_Module {

	
	//Step:01 - Declare the variables globally
	String firstName;
	String lastName;
	int phoneNumber;
	
	
	//Step:02 - create constructor to initialise the variables
	public Customer_Module(String firstName, String lastName, int phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	
	//Step03: provide getters and setters
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
