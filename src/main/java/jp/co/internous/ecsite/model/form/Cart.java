package jp.co.internous.ecsite.model.form;

import java.io.Serializable;

//カートに入れた商品のリストの取得
public class Cart implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private long id;
	private long userId;
	private String goodsName;
	private long price;
	private long count;
	
	public long getId() {
		return id;
	}
	public void setId(long ID) {
		this.id = ID;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long user_ID) {
		this.userId = user_ID;
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
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
}
