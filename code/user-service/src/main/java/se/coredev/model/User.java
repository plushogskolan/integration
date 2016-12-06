package se.coredev.model;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlElementWrapper;
//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public final class User {

//	@XmlElement
	private final Long id;
//	@XmlElement
	private final String username;
//	@XmlElement
	private final String password;
//	@XmlElement(name = "role")
//	@XmlElementWrapper(name="roles")
	private final List<String> roles;

	@SuppressWarnings("unused")
	private User() {
		id = -1L;
		username = null;
		password = null;
		roles = null;
	}

	public User(Long id, String username, String password, List<String> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public User addRole(String role){
		roles.add(role);
		return this;
	}

	public List<String> getRoles() {
		return roles;
	}
}
