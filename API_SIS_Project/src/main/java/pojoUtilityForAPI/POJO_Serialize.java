package pojoUtilityForAPI;

public class POJO_Serialize {

	//Declare Variables Globally
	String eName;
	String designation;
	long pNo;
	
	
	//Create Constructor
	public POJO_Serialize(String eName, String designation, long pNo) {
		super();
		this.eName = eName;
		this.designation = designation;
		this.pNo = pNo;
	}
	
	// Declare Empty Constructor for initializing Serialization and Desialization 
	public POJO_Serialize() {
	}

	//Provide Getters and Setters
	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getpNo() {
		return pNo;
	}

	public void setpNo(long pNo) {
		this.pNo = pNo;
	}
	
}
