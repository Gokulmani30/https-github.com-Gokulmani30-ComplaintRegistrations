package ComplaintRegistration;

import java.sql.Date;
import java.time.LocalDate;

public class Complaint {

	
	 private int complaintId;
	    private int citizenId;
	    private int officerId;
	    private String complaintType;
	    private String description;
	    private Date complaintDate;
	    private String status;
	    private String resolution;
	    private LocalDate resolvedDate;

	    public Complaint() {
	    }

	    public Complaint(int citizenId,String complaintType, String description,Date complaintDate) {

	        this.citizenId = citizenId;
	        this.complaintType = complaintType;
	        this.description = description;
	        this.complaintDate = complaintDate;
	    }

	    public int getComplaintId() {
	        return complaintId;
	    }

	    public void setComplaintId(int complaintId) {
	        this.complaintId = complaintId;
	    }

	    public int getCitizenId() {
	        return citizenId;
	    }

	    public void setCitizenId(int citizenId) {
	        this.citizenId = citizenId;
	    }

	    public int getOfficerId() {
	        return officerId;
	    }

	    public void setOfficerId(int officerId) {
	        this.officerId = officerId;
	    }

	    public String getComplaintType() {
	        return complaintType;
	    }

	    public void setComplaintType(String complaintType) {
	        this.complaintType = complaintType;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public Date getComplaintDate() {
	        return complaintDate;
	    }

	    public void setComplaintDate(Date complaintDate) {
	        this.complaintDate = complaintDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getResolution() {
	        return resolution;
	    }

	    public void setResolution(String resolution) {
	        this.resolution = resolution;
	    }

	    public LocalDate getResolvedDate() {
	        return resolvedDate;
	    }

	    public void setResolvedDate(LocalDate resolvedDate) {
	        this.resolvedDate = resolvedDate;
	    }
}
