package com.musicstore.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users{
	@Id
    @GeneratedValue
    @Column(name = "usersId")
	private long usersId;
	
	@Column(name = "UserName")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column (name = "enabled")
	private boolean enabled;
	
	@Column(name = "customerId")
	private long customerId;
	
	public long getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	
	
	
	
	
	

}
