package org.taxi24.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernatelazyinitializer","handler"})
public class Drivers {
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)*/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column(name = "fname")  
	private String firstName;
	
	@Column(name = "lname")  
	private String lastName;

	@Column(name = "dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date dob;

	@Column(name = "phone")  
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "doc_type")  
	private String docType;
	
	@Column(name = "doc_number") 
	private String docNumber;
	
	@Column(name = "license")  
	private String license;

    @Column(name = "reg_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
    
	@Column(name = "status")
	private boolean status;

	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "driver", orphanRemoval = true)
	List<Trips> trip;*/
	
	public Drivers() {
		super();
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


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDocType() {
		return docType;
	}


	public void setDocType(String docType) {
		this.docType = docType;
	}


	public String getDocNumber() {
		return docNumber;
	}


	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}


	public String getLicense() {
		return license;
	}


	public void setLicense(String license) {
		this.license = license;
	}


	public Date getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	/*public List<Trips> getTrip() {
		return trip;
	}


	public void setTrip(List<Trips> trip) {
		this.trip = trip;
	}*/


	@Override
	public String toString() {
		return "Drivers [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", phone="
				+ phone + ", email=" + email + ", docType=" + docType + ", docNumber=" + docNumber + ", license="
				+ license + ", registrationDate=" + registrationDate + ", status=" + status + "]";
	}


	
}
