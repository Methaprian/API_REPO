package genericUtility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Database_Utility {
	
	public Driver driver;
	public Connection con = null;
	int set = 0;
	//Connect to database
	public void connectToDB() throws Throwable {
		 driver = new Driver();
		 DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUsername, IPathConstants.DBPassword);
	}
	
	
	//Disconnect from the database
	public void closeFromDB() throws SQLException {
		con.close();
	}
	
	//read data from the database
	public String readDataFromDB(String query, int columnIndex, String expdata) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			if (result.getString(columnIndex).equalsIgnoreCase(expdata)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Data has been validated upon the verification");
			return expdata;
		} else {
			System.out.println("Data has not been validated upon the verification");
			return "";
		}
		
	}
	
	//Delete Data in Database
	public void deleteDataInDBAndValidate(String expectedProject) throws Throwable {
		String query = "delete from project where project_Id = '"+expectedProject+"';";
		int set = con.createStatement().executeUpdate(query);
			if (set==1) {
				System.out.println("deleted successfully in Database");
			} else {
				System.out.println("Not achieved the deletion of the project in Database");
			}
	}
	
	//Update data in database
	public void updateDataInDB(String firstname, String lastname, double phonenumber) throws SQLException {
		String query = "insert into project values('"+firstname+"', '"+lastname+"', '"+phonenumber+"')";
		set = con.createStatement().executeUpdate(query);
		
		if (set==1) {
			System.out.println("Data updated successfully");
		} else {
			System.out.println("Data has not been updated");
		}
	}
}
