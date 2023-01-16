package models;

public class Home {
	
	int id;
	int A_p;
	int A_m;
	int B_p;
	int B_m;
	int O_p;
	int O_m;
	int AB_p;
	int AB_m;
	int 
   Total_donor;
	
	
	
	
	
	
	
	public Home () {
		super();
	}
	
	public Home (int id,int A_p,int A_m,int B_p,int B_m,int O_p,int O_m,int AB_p,int AB_m,	int 
			   Total_donor ){
		
		this.id=id;
		this.A_p=A_p;
		this.A_m=A_m;
		this.O_p=O_p;
		this.O_m=O_m;
		this.B_p=B_p;
		this.B_m=B_m;
		this.AB_p=AB_p;
		this.AB_m=AB_m;
		
		
	}

	
	public int getTotal_donor() {
		return Total_donor;
	}

	public void setTotal_donor(int total_donor) {
		this.Total_donor = total_donor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getA_p() {
		return A_p;
	}

	public void setA_p(int a_p) {
		A_p = a_p;
	}

	public int getA_m() {
		return A_m;
	}

	public void setA_m(int a_m) {
		A_m = a_m;
	}

	public int getB_p() {
		return B_p;
	}

	public void setB_p(int b_p) {
		B_p = b_p;
	}

	public int getB_m() {
		return B_m;
	}

	public void setB_m(int b_m) {
		B_m = b_m;
	}

	public int getO_p() {
		return O_p;
	}

	public void setO_p(int o_p) {
		O_p = o_p;
	}

	public int getO_m() {
		return O_m;
	}

	public void setO_m(int o_m) {
		O_m = o_m;
	}

	public int getAB_p() {
		return AB_p;
	}

	public void setAB_p(int aB_p) {
		AB_p = aB_p;
	}

	public int getAB_m() {
		return AB_m;
	}

	public void setAB_m(int aB_m) {
		AB_m = aB_m;
	}
	
	
	

}
