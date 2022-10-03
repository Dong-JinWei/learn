package com.dowei.pojo;

public class User {

	private Integer id;
	private String username;
	private String password;
	private String sex;
	private String age;
	private String phone;
	private String mail;
	private String all = "*";

	public String getAll() {
		return all;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", age=" + age
				+ ", phone=" + phone + ", mail=" + mail + "]";
	}

	public User(Integer id, String username, String password, String sex, String age, String phone, String mail) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.mail = mail;
	}

	public User() {
	}

	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User(String username, String password, String sex, String age, String phone, String mail, Integer id) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.mail = mail;
		this.id = id;
	}

}
