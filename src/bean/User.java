package bean;

public class User {
	private String username ;
	private String mail ;
	private String password ;
	private int age ;
	
	
	public User(String username, String mail, String password, int age) {
		super();
		this.username = username;
		this.mail = mail;
		this.password = password;
		this.age = age;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
