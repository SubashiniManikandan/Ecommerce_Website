package org.hexaware.main;
import org.hexaware.entity.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class Testing2 extends Testing {

	 @Test
	    public void testCustomerCreatedSuccessfully() {
	        Customer customer=new Customer();
	        customer.setName("Suba");
	        customer.setEmail("Suba@123");
	        customer.setPassword("S123");

	        boolean isCreatedCustomer = repository.createCustomer(customer);
	        assertTrue(isCreatedCustomer, "Customer should be created successfully.");
	    }
}


