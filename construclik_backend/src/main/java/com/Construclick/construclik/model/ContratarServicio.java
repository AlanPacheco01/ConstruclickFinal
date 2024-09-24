package com.Construclick.construclik.model;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name="contractar_Servicio")
public class ContratarServicio {
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

	@Column(name="category", length=24, nullable=false, unique=false)
	private String category;

	public ContratarServicio() {
	}

	public ContratarServicio(Long id, String username, String email, String password, Long phone, String category) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.category = category;
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

	public String getCategory() {
		return category;
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

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "contractarServico [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, email, id, password, phone, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContratarServicio other = (ContratarServicio) obj;
		return Objects.equals(category, other.category) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(username, other.username);
	}

	
	
}
