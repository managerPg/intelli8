package com.intelli8.DAO;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intelli8.POJO.Customer;
import com.intelli8.error.NoVacancyException;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
	
	@Autowired
	EntityManager entityManager;


	@Override
	public Customer insertCustomer(String buildingName, String floor, int roomNumber, Customer customer) {
		Session curSession = entityManager.unwrap(Session.class);
		// Query to check Vacancies in room.
		Query q1 = curSession.createQuery("select r.vacancies from Building b, Floor f, Room r where b.buildingName="
				+ "'" + buildingName + "'" + "and b.buildingId=f.buildingId and f.floorId=r.floorId and r.roomNumber="
				+ "'" + roomNumber + "'");
		// Query to update vacancies after successful insertion of new person.
		Query q2 = curSession.createQuery("update Room set vacancies = vacancies-1 where roomNumber=" + "'" + roomNumber
				+ "'" + "and floorId in (select f.floorId from Building b, Floor f where b.buildingName=" + "'"
				+ buildingName + "'" + " and b.buildingId=f.buildingId)");
		// Query to update the floorId in customer table.
		Query q3 = curSession.createQuery(
				"update Customer set roomId = (select r.roomId from Building b, Floor f, Room r where b.buildingName="
						+ "'" + buildingName + "'"
						+ " and b.buildingId=f.buildingId and f.floorId=r.floorId and r.roomNumber=" + "'" + roomNumber
						+ "'" + ")where firstName=:fName");
		q3.setParameter("fName", customer.getFirstName());
		int vacancies = (int) q1.getSingleResult();
		if (vacancies <= 0) {
			throw new NoVacancyException("Sorry..Room you are searching is full..!!");
		}
		try{
		curSession.save(customer);
		q2.executeUpdate();
		q3.executeUpdate();
		}catch (HibernateException exc) {
			logger.error("Exception raised in exeuting HQL queries");
			throw new HibernateException("Error Occured on server side..please contact you administrator.");
		}
		return customer;
	}

	@Override
	public List<Customer> getUnpaidCustomerDAO() {
		Session curSession = entityManager.unwrap(Session.class);
		Query query = curSession.createQuery("from Customer where toBePaid>0");
		return (List<Customer>) query.getResultList();
	}

	@Override
	public List<Customer> getAllCustomerDAO() {
		Session curSession = entityManager.unwrap(Session.class);
		Query query = curSession.createQuery("from Customer");
		return (List<Customer>) query.getResultList();
	}

	@Override
	public String customerVacateDAO(int customerId) {
		Session curSession = entityManager.unwrap(Session.class);
		// Query to update vacancies after successful vacation of person
		Query query1 = curSession.createQuery(
				"update Room set vacancies = vacancies+1 where roomId = (select roomId from Customer where customerId="
						+ "'" + customerId + "'" + ")");
		// Query to delete the user
		Query query2 = curSession.createQuery("delete from Customer where customerId=" + "'" + customerId + "'");
		query1.executeUpdate();
		/*
		 * Vacancy should not be greater than roomCapacity
		 */
		int status = query2.executeUpdate();
		if (status > 0)
			return "Customer: " + customerId + "  is deleted successfully..!!";
		else
			return "Sorry something went worng"; // throw exception
	}

	@Override
	public String updatePaymentDAO(String customerName) {
		Session curSession = entityManager.unwrap(Session.class);
		Query query = curSession.createQuery("update Customer set toBePaid=0 where firstName=:fName");
		query.setParameter("fName", customerName);
		int status = query.executeUpdate();
		if (status > 0)
			return customerName + " payment Successful..!!";
		else
			return "Sorry something went worng"; // throw exception
	}

	@Override
	public List<Customer> getAllCustomerDAO(String buildingName) {
		Session curSession = entityManager.unwrap(Session.class);
		Query query = curSession.createQuery(
				"select c.firstName, c.lastName, c.phoneNumber, c.joinDate, c.montlyRent from Building b, Floor f, Room r, Customer c where b.buildingName="
						+ "'" + buildingName + "'"
						+ " and b.buildingId=f.buildingId and f.floorId=r.floorId and r.roomId=c.roomId");
		List<Object[]> customersList = (List<Object[]>) query.getResultList();
		List<Customer> customerJSON = new ArrayList<>();
		for (Object[] customer : customersList) {
			Customer customerObj = new Customer();
			customerObj.setFirstName((String) customer[0]);
			customerObj.setLastName((String) customer[1]);
			customerObj.setPhoneNumber((BigInteger) customer[2]);
			customerObj.setJoinDate((Date) customer[3]);
			customerObj.setMontlyRent((int) customer[4]);
			customerJSON.add(customerObj);
		}
		return customerJSON;
	}

}
