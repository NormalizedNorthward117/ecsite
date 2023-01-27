package jp.co.internous.ecsite.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Entityアノテーション：対象にEntity機能を付与
@Table(name="user")
//@table(name="テーブル名")アノテーション：対象にテーブルの実体であることを付与
public class USER {
	
	@Id
//@Id：対象にプライマリキーを付与
	@Column(name="id")
//@Column(name=カラム名)：対象にカラムの実体であることを付与
	@GeneratedValue(strategy = GenerationType.IDENTITY)
/* @GeneratedValue()
 * idフィールドの振る舞いを指定
 * GenerationType.IDENTITYでAuto_increment付与*/
	private long ID;
	
	@Column(name="user_name")
	private String USERNAME;
	
	@Column(name="password")
	private String PASSWORD;
	
	@Column(name="full_name")
	private String FULLNAME;
	
	@Column(name="is_admin")
	private int ISADMIN;
	
	//ここまでで各カラムの変数定義終了
	//ここからgetterとsetter
	
	public long getID() {
		return ID;
	}
	public void setID(long id) {
		this.ID = id;
	}
	
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String UserName) {
		this.USERNAME = UserName;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String PassWord) {
		this.PASSWORD = PassWord;
	}
	
	public String getFULLNAME() {
		return FULLNAME;
	}
	public void setFULLNAME(String fullName) {
		this.FULLNAME = fullName;
	}
	
	public int getISADMIN() {
		return ISADMIN;
	}
	public void setISADMIN(int isAdmin) {
		this.ISADMIN = isAdmin;
	}
}
