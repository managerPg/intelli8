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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="building")
@SequenceGenerator(name="sequence",initialValue=1001)
public class Building {

	@Id
	@Column(name = "buildingId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	private int buildingId;

	@Column(name = "buildingName")
	private String buildingName;

	@Column(name = "buildingAddress")
	private String buildingAdress;

	@Column(name = "buildingOwner")
	private String buildingOwner;

	//If referencedColumnName is not present we cannot query
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "buildingId", referencedColumnName="buildingId")
	private List<Floor> floors = new ArrayList<>();

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingAdress() {
		return buildingAdress;
	}

	public void setBuildingAdress(String buildingAdress) {
		this.buildingAdress = buildingAdress;
	}

	public String getBuildingOwner() {
		return buildingOwner;
	}

	public void setBuildingOwner(String buildingOwner) {
		this.buildingOwner = buildingOwner;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", buildingName=" + buildingName + ", buildingAdress="
				+ buildingAdress + ", buildingOwner=" + buildingOwner + ", floors=" + floors + "]";
	}

}
