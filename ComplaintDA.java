package ComplaintRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ComplaintDA {

	public void registerComplaint(Complaint complaint) {

        String sql = "INSERT INTO complaints(citizen_id, comp_type, description, comp_date, status)"
                + "VALUES (?, ?, ?, ?, 'Pending')";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, complaint.getCitizenId());
            ps.setString(2, complaint.getComplaintType());
            ps.setString(3, complaint.getDescription());
            ps.setDate(4, complaint.getComplaintDate());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println(
                        "Complaint Registered Successfully!"
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void assignOfficer(int complaintId, int officerId) {

        String sql = "UPDATE complaints SET offi_id=? WHERE comp_id=?";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, officerId);
            ps.setInt(2, complaintId);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Officer Assigned Successfully!");
            } else {
                System.out.println("Complaint ID Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

  
    public void updateStatus(int complaintId,String status,String resolution) {

        String sql;

        if (status.equalsIgnoreCase("Resolved")) {

            sql = "UPDATE complaints "
                    + "SET status=?, "
                    + "resolution=?, "
                    + "resolved_date=CURDATE() "
                    + "WHERE complaint_id=?";

        } else {

            sql = "UPDATE complaints "
                    + "SET status=?, "
                    + "resolution=? "
                    + "WHERE complaint_id=?";
        }

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setString(2, resolution);
            ps.setInt(3, complaintId);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println(
                        "Complaint Status Updated Successfully!"
                );
            } else {
                System.out.println(
                        "Complaint ID Not Found!"
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewResolution(int complaintId) {

        String sql =
                "SELECT c.comp_id, "
                + "ci.citizen_name, "
                + "ci.phonenum, "
                + "c.comp_type, "
                + "c.description, "
                + "c.comp_date, "
                + "c.status, "
                + "o.offi_name, "
                + "o.department, "
                + "c.resolution, "
                + "c.resolved_date "
                + "FROM complaints c "
                + "JOIN citizens ci "
                + "ON c.citizen_id = ci.citizen_id "
                + "LEFT JOIN officers o "
                + "ON c.offi_id = o.offi_id "
                + "WHERE c.comp_id=?";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, complaintId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "\n========== COMPLAINT DETAILS =========="
                );

                System.out.println(
                        "Complaint ID : "
                        + rs.getInt("comp_id"));

                System.out.println(
                        "Citizen      : "
                        + rs.getString("citizen_name"));

                System.out.println(
                        "Phone        : "
                        + rs.getString("phonenum"));

                System.out.println(
                        "Type         : "
                        + rs.getString("comp_type"));

                System.out.println(
                        "Description  : "
                        + rs.getString("description"));

                System.out.println(
                        "Complaint Date : "
                        + rs.getDate("comp_date"));

                System.out.println(
                        "Status       : "
                        + rs.getString("status"));

                System.out.println(
                        "Officer      : "
                        + rs.getString("offi_name"));

                System.out.println(
                        "Department   : "
                        + rs.getString("department"));

                System.out.println(
                        "Resolution   : "
                        + rs.getString("resolution"));

                System.out.println(
                        "Resolved Date: "
                        + rs.getDate("resolved_date"));

            } else {

                System.out.println(
                        "Complaint ID Not Found!"
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAllComplaints() {

        String sql =
                "SELECT c.comp_id, "
                + "ci.citizen_name, "
                + "c.comp_type, "
                + "c.comp_date, "
                + "c.status, "
                + "o.offi_name "
                + "FROM complaints c "
                + "JOIN citizens ci "
                + "ON c.citizen_id = ci.citizen_id "
                + "LEFT JOIN officers o "
                + "ON c.offi_id = o.offi_id "
                + "ORDER BY c.comp_id";

        try (Connection con = DBConnections.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println(
                    "\n========== ALL COMPLAINTS =========="
            );

            while (rs.next()) {

                System.out.println(
                        "Complaint ID : "
                        + rs.getInt("comp_id"));

                System.out.println(
                        "Citizen      : "
                        + rs.getString("citizen_name"));

                System.out.println(
                        "Type         : "
                        + rs.getString("comp_type"));

                System.out.println(
                        "Date         : "
                        + rs.getDate("comp_date"));

                System.out.println(
                        "Status       : "
                        + rs.getString("status"));

                System.out.println(
                        "Officer      : "
                        + rs.getString("offi_name"));

                System.out.println(
                        "------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
