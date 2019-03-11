package com.intelli8.service;


/*
* @author G V Kushal 
*/

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intelli8.DAO.RoomDAO;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDAO roomDAO;
	
	@Override
	@Transactional
	public List getRoomVacancy(String buildingName) {
		return roomDAO.getVacancyDAO(buildingName);
	}

	@Override
	public List getFloorVacancy(String buildingName, String floorId) {
		// TODO Auto-generated method stub
		return roomDAO.getFloorVacancyDAO(buildingName, floorId);
	}

}
