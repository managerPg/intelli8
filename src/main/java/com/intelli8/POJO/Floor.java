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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="floor")
public class Floor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "floorId")
	@JsonIgnore
	private int floorId;

	@Column(name = "floor")
	private String floor;
	
	//referencedColumn
	private int buildingId;

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "floorId", referencedColumnName="floorId")
	private List<Room> rooms = new ArrayList<>();;

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Floor [floorId=" + floorId + ", floor=" + floor + ", rooms=" + rooms + "]";
	}

	

}
