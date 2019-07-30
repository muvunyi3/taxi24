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
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernatelazyinitializer","handler"})
public class Trips {
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)*/
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long tripId;

	@ManyToOne
    @JoinColumn(name = "driver_fk")
	Drivers driver;
	
	@ManyToOne
    @JoinColumn(name = "rider_fk")
	Riders rider;

    @Column(name = "pick_up")
	private String pickUp;

    @Column(name = "destination")
	private String destination;

    @Column(name = "trip_price")
	private Double price;

    @Column(name = "trip_distance")
	private Double distance;
	
    @Column(name = "trip_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date tripDate;

    @Column(name = "complete_datetime")
    private Date completeDate;

	@Column(name = "status")
	private boolean status;

	public Trips() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Drivers getDriver() {
		return driver;
	}

	public void setDriver(Drivers driver) {
		this.driver = driver;
	}

	public Riders getRider() {
		return rider;
	}

	public void setRider(Riders rider) {
		this.rider = rider;
	}

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	@Override
	public String toString() {
		return "Trips [tripId=" + tripId + ", driver=" + driver + ", rider=" + rider + ", pickUp=" + pickUp
				+ ", destination=" + destination + ", price=" + price + ", distance=" + distance + ", tripDate="
				+ tripDate + ", completeDate=" + completeDate + ", status=" + status + "]";
	}

		
	
	
}
