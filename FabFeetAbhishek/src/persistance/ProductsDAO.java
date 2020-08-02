package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employees;
import model.Products;

public class ProductsDAO{
	public static void displayAll(){
        Connection con;
        con = ConnectToDB.getConnection();
		String sql=" select * from products ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs.next()==false)   
				System.out.println("No products exist");
			else {
					Products prod;
//					int productId;
//					String productName;
				do 
				{
					prod= new Products();
					prod.setProductId(rs.getInt("productId"));
					prod.setProductName(rs.getString("productName"));
					prod.display();
					
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("Error in EMPDAO while  displayAll");
			e.printStackTrace();
		}

        ConnectToDB.closeConnection(con);     
    }
	
	
}