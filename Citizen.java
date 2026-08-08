package ComplaintRegistration;

public class Citizen {
	
	private int citizenId;
	private String citizenName;
	private String phoneNumber;
	private String Address;
	
	public Citizen() {}
	
	public Citizen(int citizenId, String citizenName, String phoneNumber, String Address) {
		this.citizenId = citizenId;
		this.citizenName = citizenName;
		this.phoneNumber = phoneNumber;
		this.Address = Address;
	}

	public int getCitizenId() {
		return citizenId;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setCitizenId(int citizenId) {
		this.citizenId = citizenId;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		Address = address;
	}

	
	

}
