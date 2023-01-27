package jp.co.internous.ecsite.model.form;

import java.io.Serializable;

//ログイン後に表示するページの作成
//ログインに必要なhtmlのformからのusernameとpasswordを渡す
public class LoginForm implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private String userName;
	private String passWord;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String user_Name) {
		this.userName = user_Name;
	}
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String pass_Word) {
		this.passWord = pass_Word;
	}
	
}
