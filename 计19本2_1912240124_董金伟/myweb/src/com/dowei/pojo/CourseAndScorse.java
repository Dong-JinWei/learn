package com.dowei.pojo;

public class CourseAndScorse {

	private String username;
	private String cno;
	private String cname;
	private String ctecher;
	private String scid;
	private String scno;
	private String score;

	public String getCno() {
		return cno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtecher() {
		return ctecher;
	}

	public void setCtecher(String ctecher) {
		this.ctecher = ctecher;
	}

	public String getScid() {
		return scid;
	}

	public void setScid(String scid) {
		this.scid = scid;
	}

	public String getScno() {
		return scno;
	}

	public void setScno(String scno) {
		this.scno = scno;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "CourseAndScorse [username=" + username + ", cno=" + cno + ", cname=" + cname + ", ctecher=" + ctecher
				+ ", scid=" + scid + ", scno=" + scno + ", score=" + score + "]";
	}

	public CourseAndScorse() {
		// TODO Auto-generated constructor stub
	}

	public CourseAndScorse(String username, String cno, String cname, String ctecher, String scid, String scno,
			String score) {
		super();
		this.username = username;
		this.cno = cno;
		this.cname = cname;
		this.ctecher = ctecher;
		this.scid = scid;
		this.scno = scno;
		this.score = score;
	}

	public CourseAndScorse(String cname, String ctecher, String scno, String score) {
		super();
		this.cname = cname;
		this.ctecher = ctecher;
		this.scno = scno;
		this.score = score;
	}

	public CourseAndScorse(String scid, String scno) {
		super();
		this.scid = scid;
		this.scno = scno;
	}

	public CourseAndScorse(String score, String scid, String scno) {
		super();
		this.scid = scid;
		this.scno = scno;
		this.score = score;
	}

}
