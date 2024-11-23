package org.hexaware.main;

import org.hexaware.entity.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Testing3 extends Testing {

    @Test
    public void testProductAddedToCart() {
        // Arrange: Create a product and initialize the cart
        Product product = new Product();
        product.setP_Id(101);
        product.setStock(50);

        // Act: Add the product to the cart
        boolean isAdded = repository.addToCart1(product); 

        // Assert: Verify the product is added successfully
        assertTrue(isAdded, "Product should be added to the cart successfully.");


    }
}

