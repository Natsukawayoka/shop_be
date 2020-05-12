package com.my.pro.dto;

import java.util.ArrayList;
import java.util.List;

import com.my.pro.model.Goods;
import com.my.pro.model.Pp;

public class GoodsDto {
private Integer id;
	
	private String title;//标题
	
	private String url1;//封面
	
	private String url2;
	
	private String url3;
	
	private String url4;
	
    private double price;//价格	
    
    private Integer isDelete;
    
    private Integer isLb;//是否轮播 0 否 1 是
    
    private Integer num;//卖出数量
	
	private List<String> srcs = new ArrayList<String>();

	public List<String> getSrcs() {
		return srcs;
	}

	public void setSrcs(List<String> srcs) {
		this.srcs = srcs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl1() {
		return url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getUrl3() {
		return url3;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

	public String getUrl4() {
		return url4;
	}

	public void setUrl4(String url4) {
		this.url4 = url4;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsLb() {
		return isLb;
	}

	public void setIsLb(Integer isLb) {
		this.isLb = isLb;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
