package com.intelli8.service;

/*
* @author G V Kushal 
*/
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intelli8.DAO.CustomerDAO;
import com.intelli8.POJO.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	@Transactional
	public Customer addCustomerService(String buildingName, String floor, int roomNumber, Customer customer) {
		return customerDAO.insertCustomer(buildingName, floor, roomNumber, customer);
	}

	@Override
	public List<Customer> getUnpaidCustomerService() {
		return customerDAO.getUnpaidCustomerDAO();
	}

	@Override
	public List<Customer> getAllCustomerService() {
		return customerDAO.getAllCustomerDAO();
	}

	@Override
	@Transactional
	public String customerVacateService(int customerId) {
		return customerDAO.customerVacateDAO(customerId);
	}

	@Override
	@Transactional
	public String updatePaymentService(String customerName) {
		return customerDAO.updatePaymentDAO(customerName);
	}

	@Override
	public List<Customer> getAllCustomerService(String buildingName) {
		return customerDAO.getAllCustomerDAO(buildingName);
	}

}
