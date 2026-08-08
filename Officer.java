package ComplaintRegistration;

public class Officer {

	private int officerId;
    private String officerName;
    private String department;
    private String phonenum;

    public Officer() {
    }

    public Officer(String officerName,String department,String phonenum) {

        this.officerName = officerName;
        this.department = department;
        this.phonenum = phonenum;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phonenum;
    }

    public void setPhone(String phone) {
        this.phonenum = phone;
    }
}
