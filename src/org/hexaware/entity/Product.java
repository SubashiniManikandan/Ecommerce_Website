package org.hexaware.entity;

public class Product {
    private int prod_id;
    private String p_name;
    private double price;
    private String descp;
    private int stock;
    
    public Product(int prod_id, String p_name, double price, String descp, int stock) {
		this.prod_id=prod_id;
		this.p_name=p_name;
		this.price=price;
		this.descp=descp;
		this.stock=stock;
	}
	public Product(int p_id,String prod_name,double price2 ) {
	     this.prod_id=p_id;
	     this.p_name=prod_name;
	     this.price=price2;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getP_Id() { 
    	return prod_id;}
    public void setP_Id(int prod_id) {
    	this.prod_id=prod_id;}
    
    public String getName() { 
    	return p_name; }
    public void setName(String p_name) {
    	this.p_name = p_name; }

    public double getPrice() { 
    	return price; }
    public void setPrice(double price) {
    	this.price = price; }

    public String getDescription() { 
    	return descp; }
    public void setDescription(String descp) {
    	this.descp= descp; }

    public int getStock() { 
    	return stock; }
    public void setStock(int stock) { 
    	this.stock = stock; }
    

}
