package ComplaintRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OfficerDA {

	 public void registerOfficer(Officer off) {

	        String sql = "INSERT INTO officers "
	                + "(offi_name, department, phonenum) "
	                + "VALUES (?, ?, ?)";

	        try (Connection con = DBConnections.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, off.getOfficerName());
	            ps.setString(2, off.getDepartment());
	            ps.setString(3, off.getPhone());

	            int result = ps.executeUpdate();

	            if (result > 0) {
	                System.out.println(
	                        "Officer Registered Successfully!"
	                );
	            }

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	   
	    public void viewOfficers() {

	        String sql = "SELECT * FROM officers";

	        try (Connection con = DBConnections.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            System.out.println("\n========== OFFICER DETAILS ==========");

	            while (rs.next()) {

	                System.out.println(
	                        "Officer ID : "
	                        + rs.getInt("offi_id"));

	                System.out.println(
	                        "Name       : "
	                        + rs.getString("offi_name"));

	                System.out.println(
	                        "Department : "
	                        + rs.getString("department"));

	                System.out.println(
	                        "Phone      : "
	                        + rs.getString("phonenum"));

	                System.out.println(
	                        "------------------------------------");
	            }

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

		
}
