package com.musicstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authorities")
public class Authorities{
	
	@Id
	@GeneratedValue
	@Column(name = "authoritiesId")
	private long authoritiesId;
	@Column(name = "username")
	private String username;
	@Column(name = "authority")
	private String authority;
	
	
	public long getAuthoritiesId() {
		return authoritiesId;
	}
	public void setAuthoritiesId(long authoritiesId) {
		this.authoritiesId = authoritiesId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
