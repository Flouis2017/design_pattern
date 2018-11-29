package com.flouis.entity;

import com.flouis.tool.StringTool;

/**
 * @author Flouis
 * @date 2018/11/29
 * @description User entity class for test
 **/
public class User {

	private Long id;
	private String username;
	private Integer gender;
	private String phone;
	private String appCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return StringTool.getString(username);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return StringTool.getString(phone);
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAppCode() {
		return StringTool.getString(appCode);
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", gender=" + gender +
				", phone='" + phone + '\'' +
				", appCode='" + appCode + '\'' +
				'}';
	}

}
