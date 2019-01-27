package com.intelli8.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelli8.POJO.Building;
import com.intelli8.service.BuildingService;

@RestController
public class BuildingResource {

	@Autowired
	BuildingService service;

	private static final Logger logger = LoggerFactory.getLogger(BuildingResource.class);

	// Gives building Info
	@GetMapping("/buildings/{buildingName}")
	public Building getBuildingInfo(@PathVariable String buildingName) {
		logger.info("Started Getting " + buildingName + " Information");
		return service.getbuildingService(buildingName);
	}

	// Adds new Building Information
	@PostMapping("/buildings")
	public Building addBuildingInfo(@RequestBody Building building) {
		logger.info("Started Adding new building.");
		return service.addBuilding(building);
	}

	// Deletes Building Info (Cascading Not Working
	@DeleteMapping("/buildings/{buildingName}")
	public String removeBuilding(@PathVariable String buildingName) {
		logger.info("Started Deleting " + buildingName + " Info");
		return service.removeBuildingService(buildingName);
	}

}
