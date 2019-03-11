package com.intelli8.DAO;

/*
* @author G V Kushal 
*/
import java.util.List;

public interface RoomDAO {
	
	public List getVacancyDAO(String buildingName);
	public List getFloorVacancyDAO(String buildingName, String floorId);
	

}
