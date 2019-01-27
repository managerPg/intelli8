package com.intelli8.DAO;

/*
* @author G V Kushal 
*/
import java.util.List;

import com.intelli8.POJO.Customer;

public interface CustomerDAO {

	public List<Customer> getUnpaidCustomerDAO();

	public List<Customer> getAllCustomerDAO();

	public String customerVacateDAO(int customerId);

	public String updatePaymentDAO(String customerName);

	public List<Customer> getAllCustomerDAO(String buildingName);

	public Customer insertCustomer(String buildingName, String floor, int roomNumber, Customer customer);

}
