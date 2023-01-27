package jp.co.internous.ecsite.model.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="goods")
public class GOODS {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@Column(name="goods_name")
	private String GOODSNAME;
	
	@Column(name="price")
	private long PRICE;
	
	@Column(name="updated_at")
	private Timestamp UPDATEDAT;
	
	public long getID() {
		return ID;
	}
	public void setID(long id) {
		this.ID = id;
	}
	
	public String getGOODSNAME() {
		return GOODSNAME;
	}
	public void setGOODSNAME(String GoodsName) {
		this.GOODSNAME = GoodsName;
	}
	
	public long getPRICE() {
		return PRICE;
	}
	public void setPRICE(long price) {
		this.PRICE = price;
	}
	
	public Timestamp getUpdated_At() {
		return UPDATEDAT;
	}
	public void setUPDATEDAT(Timestamp updatedAt) {
		this.UPDATEDAT = updatedAt;
	}
	
	
}
