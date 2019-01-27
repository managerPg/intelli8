package com.intelli8.POJO;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
@SequenceGenerator(name="seq", initialValue=101)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	@Column(name = "customerId")
	private int customerId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phoneNumber")
	private BigInteger phoneNumber;

	@Column(name = "joinDate")
	@Temporal(TemporalType.DATE)
	private Date joinDate = new Date();
	
	//roomId for reference
	private int roomId;

	@Column(name = "advance")
	private int advance;

	@Column(name = "montlyRent")
	private int montlyRent;

	@Column(name = "toBePaid", columnDefinition = "int default 0")
	private int toBePaid;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public int getAdvance() {
		return advance;
	}

	public void setAdvance(int advance) {
		this.advance = advance;
	}

	public int getMontlyRent() {
		return montlyRent;
	}

	public void setMontlyRent(int montlyRent) {
		this.montlyRent = montlyRent;
	}

	public int getToBePaid() {
		return toBePaid;
	}

	public void setToBePaid(int toBePaid) {
		this.toBePaid = toBePaid;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", joinDate=" + joinDate + ", roomId=" + roomId + ", advance="
				+ advance + ", montlyRent=" + montlyRent + ", toBePaid=" + toBePaid + "]";
	}

}
