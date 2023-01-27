package jp.co.internous.ecsite.model.entity;

//購入情報をJava側からフロントに渡す
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="purchase")
public class PURCHASE {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@Column(name="user_id")
	private long USERID;
	
	@Column(name="goods_id")
	private long GOODSID;
	
	@Column(name="goods_name")
	private String GOODSNAME;
	
	@Column(name="item_count")
	private long ITEMCOUNT;
	
	@Column(name="total")
	private long Total;
	
	@Column(name="created_at")
	private Timestamp CREATEDAT;
	
	public long getID() {
		return ID;
	}
	public void setID(long id) {
		this.ID = id;
	}
	
	public long getUSERID() {
		return USERID;
	}
	public void setUSERID(long userId) {
		this.USERID = userId;
	}
	
	public long getGOODSID() {
		return GOODSID;
	}
	public void setGOODSID(long goodsId) {
		this.GOODSID = goodsId;
	}
	
	public String getGOODSNAME() {
		return GOODSNAME;
	}
	public void setGOODSNAME(String GoodsName) {
		this.GOODSNAME = GoodsName;
	}
	
	public long getITEMCOUNT() {
		return ITEMCOUNT;
	}
	public void setITEMCOUNT(long itemCount) {
		this.ITEMCOUNT = itemCount;
	}
	
	public long getTotal() {
		return Total;
	}
	public void setTotal(long total) {
		this.Total = total;
	}
	
	public Timestamp getCREATEDAT() {
		return CREATEDAT;
	}
	public void setCREATEDAT(Timestamp createdAt) {
		this.CREATEDAT = createdAt;
	}
	
}
