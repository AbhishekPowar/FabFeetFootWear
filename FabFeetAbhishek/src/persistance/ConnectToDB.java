package persistance;
import java.sql.*;

public class ConnectToDB{
    
	public static Connection getConnection(){
		
		Connection connect=null;
		
		try {
			connect=DriverManager.getConnection("jdbc:sqlite:FabFeet.db");
			connect.createStatement().execute("PRAGMA foreign_keys = ON");

//			connect=DriverManager.getConnection("jdbc:sqlite:new.db");
			
			if(connect!=null) {
				System.out.println("Connected to database");
				connect.setAutoCommit(true);
			}
			else
				System.out.println("Connection failed");
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connect;
    	
        
    }
	
	public static void closeConnection(Connection c)
	{
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
//    public static void main(){
//    	getConnection();
//
//    }
}