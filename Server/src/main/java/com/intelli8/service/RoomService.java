package com.intelli8.service;


/*
* @author G V Kushal 
*/

import java.util.List;

public interface RoomService {

	public List getRoomVacancy(String buildingName);
	public List getFloorVacancy(String buildingName, String floorId);
}
