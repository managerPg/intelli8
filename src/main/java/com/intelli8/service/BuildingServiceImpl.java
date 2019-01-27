package com.intelli8.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelli8.DAO.BuildingDAO;
import com.intelli8.POJO.Building;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	BuildingDAO repoDAO;
	
	@Override
	@Transactional
	public Building addBuilding(Building building) {
		return repoDAO.addBuildingDAO(building);
	}

	@Override
	@Transactional
	public Building getbuildingService(String buildingName) {
		return repoDAO.getBuildingDAO(buildingName);
	}

	@Override
	@Transactional
	public String removeBuildingService(String buildingName) {
		return repoDAO.removeBuildingDAO(buildingName);
	}

}
