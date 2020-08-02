package persistance;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Branches;
import model.Customers;
import model.Products;


public class CustomerDAO{
    // TODO check and verify 
    public static void insertIntoCustomersTable(Customers cust){
        
        Connection con = ConnectToDB.getConnection();   
        String sql = "insert into customers (CustomerName, phone, address) values (?, ?, ?)";
        
        try {
			PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cust.getCustomerName());
            ps.setString(2, cust.getPhoneNo());
            ps.setString(3, cust.getAddress());

			int row=ps.executeUpdate();
            
			if(row>0)
				System.out.println("Data inserted sucessfully");
			else
			{
				System.out.println("Insertion Failed");
			}
				
		} catch (SQLException e) {
			System.out.println("Error in CustomerDAO while  inserting");
			e.printStackTrace();
		}

        ConnectToDB.closeConnection(con);     
    }
    
    public static boolean customerExists(int Cid){
    	 Connection con = ConnectToDB.getConnection();   
         String sql = "select * from customers where customerID = ?";
         boolean flag = false;
         try {
 			PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, Cid);
             

 			ResultSet rs=ps.executeQuery();
             
 			if(rs.next() != false)
 				flag= true;
 			
 				
 		} catch (SQLException e) {
 			System.out.println("Error in CustomerDAO while  inserting");
// 			e.printStackTrace();
 		}

         ConnectToDB.closeConnection(con);   
         return flag;
    	
    }
    
    public static void displayAll(){
        Connection con;
        con = ConnectToDB.getConnection();
		String sql=" select * from customers ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs.next()==false)   
				System.out.println("No customers exist");
			else {
					Customers cust;
//					int productId;
//					String productName;
				do 
				{
					cust= new Customers();
					cust.setCustomerId(rs.getInt("CustomerID"));
					cust.setCustomerName(rs.getString("CustomerName"));
					cust.setPhoneNo(rs.getString("phone"));
					cust.setAddress(rs.getString("address"));
					cust.display();
					
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("Error in EMPDAO while  displayAll");
			e.printStackTrace();
		}

        ConnectToDB.closeConnection(con);     
    }
	
    
   

    
   
    
}