package com.my.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 购物车
 * @author
 *
 */
@Entity
@Table(name="car")
public class Car {
	
	private Integer id;
	
	private Goods goods;//商品
	
	private User user;//用户

	private Integer num;
	
	private double price;
	
	private int selected;//0 否 1 是
	
	
	public Integer getNum() {
		return num;
	}



	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="goodsId")
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public void setNum(Integer num) {
		this.num = num;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getSelected() {
		return selected;
	}



	public void setSelected(int selected) {
		this.selected = selected;
	}





	

}
