package org.hexaware.main;
import org.hexaware.entity.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing1 extends Testing {

	 @Test
	    public void testProductCreatedSuccessfully() {
	        Product product = new Product();
	        product.setName("Earphones");
	        product.setPrice(15000.00);
	        product.setDescription("Gud Audio Quality");
	        product.setStock(50);

	        boolean isCreated = repository.createProduct(product);
	        assertTrue(isCreated, "Product should be created successfully.");
	    }
}
