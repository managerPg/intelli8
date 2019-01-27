package com.intelli8.DAO;

/*
* @author G V Kushal 
*/
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intelli8.POJO.Vacancy;

@Repository
public class RoomDAOImpl implements RoomDAO {

	@Autowired
	EntityManager entityManager;

	@Override
	public List getVacancyDAO(String buildingName) {
		Session curSession = entityManager.unwrap(Session.class);
		Query query = curSession.createQuery(
				"select b.buildingName, f.floor, r.roomNumber, r.vacancies from Building b, Floor f, Room r where b.buildingName="
						+ "'" + buildingName + "'"
						+ " and b.buildingId=f.buildingId and f.floorId=r.floorId and r.vacancies>0");
		List<Object[]> vacancyList = (List<Object[]>) query.getResultList();
		List<Vacancy> vacancy= new ArrayList<Vacancy>();
		for (Object[] vac : vacancyList) {
			Vacancy vacancyObj = new Vacancy();
			vacancyObj.setBuildingName((String) vac[0]);
			vacancyObj.setFloor((String) vac[1]);
			vacancyObj.setRoomNumber((int) vac[2]);
			vacancyObj.setVacancies((int) vac[3]);
			vacancy.add(vacancyObj);
		}
		return vacancy;
	}

	@Override
	public List getFloorVacancyDAO(String buildingName, String floorId) {
		Session curSession = entityManager.unwrap(Session.class);
		Query query = curSession.createQuery(
				"select b.buildingName, f.floor, r.roomNumber, r.vacancies from Building b, Floor f, Room r where b.buildingName="
						+ "'" + buildingName + "'"
						+ " and b.buildingId=f.buildingId and f.floor="+"'"+floorId+"'"+" and f.floorId=r.floorId and r.vacancies>0");
		List<Object[]> vacancyList = (List<Object[]>) query.getResultList();
		List<Vacancy> vacancy= new ArrayList<Vacancy>();
		for (Object[] vac : vacancyList) {
			Vacancy vacancyObj = new Vacancy();
			vacancyObj.setBuildingName((String) vac[0]);
			vacancyObj.setFloor((String) vac[1]);
			vacancyObj.setRoomNumber((int) vac[2]);
			vacancyObj.setVacancies((int) vac[3]);
			vacancy.add(vacancyObj);
		}
		return vacancy;
	}

}
