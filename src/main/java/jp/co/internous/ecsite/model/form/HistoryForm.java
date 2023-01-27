package jp.co.internous.ecsite.model.form;

import java.io.Serializable;

//フロントからユーザデータを渡す
public class HistoryForm implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String user_ID) {
		this.userId = user_ID;
	}
	
	
	
}
