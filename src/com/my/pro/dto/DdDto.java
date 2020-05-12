package com.my.pro.dto;

public class DdDto {

	private Integer id;
	private Integer ddId;
	private String code;
	private String price;
	
	private String dj;//单价
	
	private String ppUrl;
	
	private Integer spId;
	
	
    private String name;
	
	private String phone;
	
	private String address;
	
	private Double cost;
	
	private Integer num;
	
	private Integer isPj;
	
	
	private Integer status;//订单状态 0 已支付待发货 1 已发货 2.申请退款 3 已退款 4 已收货 5 已评价
	
	public Integer getDdId() {
		return ddId;
	}

	public void setDdId(Integer ddId) {
		this.ddId = ddId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPpUrl() {
		return ppUrl;
	}

	public void setPpUrl(String ppUrl) {
		this.ppUrl = ppUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String title;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDj() {
		return dj;
	}

	public void setDj(String dj) {
		this.dj = dj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsPj() {
		return isPj;
	}

	public void setIsPj(Integer isPj) {
		this.isPj = isPj;
	}

	public Integer getSpId() {
		return spId;
	}

	public void setSpId(Integer spId) {
		this.spId = spId;
	}
	
	
}
