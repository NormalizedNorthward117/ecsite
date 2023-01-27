package jp.co.internous.ecsite.model.form;

import java.io.Serializable;
import java.util.List;

//Cartクラスのリストを保持する
public class CartForm implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private long userId;
	private List<Cart> cartList;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long user_ID) {
		this.userId = user_ID;
	}
	
	public List<Cart> getCartList() {
		return cartList;
	}
	public void setCartList(List<Cart> CartList) {
		this.cartList = CartList;
	}
	
}
