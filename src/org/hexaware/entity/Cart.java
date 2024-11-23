package org.hexaware.entity;

public class Cart {

	    private int cartId;
	    private int customerId;
	    private int cartProductId;
	    private int quantity2;

	   
		public Cart(int customerId2, int cartProductId2, int quantity) {
			// TODO Auto-generated constructor stub
			this.customerId=customerId2;
			this.cartProductId=cartProductId2;
			this.quantity2=quantity;
		}
		public int getCartId() { 
	    	return cartId; }
	    public void setCartId(int cartId) {
	    	this.cartId = cartId; }

	    public int getCustomerId() {
	    	return customerId; }
	    public void setCustomerId(int customerId) {
	    	this.customerId = customerId; }

	    public int getProductId() {
	    	return cartProductId; }
	    public void setProductId(int productId) {
	    	this.cartProductId = productId; }

	    public int getQuantity() {
	    	return quantity2; }
	    public void setQuantity(int quantity2) { 
	    	this.quantity2 = quantity2; }
	}

