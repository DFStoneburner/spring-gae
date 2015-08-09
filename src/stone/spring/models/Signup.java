package stone.spring.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Signup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	
	private String email;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date signUpDate;

	@Version
	private int version;

	protected Signup() {
	}

	public Signup(String firstName, String lastName, String email,
			Date signUpDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.signUpDate = signUpDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}
}
