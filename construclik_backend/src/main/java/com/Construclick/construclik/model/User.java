package com.Construclick.construclik.model;


import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long id;
	
	@Column(name="username", length=60, nullable=false, unique=true)
	private String username;
	
	@Column(name="email", length=120, nullable=false, unique=true)
	private String email;
	
	@Column(name="password", length=24, nullable=false, unique=false)
	private String password;
	
	@Column(name="phone", length=10, nullable=false, unique=true)
	private Long phone;

	public User() {
		
	}
	
	public User(Long id, String username, String email, String password, Long phone) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", phone="
				+ phone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, phone, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
				&& Objects.equals(username, other.username);
	}
	
	
}
