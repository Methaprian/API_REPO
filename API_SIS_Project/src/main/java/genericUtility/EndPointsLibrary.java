package genericUtility;

public interface EndPointsLibrary {

	
	//Customer
	String createCustomer = "/createCustomer";
	String readCustomer = "/customers/";
	String readAllCustomers = "/customers";
	String updateCustomer = "/customers/";
	String deleteCustomer = "/customers/";
			
	//Supplier
	String createSupplier = "/createSupplier";
	String readSupplier = "/suppliers/";
	String readAllSuppliers = "/suppliers";
	String updateSupplier = "/suppliers/";
	String deleteSupplier = "/suppliers/";
}
