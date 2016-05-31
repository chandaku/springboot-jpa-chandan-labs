/**
 * 
 */
package com.chandan.labs.security.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "user_survey", name = "USERS")
public class User 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWD")
	private String passwd;
	
	@Column(name = "DOB")
	private Date dob;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Set<Role> roles = new HashSet<>();
	
	public User() {
	}

	public User(int id, String name, String email, String passwd, Date dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", dob=" + dob + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
