package com.intelli8.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intelli8.POJO.Building;

@Repository
public class BuildingDAOImpl implements BuildingDAO {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Building addBuildingDAO(Building building) {
	Session session = entityManager.unwrap(Session.class);
	session.save(building);
	return building;
	}

	@Override
	public Building getBuildingDAO(String buildingName) {
		Session curSession = entityManager.unwrap(Session.class);
		Query q = curSession.createQuery("from Building where buildingName =:bName");
		q.setParameter("bName",buildingName);
		//throw exception if we wont get any result from query (i.e No Building Found)
		return (Building) q.getSingleResult();
	}

	@Override
	public String removeBuildingDAO(String buildingName) {
		Session curSession = entityManager.unwrap(Session.class);
		Query q = curSession.createQuery("delete from Building where buildingName =:bName");
		q.setParameter("bName",buildingName);
		int status = q.executeUpdate();
		/*
		 * Cascade not working
		 * 
		 */
		/*Query q = curSession.createQuery("from Building where buildingName =:bName");
		q.setParameter("bName",buildingName);
		curSession.delete(q.getSingleResult());*/
		return (status>0) ? "Building"+buildingName+" deleted successfully...!!!" : "Sorry building not deleted";
	}

}
