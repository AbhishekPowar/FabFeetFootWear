package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Inventory;

public class InventoryDAO {
	
	static Scanner scan= new Scanner(System.in);
	public static void displayAllStock()
	{
		Connection con= ConnectToDB.getConnection();
		String sql ="select * from inventory ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()==false)
				System.out.println(" no products in the inventory");
			else
			{
				do {
						Inventory item = new Inventory();
						item.setProductId(rs.getInt("productId"));
						item.setBranchId(rs.getInt("branchId"));
						item.setSize(rs.getInt("sizes"));
						item.setPrice(rs.getDouble("price"));
						item.setQuantity(rs.getInt("quantity"));
						item.display();
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("products cant be displayed in the inventoryDAO");
			e.printStackTrace();
		}
		ConnectToDB.closeConnection(con);
	}
	
	public static void displayStockById(int bid)
	{
		Connection con=ConnectToDB.getConnection();
		String sql="select * from inventory where branchid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()==false)
				System.out.println(" no products in the inventory of your branch");
			else
			{
				do {
						Inventory item = new Inventory();
						item.setProductId(rs.getInt("productId"));
						item.setBranchId(bid);
						item.setSize(rs.getInt("sizes"));
						item.setPrice(rs.getDouble("price"));
						item.setQuantity(rs.getInt("quantity"));
						item.display();
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("products cant be displayed in the inventoryDAO");
			e.printStackTrace();
		}
		ConnectToDB.closeConnection(con);
	}
	
	//works
	public static void insertIntoInventory(int bid)
	{
		Connection con=ConnectToDB.getConnection();
		
		String sql="insert into inventory values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("enter the product id");
			ps.setInt(1, scan.nextInt());
			
//			System.out.println("enter the branch id");
//			ps.setInt(2, scan.nextInt());
			ps.setInt(2, bid);
			
			System.out.println("enter the size");
			ps.setInt(3, scan.nextInt());
			
			System.out.println("enter the quantity");
			ps.setInt(4, scan.nextInt());
			
			System.out.println("enter the price");
			ps.setDouble(5,scan.nextDouble() );
			ps.executeUpdate();
			System.out.println("Sucessfully inserted into Inventory");
		} catch (SQLException e) {
		
			System.out.println("product does not exist");
		}
		ConnectToDB.closeConnection(con);
		
	}
	
	//works
	public static void getProductbyName(String name)
	{
		Connection con = ConnectToDB.getConnection();
		String sql="select i.productid,i.branchid,i.sizes,i.price,i.quantity,p.productname  from inventory i, products p where i.productid=p.productid and productName like '%"+name+"%'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()==false)
				System.out.println(" no product found by the name :"+name);
			else
			{
				do {
					System.out.println("");
					System.out.println(rs.getString("productname"));
					Inventory item = new Inventory();
					item.setProductId(rs.getInt("productId"));
					item.setBranchId(rs.getInt("branchId"));
					item.setSize(rs.getInt("sizes"));
					item.setPrice(rs.getDouble("price"));
					item.setQuantity(rs.getInt("quantity"));
					item.display();
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println(" cant display the iventory items by product name");
			e.printStackTrace();
		}
		
	}
	public static  Map<Integer, ArrayList<Double>> getProductbyIdAndBid(int pid,int bid)
	{
		Connection con = ConnectToDB.getConnection();
		String sql="select * from inventory  where productid=? and branchId=?";
		boolean exists = false;
		Map<Integer, ArrayList<Double>> hmap=null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, bid);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()==false)
				System.out.println(" no product found by the product id :"+pid+" in Branch "+bid);
			else
			{
				hmap = new HashMap<Integer, ArrayList<Double>>();
				ArrayList<Double> data ;
				
				
				
				
				
				exists = true;
				do {
					Inventory item = new Inventory();
					item.setProductId(rs.getInt("productId"));
					item.setBranchId(rs.getInt("branchId"));
					item.setSize(rs.getInt("sizes"));
					item.setPrice(rs.getDouble("price"));
					item.setQuantity(rs.getInt("quantity"));
					item.display();
					
					data= new ArrayList<Double>();
					data.add((double) item.getQuantity());
					data.add(item.getPrice());
					hmap.put(item.getSize(),data);
				}while(rs.next());
			}
			
		} catch (SQLException e) {
			System.out.println(" cant display the iventory items by productid and size");
			e.printStackTrace();
		}
		ConnectToDB.closeConnection(con);
		return hmap;
		
	}

	public static void main(String[] args) {
//		insertIntoInventory(2);
		Map<Integer, ArrayList<Double>> hmap= new HashMap<Integer, ArrayList<Double>>();
		ArrayList<Double> data ;
		
		data= new ArrayList<Double>();
		data.add((double) 2);
		data.add((double) 3);
		hmap.put(1,data);
		hmap.put(2,data);
		System.out.println(hmap);
		
		System.out.println(hmap.containsKey(3));
		
	}
	
	
}
