package models;

public class Donor {
	int id;
	String Fullname;
	String CIN;
	String Gender;
	int Mobile;
	String Bloodtype;
	String Action;
	
	
	public Donor () {
		super();
	}
	
	public Donor (int id,String Fullname,String CIN,String gender,int Mobile,String bloodtype,String Action) {
		
		this.id=id;
		this.Fullname=Fullname;
		this.CIN=CIN;
		this.Gender=gender;
		this.Mobile=Mobile;
		this.Bloodtype=bloodtype;
		this.Action=Action;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public int getMobile() {
		return Mobile;
	}

	public void setMobile(int mobile) {
		Mobile = mobile;
	}

	public String getBloodtype() {
		return Bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.Bloodtype = bloodtype;
	}

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}
	
	
	
	

}
