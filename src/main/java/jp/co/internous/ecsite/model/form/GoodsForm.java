package jp.co.internous.ecsite.model.form;

import java.io.Serializable;

public class GoodsForm implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private long id;
	private String goodsName;
	private long price;
	
	public long getId() {
		return id;
	}
	public void setId(long ID) {
		this.id = ID;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goods_Name) {
		this.goodsName = goods_Name;
	}
	
	public long getPrice() {
		return price;
	}
	public void setPrice(long PRICE) {
		this.price = PRICE;
	}
}