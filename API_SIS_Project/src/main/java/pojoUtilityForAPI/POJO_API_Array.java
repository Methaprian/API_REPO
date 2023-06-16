package pojoUtilityForAPI;

public class POJO_API_Array {

	String eName;
	String designation;
	long[] pNo;
	
	
	public POJO_API_Array(String eName, String designation, long[] pNo) {
		super();
		this.eName = eName;
		this.designation = designation;
		this.pNo = pNo;
	}
	
	//Empty Constructor for Serialization and Serialization
	public POJO_API_Array() {
	}

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

	public long[] getpNo() {
		return pNo;
	}

	public void setpNo(long[] pNo) {
		this.pNo = pNo;
	}
	
}
