
package org.hexaware.main;
import org.hexware.dao.*;
import org.hexaware.entity.*;
import java.util.*;

public class Ecommerce {

	public static void main(String[] args) {
		   DAO obj=new DAO_Imp();
           Scanner sc=new Scanner(System.in);
           
           String res=null;
           
           do {
        	   System.out.println("\nE-commerce Application....!!!");
               System.out.println("1. Register Customer");
               System.out.println("2. Create Product");
               System.out.println("3. Delete Product");
               System.out.println("4. Add to Cart");
               System.out.println("5. View Cart");
               System.out.println("6. Place Order");
               System.out.println("7. View Customer Orders");
               System.out.println("8. Exit");
               System.out.print("Enter your choice: ");

               int choice = sc.nextInt();
               sc.nextLine(); // newline

               switch (choice) {
                   case 1:
                	   System.out.print("Enter Customer_Id: ");
                	   int c_id=sc.nextInt();
                	   sc.nextLine();
                       System.out.print("Enter name: ");
                       String name = sc.nextLine();
                       System.out.print("Enter email: ");
                       String email = sc.nextLine();
                       System.out.print("Enter password: ");
                       String password = sc.nextLine();

                       Customer customer = new Customer(c_id, name, email, password);
                       if (obj.createCustomer(customer)) {
                           System.out.println("Customer registered successfully!");
                       } else {
                           System.out.println("Error registering customer.");
                       }
                       break;

                   case 2:
                	   System.out.print("Enter Product_Id: ");
                	   int prodId=sc.nextInt();
                	   sc.nextLine();
                       System.out.print("Enter product name: ");
                       String productName = sc.nextLine();
                       System.out.print("Enter price: ");
                       double price = sc.nextDouble();
                       sc.nextLine(); 
                       System.out.print("Enter description: ");
                       String description = sc.nextLine();
                       System.out.print("Enter stock quantity: ");
                       int stockQuantity = sc.nextInt();

                       Product product = new Product(prodId, productName, price, description, stockQuantity);
                       if (obj.createProduct(product)) {
                           System.out.println("Product created successfully!");
                       } else {
                           System.out.println("Error creating product.");
                       }
                       break;

                   case 3:
                       System.out.print("Enter product ID to delete: ");
                       int productId = sc.nextInt();

                       if (obj.deleteProduct(productId)) {
                           System.out.println("Product deleted successfully!");
                       } else {
                           System.out.println("Error deleting product or product not found.");
                       }
                       break;

                   case 4:
                       System.out.print("Enter customer ID: ");
                       int customerId = sc.nextInt();
                       System.out.print("Enter product ID: ");
                       int cartProductId = sc.nextInt();
                       System.out.print("Enter quantity: ");
                       int quantity = sc.nextInt();

                       Cart cart = new Cart(customerId, cartProductId, quantity);
                       if (obj.addToCart(cart)) {
                           System.out.println("Product added to cart successfully!");
                       } else {
                           System.out.println("Error adding product to cart.");
                       }
                       break;

                   case 5:
                       System.out.print("Enter customer ID to view cart: ");
                       int viewCartCustomerId = sc.nextInt();

                       List<Product> cartProducts = obj.viewCart(viewCartCustomerId);
                       if (cartProducts.isEmpty()) {
                           System.out.println("Cart is empty or customer ID not found.");
                       } else {
                           System.out.println("Products in cart:");
                           for (Product p : cartProducts) {
                               System.out.println("ID: " + p.getP_Id() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
                           }
                       }
                       break;

                   case 6:
                       System.out.print("Enter customer ID to place order: ");
                       int orderCustomerId = sc.nextInt();
                       sc.nextLine();//newline
                       System.out.print("Enter shipping address: ");
                       String shippingAddress = sc.nextLine();

                       if (obj.placeOrder(orderCustomerId, shippingAddress)) {
                           System.out.println("Order placed successfully!");
                       } else {
                           System.out.println("Error placing order.");
                       }
                       break;

                   case 7:
                       System.out.print("Enter customer ID to view orders: ");
                       int ordersCustomerId = sc.nextInt();

                       List<Order> orders = obj.viewCustomerOrders(ordersCustomerId);
                       if (orders.isEmpty()) {
                           System.out.println("No orders found for this customer.");
                       } else {
                           System.out.println("Customer Orders:");
                           for (Order order : orders) {
                               System.out.println("Order ID: " + order.getOrderId() + ", Total Price: " + order.getTotalPrice());
                           }
                       }
                       break;

                   case 8:
                       System.out.println("Exiting...");
                       System.exit(0);

                   default:
                       System.out.println("Invalid choice!");
               }
       
             System.out.println("Grab your next Order by clicking OK..");
             res=sc.next();
         }while(res.equalsIgnoreCase("OK"));
           sc.close();
	}   

}
