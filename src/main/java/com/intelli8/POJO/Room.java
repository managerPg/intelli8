package com.intelli8.POJO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="room")
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private int roomId;
	
	@Column(name="roomNumber")
	private int roomNumber;
	
	@Column(name="roomCapacity")
	private int roomCapacity;
	
	@Column(name="vacancies")
	private int vacancies;
	
	// referenced Column
	private int floorId;
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="roomId", referencedColumnName="roomId")
	@JsonIgnore
	private List<Customer> customers = new ArrayList<>();
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "Room [Id=" + roomId + ", roomNumber=" + roomNumber + ", roomCapacity=" + roomCapacity + ", vacancies="
				+ vacancies + "]";
	}
	
}
