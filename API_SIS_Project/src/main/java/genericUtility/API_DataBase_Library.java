package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class API_DataBase_Library {
	
	Driver driverRef;
	Connection con;
	
	/**
	 * @author METHAPRIAN S.K
	 * 
	 * Connect To the Database
	 * 
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(API_IConstants.dbURL, API_IConstants.dbUserName, API_IConstants.dbPassword);
		
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * 
	 * Fetch Data From Database and return the value only if the Validation is verified
	 * 
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String readDataFromDB(String query, int columnIndex,String expData) throws SQLException {
		
		boolean flag=false;
		ResultSet result =con.createStatement().executeQuery(query);
		while (result.next()) {
			if (result.getString(columnIndex).equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if (flag) {
			System.out.println("Data Verified");
			return expData;
		}else {
			System.out.println("Data Not Verified");
			return "";
		}
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * 
	 * Disconnect From Database
	 * 
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
	}

}
