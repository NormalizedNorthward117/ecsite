package jp.co.internous.ecsite.model.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import jp.co.internous.ecsite.model.entity.PURCHASE;

//DBから取得した購入履歴データをフロントに渡す
public class HistoryDTO {
	
	private long id;
	private long userId;
	private long goodsId;
	private String goodsName;
	private long itemCount;
	private long total;
	private String createdAt;
	
	public HistoryDTO() {}
	
	public HistoryDTO(PURCHASE entity) {
		
		this.id = entity.getID();
		this.userId = entity.getUSERID();
		this.goodsId = entity.getGOODSID();
		this.goodsName = entity.getGOODSNAME();
		this.itemCount = entity.getITEMCOUNT();
		this.total = entity.getTotal();
		
		Timestamp d = entity.getCREATEDAT();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		
		this.createdAt = sdf.format(d);
		
	}
	
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
	
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goods_ID) {
		this.goodsId = goods_ID;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goods_Name) {
		this.goodsName = goods_Name;
	}
	
	public long getItemCount() {
		return itemCount;
	}
	public void setItemCount(long item_Count) {
		this.itemCount = item_Count;
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long TOTAL) {
		this.total = TOTAL;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String created_At) {
		this.createdAt = created_At;
	}
	
}
