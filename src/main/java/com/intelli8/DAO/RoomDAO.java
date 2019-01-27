package com.intelli8.DAO;

import java.util.List;

public interface RoomDAO {
	
	public List getVacancyDAO(String buildingName);
	public List getFloorVacancyDAO(String buildingName, String floorId);
	

}
