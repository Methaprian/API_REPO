package pojoUtilityForAPI;

public class Details_POJO {
	
	String designation;
	long[] pNo;
	
	public Details_POJO(String designation, long[] pNo) {
		super();
		this.designation = designation;
		this.pNo = pNo;
	}
	
	public Details_POJO() {}

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
