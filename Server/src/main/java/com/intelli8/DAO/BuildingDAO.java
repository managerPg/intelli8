package com.intelli8.DAO;

/*
* @author G V Kushal 
*/
import com.intelli8.POJO.Building;

public interface BuildingDAO {
	public Building getBuildingDAO(String buildingName);

	public Building addBuildingDAO(Building building);

	public String removeBuildingDAO(String buildingName);
}
