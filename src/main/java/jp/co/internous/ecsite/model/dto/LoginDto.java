package jp.co.internous.ecsite.model.dto;

import jp.co.internous.ecsite.model.entity.USER;

//ログイン情報をJavaからControllerに渡す
public class LoginDto {
	
	private long id;
	private String userName;
	private String passWord;
	private String fullName;
	
	public LoginDto() {}
	
	public LoginDto(USER user) {
		
		this.id = user.getID();
		this.userName = user.getUSERNAME();
		this.passWord = user.getPASSWORD();
		this.fullName = user.getFULLNAME();
	}
	
	public LoginDto(long id, String userName, String password, String fullName ) {
		this.id = id;
		this.userName = userName;
		this.passWord = password;
		this.fullName = fullName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long ID) {
		this.id = ID;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String user_Name) {
		this.userName = user_Name;
	}
	
	public String getPassword() {
		return passWord;
	}
	public void setPassword(String pass_Word) {
		this.passWord = pass_Word;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String full_name) {
		this.fullName = full_name;
	}

}
