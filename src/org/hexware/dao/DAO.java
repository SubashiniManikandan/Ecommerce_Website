package org.hexware.dao;
import org.hexaware.entity.*;
import java.util.*;

public interface DAO {
	boolean createCustomer(Customer customer);
    boolean createProduct(Product product);
    boolean deleteProduct(int productId);
    boolean addToCart(Cart cart);
    List<Product> viewCart(int customerId);
    boolean placeOrder(int customerId, String shippingAddress);
    List<Order> viewCustomerOrders(int customerId);
//	boolean addToCart(Customer invalidCustomer, Product invalidProduct, int i);
	boolean addToCart1(Product product);


}
