package com.chainsys.demo2.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class User {
	private int id;
	private String userName;
	private int age;
	private String mobileNo;
	private String gender;
	private String address;
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User(int id, String userName, int age, String mobileNo, String gender, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.address = address;
	}
	
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + ", mobileNo=" + mobileNo + ", gender=" + gender
				+ ", address=" + address + "]";
	}
	
	

}
