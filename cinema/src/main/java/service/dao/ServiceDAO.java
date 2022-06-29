package service.dao;

import java.sql.*;
import java.util.*;
import service.db.ConnectionManager;
import service.model.Customer;
import java.sql.Date;

public class ServiceDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int id,quantity;
	private String name,email,phoneNumber,title,category;
	private double price;
	private Date date;

		public void addCustomer(Customer cust) {
		
		name = cust.getName();
		email = cust.getEmail();
		phoneNumber = cust.getPhoneNumber();
		title = cust.getTitle();
		quantity = cust.getQuantity();
		price = cust.getPrice();
		date = (Date) cust.getDate();
		category = cust.getCategory();
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("INSERT INTO customer (name,email,phoneNumber,title,quantity,price,date,category) values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getEmail());
			ps.setString(3, cust.getPhoneNumber());
			ps.setString(4, cust.getTitle());
			ps.setInt(5, cust.getQuantity());
			ps.setDouble(6, cust.getPrice());
			ps.setDate(7,(Date) cust.getDate());
			ps.setString(8, cust.getCategory());
			
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			con.close();
		}catch (Exception e) {
	          e.printStackTrace();
	    }
	}	
	public static List<Customer> getAllCustomer(){
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
			String sql = "SELECT * FROM customer ORDER BY id";
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				Customer s = new Customer();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setPhoneNumber(rs.getString("phoneNumber"));
				s.setTitle(rs.getString("title"));
				s.setQuantity(rs.getInt("quantity"));
				s.setPrice(rs.getDouble("price"));
				s.setDate(rs.getDate("date"));
				s.setCategory(rs.getString("category"));
				customers.add(s);
			}
			con.close();
		}catch (Exception e) {
	          e.printStackTrace();
	    }
		
		return customers;
	}
	
	public static Customer getCustomerById(int id) {
		Customer s = new Customer();
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("SELECT * FROM customer WHERE id=?");
			ps.setInt(1,id);
			
			rs = ps.executeQuery();
						
			if(rs.next()) {
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setPhoneNumber(rs.getString("phoneNumber"));
				s.setTitle(rs.getString("title"));
				s.setQuantity(rs.getInt("quantity"));
				s.setPrice(rs.getDouble("price"));
				s.setDate(rs.getDate("date"));
				s.setCategory(rs.getString("category"));

			}
			
			con.close();
			
		}catch (Exception e) {
	          e.printStackTrace();
	    }
		
		return s;
	}
	
	public void deleteCustomer(int id) {
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("DELETE FROM customer WHERE id=?");
			ps.setInt(1, id);			
			ps.executeUpdate();
			
			con.close();
			
		}catch (Exception e) {
	          e.printStackTrace();
	    }
	}
	
	public void updateCustomer(Customer cust) {
		
		id = cust.getId();
		name = cust.getName();
		email = cust.getEmail();
		phoneNumber = cust.getPhoneNumber();
		title = cust.getTitle();
		quantity = cust.getQuantity();
		price = cust.getPrice();
		date =  (Date) cust.getDate();
		category = cust.getCategory();

		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("UPDATE customer SET name=?, email=?, phoneNumber=?, title=? ,quantity=?, price=?, date=? , category=?  WHERE id=?");
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,phoneNumber);
			ps.setString(4,title);
			ps.setInt(5,quantity);
			ps.setDouble(6,price);
			ps.setDate(7,date);
			ps.setString(8,category);
			ps.setInt(9,id);
					
			ps.executeUpdate();
			
			System.out.println("Successfully updated");
			
			con.close();
			
		}catch (Exception e) {
	          e.printStackTrace();
	    }
	}
}
