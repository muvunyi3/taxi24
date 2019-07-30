package org.taxi24.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernatelazyinitializer","handler"})
public class Locations {

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)*/

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

    @Column(name = "loc_name")
    private String LocName;
    

    @Column(name = "enter_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date enterDate;

	@ManyToOne
    @JoinColumn(name = "driver_fk")
	Drivers driver;
	
    public Locations() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLocName() {
		return LocName;
	}



	public void setLocName(String locName) {
		LocName = locName;
	}



	public Drivers getDriver() {
		return driver;
	}



	public void setDriver(Drivers driver) {
		this.driver = driver;
	}



	public Date getEnterDate() {
		return enterDate;
	}



	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}



	@Override
	public String toString() {
		return "Locations [id=" + id + ", LocName=" + LocName + ", enterDate=" + enterDate + ", driver=" + driver + "]";
	}


    
    
}
