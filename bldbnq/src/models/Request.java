package models;

public class Request {
	
	String titleR;
	String Requste;
	int id ;
	public Request() {
		super();
	}
	public Request(int id,String titleR, String requste ) {
		
		this.titleR = titleR;
		this.Requste = requste;
		this.id = id;
	}
	public String getTitleR() {
		return titleR;
	}
	public void setTitleR(String titleR) {
		this.titleR = titleR;
	}
	public String getRequste() {
		return Requste;
	}
	public void setRequste(String requste) {
		Requste = requste;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	

}
