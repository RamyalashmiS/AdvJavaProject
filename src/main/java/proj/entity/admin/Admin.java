package proj.entity.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Admin")
public class Admin {
	
	@Id
	@Column(name="email",length=30)
	private String email;
	@Column(name="pwd",length=15)
	private String password;	
	
	public Admin() {
		super();
	}
	public Admin( String email, String password) {
		super();
		this.email = email;
		this.password = password;
		
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
