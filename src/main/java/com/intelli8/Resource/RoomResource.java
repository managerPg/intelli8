package com.intelli8.Resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intelli8.service.RoomService;

@RestController
public class RoomResource {

	@Autowired
	RoomService service;
	private static final Logger logger = LoggerFactory.getLogger(RoomResource.class);

	// Gives Vacancies in whole building
	@GetMapping("/buildings/{buildingName}/rooms")
	public List<Object> getRoomVacancies(@PathVariable String buildingName) {
		logger.info("Started getting all the vacancies in - " + buildingName);
		return service.getRoomVacancy(buildingName);
	}

	// Get Vacancies in One building with specic floor
	@GetMapping("/buildings/{buildingName}/floor/{floorName}")
	private List getFloorVacancies(@PathVariable String buildingName, @PathVariable String floorName) {
		logger.info("Starting getting room vacancies in " + buildingName + " from " + floorName);
		return service.getFloorVacancy(buildingName, floorName);
	}

}
