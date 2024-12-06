package staffAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class staffDBUtil {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	   private static boolean isSuccess;
	
	    //Method to validate Admin login
		public static boolean validateAdmin(String username, String password) {

			// validate
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "select * from member where username='" + username + "'and password='" + password + "'";
				rs = stmt.executeQuery(sql); 

				if (rs.next()) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return isSuccess;

		}
	
	//display staff member details
	public static List<staff> validate(String username, String password){
		ArrayList<staff> sta = new ArrayList<>();

		//validate
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from member where username='"+username+"' and password='"+password+"'";
			
			rs = stmt.executeQuery(sql); 
			
			if(rs.next()) {
				int empID = rs.getInt(1);
				String usernameS = rs.getString(2);
				String passwordS = rs.getString(3);
				String post = rs.getString(4);
				String phoneNumber = rs.getString(5);
				String gender = rs.getString(6);
				String email = rs.getString(7);
				
				staff s = new staff(empID, usernameS, passwordS, post, phoneNumber, gender, email);
				sta.add(s);
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return sta;
	}
	
	//method to insert staff details
	public static boolean insertStaff(String username, String password, String post, String phoneNumber, String gender, String email) {
		boolean isSucess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into member values(0, '"+username+"', '"+password+"', '"+post+"', '"+phoneNumber+"', '"+gender+"', '"+email+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSucess = true;
			}
			else {
				isSucess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSucess;
	}
	
	//Method to retrieve staff details from database
		public static List<staff> getStaffInfo() {
			ArrayList<staff> staff = new ArrayList<>();
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM member";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					int empID = rs.getInt(1);
					String usernameS = rs.getString(2);
					String passwordS = rs.getString(3);
					String post = rs.getString(4);
					String phoneNumber = rs.getString(5);
					String gender = rs.getString(6);
					String email = rs.getString(7);

					staff s = new staff(empID, usernameS, passwordS, post, phoneNumber, gender, email);
					staff.add(s);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return staff;
		}
		
		//Method to update staff members
		public static boolean updateStaff(String empID, String username, String password, String post, String phoneNumber, String gender, String email) {
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				
				String sql = "update member set username='"+username+"', password='"+password+"', post='"+post+"', phoneNumber='"+phoneNumber+"', gender='"+gender+"', email='"+email+"'"
						     + "where empID='"+empID+"'";
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}
		
		public static List<staff> getStaffDetails(String empID){
			
			int convertedID = Integer.parseInt(empID); 
			ArrayList<staff> sta = new ArrayList<>();
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "select * from member where empID='"+convertedID+"'";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int empID1 = rs.getInt(1);
					String username = rs.getString(2);
					String password = rs.getString(3);
					String post = rs.getString(4);
					String phoneNumber = rs.getString(5);
					String gender = rs.getString(6);
					String email = rs.getString(7);
					
					staff s = new staff(empID1, username, password, post, phoneNumber, gender, email);
					sta.add(s);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return sta;
		}
		
		//Method to delete staff member profile
		public static boolean deleteStaff(String empID) {
			
			int convertedID = Integer.parseInt(empID);
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "delete from member where empID='"+convertedID+"'";
				
				int r = stmt.executeUpdate(sql);
				
				if(r > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}
}