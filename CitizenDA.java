package ComplaintRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CitizenDA {

	Connection con = DBConnections.getConnection();
	
	public void addCitizen(Citizen citi) {
		String sql = "INSERT INTO citizens(citizen_name, phonenum, address)"
				+ "VALUES (?, ?, ? )";		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, citi.getCitizenName());
			ps.setString(2, citi.getPhoneNumber());
			ps.setString(3, citi.getAddress());
			
			int rows = ps.executeUpdate();

			if (rows > 0) {
			    System.out.println("Citizen Registered Successfully.");
			}else {
				System.out.println("Citizen Registration failed!!");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
				
	}
	
	public void viewCitizen() {
		
		String sql = "select * from citizens";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("\n------------------CITIZEN LISTS--------------------");
			
			while(rs.next()) {
				System.out.println("Citizen ID              : " + rs.getInt("citizen_id"));
				System.out.println("Citizen NAME            : " + rs.getString("citizen_name"));
				System.out.println("Phone Number            : " + rs.getString("phonenum"));
				System.out.println("Addresss                : " + rs.getString("address"));
				
				System.out.println("\n-------------------------------------------------------");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void updateCitizen(Citizen citi) {
		
		String sql = "UPDATE citizens SET citizen_name = ?, phonenum = ?, address = ? WHERE citizen_id = ?";
	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, citi.getCitizenName());
		ps.setString(2, citi.getPhoneNumber());
		ps.setString(3, citi.getAddress());
		ps.setInt(4,citi.getCitizenId());
		
		int rows = ps.executeUpdate();
		
		if(rows > 0) {
			System.out.println("Citizen Record updated successfully.");
			
		}else {
			System.out.println("Citizen Id not found!!!");
		}
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	}

	
	public void deleteCitizen(int citiId) {
		
		String sql = "DELETE FROM citizens WHERE citizen_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, citiId);
			 
			int rows = ps.executeUpdate();
			if(rows > 0) {
				System.out.println("Citizen Id Deleted successfully!!!");
			}else {
				System.out.println("Citizen Id not found..");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
   }
}