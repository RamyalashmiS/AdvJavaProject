package proj.entity.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Users")
public class User {
	
	@Column(name="uname",length=30)
	private String userName;
	@Id
	@Column(name="email",length=30)
	private String email;
	@Column(name="pwd",length=15)
	private String password;	
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int userId;
	public User() {
		super();
	}
	public User(int userId, String userName, String email, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		
	}
	public String getUserName() {
		return userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
