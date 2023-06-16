package pojoUtilityForAPI;

public class POJO_API_Object {

	String eName;
	Details_POJO detail;
	
	public POJO_API_Object(String eName, Details_POJO detail) {
		super();
		this.eName = eName;
		this.detail = detail;
	}
	
	
	public POJO_API_Object() {}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public Details_POJO getDetail() {
		return detail;
	}


	public void setDetail(Details_POJO detail) {
		this.detail = detail;
	}
	
	
}
