package com.intelli8.Resource;


/*
* @author G V Kushal 
*/

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.intelli8.POJO.Customer;
import com.intelli8.error.UserNotFoundException;
import com.intelli8.service.CustomerService;

@RestController
public class CustomerResource {

	@Autowired
	CustomerService service;

	private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);

	// Gives All the Customers in All buildings.
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		logger.info("Started Getting All the Customer Detials");
		return service.getAllCustomerService();
	}

	// Gives All the Customers in a Building.
	@GetMapping("/buildings/{buildingName}/customers")
	public List<Customer> getAllCustomers(@PathVariable String buildingName) {
		logger.info("Started Getting All Customer Details in a Building " + buildingName);
		return service.getAllCustomerService(buildingName);
	}

	// Gives All Customer Names who all unpaid in a building.
	@GetMapping("/buildings/{buildingName}/customers/unpaid")
	public List<Customer> getUnpaidCustomers() {
		logger.info("Started Getting all the customers who have not paid the rent");
		return service.getUnpaidCustomerService();
	}

	// Adds the customer into building room.
	@PostMapping("/buildings/{buildingName}/floors/{floor}/rooms/{roomNumber}")
	public Customer addCustomer(@PathVariable String buildingName, @PathVariable String floor,
			@PathVariable int roomNumber, @RequestBody Customer customer) {
		logger.info("Started Adding new customer to room " + roomNumber + " in building " + buildingName);
		return service.addCustomerService(buildingName, floor, roomNumber, customer);
	}

	// Updates the customer payment if the Rent is paid.
	@PutMapping("/customers/payment/{firstName}")
	public String updatePayment(@PathVariable("firstName") String customerName) {
		logger.info("Started Updating " + customerName + " rent payment detials");
		return service.updatePaymentService(customerName);
	}

	// Deletes the customer Data.
	@DeleteMapping("/customers/{customerId}")
	public String removeCustomer(@PathVariable int customerId) {
		logger.info("Started Deleting " + customerId + " from user list");
		if (customerId <= 0) {
			logger.info("Bad Request...User Id entered is not correct");
			throw new UserNotFoundException("Customer Not Found");
		}
		return service.customerVacateService(customerId);
	}

}
