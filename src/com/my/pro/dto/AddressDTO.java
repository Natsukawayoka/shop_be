package com.my.pro.dto;

import com.my.pro.model.User;

public class AddressDTO {

	private Integer id;
	
	
	private String sheng;//省市区
	
	private String shi;
	
	private String qu;
	
	private String dz;//地址
	
	private String name;
	
	private String phone;
	
	private Integer isMr;//是否默认 0 否 1 是

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSheng() {
		return sheng;
	}

	public void setSheng(String sheng) {
		this.sheng = sheng;
	}

	public String getShi() {
		return shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getQu() {
		return qu;
	}

	public void setQu(String qu) {
		this.qu = qu;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIsMr() {
		return isMr;
	}

	public void setIsMr(Integer isMr) {
		this.isMr = isMr;
	}
	
	
}
