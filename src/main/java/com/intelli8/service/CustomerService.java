package com.intelli8.service;

import java.util.List;

import com.intelli8.POJO.Customer;

public interface CustomerService {

	public List<Customer> getUnpaidCustomerService();

	public List<Customer> getAllCustomerService();

	public List<Customer> getAllCustomerService(String buildingName);

	public String customerVacateService(int customerId);

	public String updatePaymentService(String customerName);

	public Customer addCustomerService(String buildingName, String floor, int roomNumber, Customer customer);

}
