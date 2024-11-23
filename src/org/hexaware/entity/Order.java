package org.hexaware.entity;
import java.util.*;

public class Order {
	    private int orderId;
	    private int customerId;
	    private Date orderDate;
	    private double totalPrice;
	    private String shippingAddress;

	    // Getters and Setters
	    public int getOrderId() {
	    	return orderId; }
	    public void setOrderId(int orderId) { 
	    	this.orderId = orderId; }

	    public int getCustomerId() { 
	    	return customerId; }
	    public void setCustomerId(int customerId) { 
	    	this.customerId = customerId; }

	    public Date getOrderDate() {
	    	return orderDate; }
	    public void setOrderDate(Date orderDate) { 
	    	this.orderDate = orderDate; }

	    public double getTotalPrice() { 
	    	return totalPrice; }
	    public void setTotalPrice(double totalPrice) { 
	    	this.totalPrice = totalPrice; }

	    public String getShippingAddress() { 
	    	return shippingAddress; }
	    public void setShippingAddress(String shippingAddress) { 
	    	this.shippingAddress = shippingAddress; }
	}


