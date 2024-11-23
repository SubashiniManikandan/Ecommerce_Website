package org.hexware.dao;

import org.hexaware.entity.Customer;
import org.hexaware.entity.Product;
import org.hexaware.entity.Cart;
import org.hexaware.entity.Order;
import java.sql.*;
import java.util.*;
import org.hexware.util.DBConnectUtil;

public class DAO_Imp implements DAO {
     private Connection conn;
     
     public DAO_Imp() {
    	 this.conn=DBConnectUtil.getDBConn();
     }
     
     @Override
     public boolean createCustomer(Customer customer) {
         try (PreparedStatement ps = conn.prepareStatement(
                 "INSERT INTO customers (c_id, name, email, password) VALUES (?, ?, ?, ?)")) {
        	 ps.setInt(1, customer.getCust_id());
             ps.setString(2, customer.getName());
             ps.setString(3, customer.getEmail());
             ps.setString(4, customer.getPassword());
             return ps.executeUpdate() > 0;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return false;
     }
     
     @Override
     public boolean createProduct(Product product) {
         try (PreparedStatement ps = conn.prepareStatement(
                 "INSERT INTO products (p_id, p_name, price, description, stock) VALUES (?, ?, ?, ?, ?)")) {
        	 ps.setInt(1, product.getP_Id());
             ps.setString(2, product.getName());
             ps.setDouble(3, product.getPrice());
             ps.setString(4, product.getDescription());
             ps.setInt(5, product.getStock());
             return ps.executeUpdate() > 0;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return false;
     }
     
     @Override
     public boolean deleteProduct(int productId) {
         try (PreparedStatement ps = conn.prepareStatement("DELETE FROM products WHERE p_id = ?")) {
             ps.setInt(1, productId);
             return ps.executeUpdate() > 0;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return false;
     }
     
     @Override
     public boolean addToCart(Cart cart) {
         try (PreparedStatement ps = conn.prepareStatement(
                 "INSERT INTO cart (c_id, p_id, quantity) VALUES (?, ?, ?)")) {
             ps.setInt(1, cart.getCustomerId());
             ps.setInt(2, cart.getProductId());
             ps.setInt(3, cart.getQuantity());
             return ps.executeUpdate() > 0;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return false;
     }
     
     @Override
     public boolean addToCart1(Product cart) {
         try (PreparedStatement ps = conn.prepareStatement(
                 "INSERT INTO cart (i auto_increment unique, p_id, quantity) VALUES (?, ?, ?)")) {
             ps.setInt(2, cart.getP_Id());
             ps.setInt(3, cart.getStock());
             return ps.executeUpdate() > 0;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return false;
     }
     
     @Override
     public List<Product> viewCart(int customerId) {
         List<Product> products = new ArrayList<>();
         try (PreparedStatement ps = conn.prepareStatement(
                 "SELECT p.p_id, p.p_name, p.price FROM products p JOIN cart c ON p.p_id = c.p_id WHERE c.c_id = ?")) {
             ps.setInt(1, customerId);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 Product product = new Product(customerId, null, customerId);
                 product.setP_Id(rs.getInt("p_id"));
                 product.setName(rs.getString("p_name"));
                 product.setPrice(rs.getDouble("price"));
                 products.add(product);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return products;
     }
     
     @Override
     public boolean placeOrder(int customerId, String shippingAddress) {
         try (PreparedStatement ps = conn.prepareStatement(
                 "INSERT INTO orders (c_id, order_date, tot_price, address) VALUES (?, CURRENT_DATE, 0, ?)",
                 Statement.RETURN_GENERATED_KEYS)) {
             ps.setInt(1, customerId);
             ps.setString(2, shippingAddress);
             ps.executeUpdate();
             return true;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return false;
     }
     
     @Override
     public List<Order> viewCustomerOrders(int customerId) {
         List<Order> orders = new ArrayList<>();
         try (PreparedStatement ps = conn.prepareStatement(
                 "SELECT * FROM orders WHERE c_id = ?")) {
             ps.setInt(1, customerId);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 Order order = new Order();
                 order.setOrderId(rs.getInt("o_id"));
                 order.setTotalPrice(rs.getDouble("tot_price"));
                 orders.add(order);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return orders;
     }
     
     
}
     
    