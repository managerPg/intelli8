package com.intelli8.service;

import java.util.List;

public interface RoomService {

	public List getRoomVacancy(String buildingName);
	public List getFloorVacancy(String buildingName, String floorId);
}
