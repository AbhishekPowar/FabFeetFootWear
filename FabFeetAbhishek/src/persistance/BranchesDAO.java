package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Branches;
import model.Customers;

public class BranchesDAO {

	public boolean validate(int bid, String pass) {
		boolean flag = false;
		Connection con;
		String sql = "select managerPassword from Branches where branchid = ?";
		con = ConnectToDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bid);
			ResultSet rs = ps.executeQuery();
			if (rs.next() == false)
				System.out.println("Id does not exist");
			else {
				String pass1 = rs.getString("managerPassword");
				if (pass.equalsIgnoreCase(pass1))
					flag = true;
			}

		} catch (SQLException e) {
			System.out.println("Error in BranchDAO validate");
			e.printStackTrace();
		}

		ConnectToDB.closeConnection(con);
		return flag;
	}

	public static void ShowBranchDetails() {
		Connection con;
		con = ConnectToDB.getConnection();
		String sql = " select * from branches ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next() == false)
				System.out.println("No branches exist");
			else {
				Branches branch;
				// int productId;
				// String productName;
				do {
					branch = new Branches();
					branch.setBranchId(rs.getInt("branchID"));
					branch.setBranchName(rs.getString("branchName"));
					branch.setManagerId(rs.getInt("managerId"));
					branch.setManagerPassword(rs.getString("managerPassword"));
					branch.display();

				} while (rs.next());
			}
		} catch (SQLException e) {
			System.out.println("Error in EMPDAO while  displayAll");
			e.printStackTrace();
		}

		ConnectToDB.closeConnection(con);
	}

//	public static void main(String[] args) {
//		BranchesDAO obj = new BranchesDAO();
//
//		System.out.println(obj.validate(1, "apple"));
//		System.out.println(obj.validate(1, "appple"));
//		System.out.println(obj.validate(100, "appple"));
//	
//		ShowBranchDetails();
//	}

}
