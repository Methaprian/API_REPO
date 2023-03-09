package pojoUtility;

public class Supplier_Module {

	//Step:01 - Declare the variables globally
	String companyName;
	String selectProvince;
	String selectCity;
	int phoneNumber;
	
	
	//Step02: - Create constructor to initialise the variables
	public Supplier_Module(String companyName, String selectProvince, String selectCity, int phoneNumber) {
		super();
		this.companyName = companyName;
		this.selectProvince = selectProvince;
		this.selectCity = selectCity;
		this.phoneNumber = phoneNumber;
	}


	//Step03: Provide getters and setters
	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getSelectProvince() {
		return selectProvince;
	}


	public void setSelectProvince(String selectProvince) {
		this.selectProvince = selectProvince;
	}


	public String getSelectCity() {
		return selectCity;
	}


	public void setSelectCity(String selectCity) {
		this.selectCity = selectCity;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
}
