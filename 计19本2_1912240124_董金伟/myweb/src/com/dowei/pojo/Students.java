package com.dowei.pojo;

public class Students {
	private Integer sID;
	private String sName;
	private String sClass;
	private String sSex;
	private String sPec;
	private String Sdept;
	private String Sage;
	private String Sphone;

	public Integer getsID() {
		return sID;
	}

	public void setsID(Integer sID) {
		this.sID = sID;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public String getsSex() {
		return sSex;
	}

	public void setsSex(String sSex) {
		this.sSex = sSex;
	}

	public String getsPec() {
		return sPec;
	}

	public void setsPec(String sPec) {
		this.sPec = sPec;
	}

	public String getSdept() {
		return Sdept;
	}

	public void setSdept(String sdept) {
		Sdept = sdept;
	}

	public String getSage() {
		return Sage;
	}

	public void setSage(String sage) {
		Sage = sage;
	}

	public String getSphone() {
		return Sphone;
	}

	public void setSphone(String sphone) {
		Sphone = sphone;
	}

	@Override
	public String toString() {
		return "Students [sID=" + sID + ", sName=" + sName + ", sClass=" + sClass + ", sSex=" + sSex + ", sPec=" + sPec
				+ ", Sdept=" + Sdept + ", Sage=" + Sage + ", Sphone=" + Sphone + "]";
	}

	// alt+/
	public Students() {
		// TODO Auto-generated constructor stub
	}

	// alt+shift+s+o
	public Students(Integer sID, String sName, String sClass, String sSex, String sPec, String sdept, String sage,
			String sphone) {
		super();
		this.sID = sID;
		this.sName = sName;
		this.sClass = sClass;
		this.sSex = sSex;
		this.sPec = sPec;
		Sdept = sdept;
		Sage = sage;
		Sphone = sphone;
	}

	public Students(String sName, String sClass, String sSex, String sPec, String sdept, String sage, String sphone,
			Integer sID) {
		super();
		this.sName = sName;
		this.sClass = sClass;
		this.sSex = sSex;
		this.sPec = sPec;
		Sdept = sdept;
		Sage = sage;
		Sphone = sphone;
		this.sID = sID;
	}
}
