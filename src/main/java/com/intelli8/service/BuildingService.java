package com.intelli8.service;

import com.intelli8.POJO.Building;

public interface BuildingService {
	
	public Building getbuildingService(String buildingName);
	public Building addBuilding(Building building);
	public String removeBuildingService(String buildingName);
}
