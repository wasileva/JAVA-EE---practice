
package com.customer.ee9.service;

import com.customer.ee9.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class CustomerService {
    
    @Resource(lookup = "jdbc/mysql")
    private DataSource ds;
  
    public Customer getCustomer(long id){
        String sql = "select * from customer where id = ?";
        
        try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setLong(1, id);
            
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Customer(id, rs.getString(2), rs.getString(3));
                }     
            }           
        } catch (SQLException ex){      
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Customer> getAllCustomer(){
        String sql = "select * from customer";
        List<Customer> allCustomers = new ArrayList<>();
        try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    allCustomers.add(new Customer(rs.getLong(1),rs.getString(2), rs.getString(3)));
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return allCustomers;
    }
    
    public void createCustomer(Customer c){
        String sql = "insert into customer (id, name, phone) VALUES(?,?,?)"; 
        try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
           ps.setLong(1, c.getId());
           ps.setString(2, c.getCustomerName());
           ps.setString(3, c.getCustomerPhone());       
           ps.execute();      
        } catch(SQLException ex){   
            ex.printStackTrace();
        }
    }
}
