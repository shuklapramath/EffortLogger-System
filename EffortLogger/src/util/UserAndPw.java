package util;

public class UserAndPw {
	
	private String userName;
	private String password;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getuserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getPasswordLength() {
		return password.length();
	}
}