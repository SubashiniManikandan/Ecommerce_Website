package org.hexaware.entity;

public class Customer {
     private int cust_id;
     private String name;
     private String email;
     private String pswd;
     
     public Customer(int cust_id, String name, String email, String pswd) {
		this.cust_id=cust_id;
		this.name=name;
		this.email=email;
		this.pswd=pswd;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getCust_id() {
    	 return cust_id; }
     public void setCust_id(int cust_id) {
    	 this.cust_id=cust_id;}
     
     public String getName() {
    	 return name;  }
     public void setName(String name) { 
    	 this.name = name; 
     }

     public String getEmail() { 
    	 return email;  }
     public void setEmail(String email) { 
    	 this.email = email; }

     public String getPassword() { 
    	 return pswd;  }
     public void setPassword(String pswd) {
    	 this.pswd = pswd; 
      }
     

}
